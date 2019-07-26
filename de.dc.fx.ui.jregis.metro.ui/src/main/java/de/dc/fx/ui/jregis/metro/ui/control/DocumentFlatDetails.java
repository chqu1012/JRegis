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

import de.dc.fx.ui.jregis.metro.ui.di.JRegisPlatform;
import de.dc.fx.ui.jregis.metro.ui.model.Attachment;
import de.dc.fx.ui.jregis.metro.ui.model.Document;
import de.dc.fx.ui.jregis.metro.ui.model.History;
import de.dc.fx.ui.jregis.metro.ui.repository.AttachmentRepository;
import de.dc.fx.ui.jregis.metro.ui.repository.HistoryRepository;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
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

	private Logger log = Logger.getLogger(getClass().getSimpleName());
	private Document document;

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
	}

	public void setSelection(Document document) {
		this.document = document;
		vboxReferences.getChildren().clear();
		flowPaneFiles.getChildren().clear();
		textAreaComment.clear();
		vboxFiles.getChildren().clear();
		vboxComment.getChildren().clear();
		vboxComment.getChildren().add(vboxCommentEditBox);

		// Fill References
		for (int i = 0; i < 10; i++) {
			vboxReferences.getChildren().add(new Button("sssssssss"));
		}

		// Fill Histories
		List<History> histories = JRegisPlatform.getInstance(HistoryRepository.class).findAll();
		histories.stream().filter(e -> e.getDocumentId() == document.getId()).forEach(e->{
			addAttachment(e);
			addHistory(e);
		});
		
		labelFilesCount.textProperty().bind(Bindings.format("(%d)", Bindings.size(vboxFiles.getChildren())));
		labelCommentCount.textProperty().bind(Bindings.format("(%d)", Bindings.size(vboxComment.getChildren()).subtract(1)));
		labelReferenceCount.textProperty().bind(Bindings.format("(%d)", Bindings.size(vboxReferences.getChildren())));
		
		labelCreatedOn.setText(document.getCreatedOnAsString());
		labelUpdatedOn.setText(document.getUpdatedOnAsString());
		labelDocumentDescription.setText(document.getDescription());
		labelDocumentName.setText(document.getName());
		labelDocumentId.setText(String.format("JREG-%05d", document.getId()));
		
		root.requestFocus();
	}

	private void addAttachment(History history) {
		JRegisPlatform.getInstance(AttachmentRepository.class).findAll().stream()
			.filter(e-> e.getHistoryId()==history.getId())
			.forEach(e->{
				Attachment attachment = new Attachment(e.getName(), LocalDateTime.now(), LocalDateTime.now(), document.getId());
				vboxFiles.getChildren().add(new AttachmentControl(attachment));
				history.getAttachments().add(attachment);
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

		Optional<String> files = flowPaneFiles.getChildren().stream().map(e->((Hyperlink)e).getText()).reduce((s1,s2)->s1+","+s2);
		String fileNames = files.isPresent()? files.get() : "";
		
		History history = new History(comment, LocalDateTime.now(), LocalDateTime.now(), document.getId(),fileNames);
		JRegisPlatform.getInstance(HistoryRepository.class).save(history);

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
		if (db.hasFiles() && document!=null) {
			LocalDateTime timestamp = LocalDateTime.now();
			History history = new History("Dragged Files.", timestamp, timestamp, document.getId(), "");
			long historyId = JRegisPlatform.getInstance(HistoryRepository.class).save(history);
			db.getFiles().stream().forEach(f->{
				Attachment attachment = new Attachment(f.getName(), timestamp, timestamp, historyId);
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
}
