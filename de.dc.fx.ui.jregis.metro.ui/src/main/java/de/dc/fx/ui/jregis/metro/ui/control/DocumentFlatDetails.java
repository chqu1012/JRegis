package de.dc.fx.ui.jregis.metro.ui.control;

import static de.dc.fx.ui.jregis.metro.ui.control.DocumentFileItem.getFileIcon;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.controlsfx.control.Notifications;

import com.google.common.eventbus.Subscribe;

import de.dc.fx.ui.jregis.metro.ui.di.JRegisPlatform;
import de.dc.fx.ui.jregis.metro.ui.eventbus.IEventBroker;
import de.dc.fx.ui.jregis.metro.ui.eventbus.IEventContext;
import de.dc.fx.ui.jregis.metro.ui.model.Attachment;
import de.dc.fx.ui.jregis.metro.ui.model.AttachmentStatus;
import de.dc.fx.ui.jregis.metro.ui.model.Document;
import de.dc.fx.ui.jregis.metro.ui.model.History;
import de.dc.fx.ui.jregis.metro.ui.model.HistoryStatus;
import de.dc.fx.ui.jregis.metro.ui.repository.AttachmentRepository;
import de.dc.fx.ui.jregis.metro.ui.repository.HistoryRepository;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.TransferMode;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class DocumentFlatDetails extends BaseDocumentFlatDetails {

	public static final String ID_DELETE_ATTACHMENT = "/attachment/delete";
	public static final String ID_DELETE_HISTORY = "/history/delete";
	
	private Logger log = Logger.getLogger(getClass().getSimpleName());
	private boolean showDeletedHistories = false;
	private ObjectProperty<Document> documentProperty = new SimpleObjectProperty<Document>();
	private ObservableList<History> historyList = FXCollections.observableArrayList();
	private FilteredList<History> filteredHistory = new FilteredList<>(historyList, p-> true);
	
	public DocumentFlatDetails() {
		FXMLLoader fxmlLoader = new FXMLLoader(
				getClass().getResource("/de/dc/fx/ui/jregis/metro/ui/DocumentFlatDetails.fxml"));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);

		try {
			fxmlLoader.load();
		} catch (IOException exception) {
			log.log(Level.SEVERE, "Failed to load fxml ", exception);
		}
		
		JRegisPlatform.getInstance(IEventBroker.class).register(this);
		
		// Fill Histories
		List<History> histories = JRegisPlatform.getInstance(HistoryRepository.class).findAll();
		historyList.addAll(histories);
		
		documentProperty.addListener(this::onDocumentChanged);
	}
	
	private void onDocumentChanged(ObservableValue<? extends Document> observable, Document oldValue,
			Document newValue) {
		vboxReferences.getChildren().clear();
		flowPaneFiles.getChildren().clear();
		textAreaComment.clear();

		// Fill References
		for (int i = 0; i < 10; i++) {
			vboxReferences.getChildren().add(new Button("sssssssss"));
		}
		
		populateHistoryList(newValue);

		labelFilesCount.textProperty().bind(Bindings.format("(%d)", Bindings.size(vboxFiles.getChildren())));
		labelCommentCount.textProperty().bind(Bindings.format("(%d)", Bindings.size(vboxComment.getChildren()).subtract(1)));
		labelReferenceCount.textProperty().bind(Bindings.format("(%d)", Bindings.size(vboxReferences.getChildren())));
		
		labelCreatedOn.setText(newValue.getCreatedOnAsString());
		labelUpdatedOn.setText(newValue.getUpdatedOnAsString());
		labelDocumentDescription.setText(newValue.getDescription());
		labelDocumentName.setText(newValue.getName());
		labelDocumentId.setText(String.format("JREG-%05d", newValue.getId()));
	}

	public void setSelection(Document document) {
		documentProperty.set(document);
		
		// Used focus for handle escape key
		root.requestFocus();
	}
	
	private void populateHistoryList(Document document) {
		showDeletedHistories = checkBoxShowDeletedComments.isSelected();
		
		vboxFiles.getChildren().clear();
		vboxComment.getChildren().clear();
		vboxComment.getChildren().add(vboxCommentEditBox);
		
		filteredHistory.setPredicate(e->{
			boolean filterCriteria = e.getDocumentId() == document.getId();
			if (showDeletedHistories) {
				filterCriteria = filterCriteria && e.getStatus() == HistoryStatus.ADD.getStatusValue();
			}
			return filterCriteria;
		});
		filteredHistory.stream().forEach(e->{
			// Workaround: Fix oherwise on each click attachments will be added
			e.getAttachments().clear();
			addAttachment(e);
			addHistory(e);
		});
	}

	private void addAttachment(History history) {
		JRegisPlatform.getInstance(AttachmentRepository.class).findAll().stream()
			.filter(e-> e.getHistoryId()==history.getId())
			.filter(e-> e.getStatus()==AttachmentStatus.ADD.getStatusValue())
			.forEach(e->{
				vboxFiles.getChildren().add(new AttachmentControl(e));
				history.getAttachments().add(e);
			});
	}

	private void addHistory(History history) {
		DocumentHistoryItem item = new DocumentHistoryItem();
		item.setHistory(history, t -> {
//		String path = parentPath+"/"+t;
//		openFileExecuter.accept(path);
		});
		vboxComment.getChildren().add(item);
	}

	@Override
	protected void onLinkBackAction(ActionEvent event) {
		root.toBack();
	}

	@Override
	protected void onButtonSubmitComment(ActionEvent event) {
		String comment = textAreaComment.getText();
		textAreaComment.clear();

		History history = new History(comment, LocalDateTime.now(), LocalDateTime.now(), documentProperty.get().getId());
		history.setStatus(HistoryStatus.ADD.getStatusValue());
		
		long historyId = JRegisPlatform.getInstance(HistoryRepository.class).save(history);

		flowPaneFiles.getChildren().stream().forEach(e->{
			LocalDateTime created = LocalDateTime.now();
			
			Attachment attachment = new Attachment(((Hyperlink)e).getText(), created, created, historyId);
			attachment.setStatus(AttachmentStatus.ADD.getStatusValue());
			JRegisPlatform.getInstance(AttachmentRepository.class).save(attachment);
			
			vboxFiles.getChildren().add(new AttachmentControl(attachment));
			history.getAttachments().add(attachment);
		});
		
		Notifications.create().title("New Comment").text("Created new comment with attachments!").darkStyle().show();

		addHistory(history);
	}

	@Override
	protected void onButtonAttachmentsAction(ActionEvent event) {
		FileChooser chooser = new FileChooser();
		List<File> files = chooser.showOpenMultipleDialog(new Stage());
		if (files != null) {
			flowPaneFiles.getChildren().clear();
			files.stream().forEach(e -> flowPaneFiles.getChildren()
					.add(new Hyperlink(e.getName(), new ImageView(getFileIcon(e.getName())))));
		}

		if (textAreaComment.getText().isEmpty()) {
			textAreaComment.setText("Attached files from os.");
		}
	}

	@Override
	protected void onScrollPaneKeyPressed(KeyEvent e) {
		if (e.getCode().equals(KeyCode.ESCAPE)) {
			root.toBack();
		}
	}
	
	@Override
	protected void onVBoxDraggingFileBoxDragDropped(DragEvent event) {
		Dragboard db = event.getDragboard();
		boolean success = false;
		if (db.hasFiles() && documentProperty.get()!=null) {
			LocalDateTime timestamp = LocalDateTime.now();
			History history = new History("Dragged Files.", timestamp, timestamp, documentProperty.get().getId());
			history.setStatus(HistoryStatus.ADD.getStatusValue());
			
			long historyId = JRegisPlatform.getInstance(HistoryRepository.class).save(history);
			db.getFiles().stream().forEach(f->{
				Attachment attachment = new Attachment(f.getName(), timestamp, timestamp, historyId);
				attachment.setStatus(AttachmentStatus.ADD.getStatusValue());
				
				JRegisPlatform.getInstance(AttachmentRepository.class).save(attachment);
				vboxFiles.getChildren().add(new AttachmentControl(attachment));
				history.getAttachments().add(attachment);
			});
			addHistory(history);
			
			success = true;
			Optional<String> files = db.getFiles().stream().map(File::getName).reduce((e1, e2)->e1+","+e2);
			files.ifPresent(s->Notifications.create().title("Clipboard Notification").text("Import file(s): " + s + " sucessfully!").darkStyle().showInformation());
		}
		labelDraggingFilesArea.getStyleClass().clear();
		labelDraggingFilesArea.getStyleClass().add("dragged-file-label");
		event.setDropCompleted(success);
		event.consume();		
	}

	@Override
	protected void onVBoxDraggingFileBoxDragOver(DragEvent event) {
		labelDraggingFilesArea.getStyleClass().clear();
		labelDraggingFilesArea.getStyleClass().add("dragged-file-label-dragged");
		if (event.getDragboard().hasFiles()) {
			event.acceptTransferModes(TransferMode.COPY);
		}
		event.consume();		
	}
	
	@Subscribe 
	public void deleteHistory(IEventContext<History> context) {
		if (context.getEventId().equals(ID_DELETE_HISTORY)) {
			History input = context.getInput();
			DocumentHistoryItem toDeleteItem = null;
			for (Node node : vboxComment.getChildren()) {
				if (node instanceof DocumentHistoryItem) {
					DocumentHistoryItem item = (DocumentHistoryItem) node;
					if(item.isHistory(input)){
						toDeleteItem = item;
					}
				}
			}
			
			if (toDeleteItem!=null) {
				vboxComment.getChildren().remove(toDeleteItem);
			}
			
			JRegisPlatform.getInstance(HistoryRepository.class).delete(input);
			
			Notifications.create().title("Delete").text("Delete Comment with ID: "+input.getId()).darkStyle().show();
		}
	}
	
	@Subscribe
	public void deleteAttachment(IEventContext<Attachment> context) {
		if (context.getEventId().equals(ID_DELETE_ATTACHMENT)) {
			Attachment input = context.getInput();
			AttachmentControl toDeleteControl = null;
			for (Node node : vboxFiles.getChildren()) {
				if (node instanceof AttachmentControl) {
					AttachmentControl attachmentControl = (AttachmentControl) node;
					if (attachmentControl.getAttachment().equals(input)) {
						toDeleteControl = attachmentControl;
						JRegisPlatform.getInstance(AttachmentRepository.class).delete(input);
					}					
				}
			}
			if (toDeleteControl!=null) {
				vboxFiles.getChildren().remove(toDeleteControl);
			}
			vboxComment.getChildren().forEach(e-> {
				if (e instanceof DocumentHistoryItem) {
					DocumentHistoryItem item = (DocumentHistoryItem) e;
					item.findAndDeactivateAttachment(input);
				}
			});
			
			History history = new History("Delete selected file "+input.getName(), LocalDateTime.now(), LocalDateTime.now(), documentProperty.get().getId());
			history.setStatus(HistoryStatus.DELETE.getStatusValue());
			
			history.getAttachments().add(input);
			JRegisPlatform.getInstance(HistoryRepository.class).save(history);
			addHistory(history);
		}
	}

	@Override
	protected void onCheckBoxShowDeletedCommentsAction(ActionEvent event) {
		populateHistoryList(documentProperty.get());		
	}
}
