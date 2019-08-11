package de.dc.fx.ui.jregis.metro.ui.control.document.management;

import static de.dc.fx.ui.jregis.metro.ui.control.document.management.DocumentFileItem.getFileIcon;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.controlsfx.control.Notifications;
import org.controlsfx.control.Rating;

import com.google.common.eventbus.Subscribe;

import de.dc.fx.ui.jregis.metro.ui.control.binding.DocumentContext;
import de.dc.fx.ui.jregis.metro.ui.control.document.management.feature.ReferenceListCellFeature;
import de.dc.fx.ui.jregis.metro.ui.control.screenshot.ScreenshotPreview;
import de.dc.fx.ui.jregis.metro.ui.di.JRegisPlatform;
import de.dc.fx.ui.jregis.metro.ui.eventbus.EventContext;
import de.dc.fx.ui.jregis.metro.ui.eventbus.IEventBroker;
import de.dc.fx.ui.jregis.metro.ui.eventbus.IEventContext;
import de.dc.fx.ui.jregis.metro.ui.model.Attachment;
import de.dc.fx.ui.jregis.metro.ui.model.AttachmentStatus;
import de.dc.fx.ui.jregis.metro.ui.model.Document;
import de.dc.fx.ui.jregis.metro.ui.model.History;
import de.dc.fx.ui.jregis.metro.ui.model.HistoryStatus;
import de.dc.fx.ui.jregis.metro.ui.model.Reference;
import de.dc.fx.ui.jregis.metro.ui.repository.AttachmentRepository;
import de.dc.fx.ui.jregis.metro.ui.repository.ClipboardNameSuggestionRepository;
import de.dc.fx.ui.jregis.metro.ui.repository.DocumentRepository;
import de.dc.fx.ui.jregis.metro.ui.repository.HistoryRepository;
import de.dc.fx.ui.jregis.metro.ui.repository.ReferenceRepository;
import de.dc.fx.ui.jregis.metro.ui.service.AttachmentService;
import de.dc.fx.ui.jregis.metro.ui.service.DocumentFolderService;
import de.dc.fx.ui.jregis.metro.ui.service.HistoryService;
import de.dc.fx.ui.jregis.metro.ui.util.ClipboardHelper;
import de.dc.fx.ui.jregis.metro.ui.util.screenshot.ScreenshotStage;
import impl.org.controlsfx.autocompletion.AutoCompletionTextFieldBinding;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class DocumentFlatDetails extends BaseDocumentFlatDetails {

	public static final String ID_DELETE_ATTACHMENT = "/attachment/delete";
	public static final String ID_DELETE_HISTORY = "/history/delete";

	private Logger log = Logger.getLogger(getClass().getSimpleName());

	private ObservableList<History> historyList = FXCollections.observableArrayList();
	private FilteredList<History> filteredHistory = new FilteredList<>(historyList, p -> true);

	private ObservableList<String> nameSuggestionList = FXCollections.observableArrayList();
	private FilteredList<String> filteredNameSuggestion = new FilteredList<>(nameSuggestionList, p -> true);

	private ObservableList<Document> referenceAllAvailableList = FXCollections.observableArrayList();
	private FilteredList<Document> fiteredReferenceAllAvailableList = new FilteredList<>(referenceAllAvailableList, p -> true);

	private ObservableList<Document> referencedList = FXCollections.observableArrayList();
	private FilteredList<Document> fiteredReferencedList = new FilteredList<>(referencedList, p -> true);

	private List<Reference> referencesRegistry = new ArrayList<>();

	private DocumentPreview documentPreview = new DocumentPreview();
	
	private Rating rating = new Rating(5);
	
	private DocumentContext context = new DocumentContext();

	public DocumentFlatDetails() {
		FXMLLoader fxmlLoader = new FXMLLoader(
				getClass().getResource("/de/dc/fx/ui/jregis/metro/ui/control/document/management/DocumentFlatDetails.fxml"));
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

		List<String> fileNames = JRegisPlatform.getInstance(ClipboardNameSuggestionRepository.class).findAll();
		nameSuggestionList.addAll(fileNames);

		new AutoCompletionTextFieldBinding<>(textFilename, param -> {
			filteredNameSuggestion.setPredicate(p -> p.toLowerCase().contains(param.getUserText().toLowerCase()));
			return filteredNameSuggestion;
		});

		hboxTitle.getChildren().add(rating);
		
		initBindings();
		initReferenceDialog();
		
		mainContent.getChildren().add(documentPreview);
		documentPreview.toBack();
	}

	private void initReferenceDialog() {
		//texytToReferencedDocument.textProperty().bind(Bindings.format("JREG-%05d: %s", context.current.get().getId(), context.current.get().getName()));
		
		referenceAllAvailableList.addAll(JRegisPlatform.getInstance(DocumentRepository.class).findAll());
		
		listViewAllAvailableDocuments.setItems(fiteredReferenceAllAvailableList);
		listViewReferencedDocuments.setItems(fiteredReferencedList);
		
		labelAllAvailableDocumentsCounter.textProperty().bind(Bindings.format("(%d)", Bindings.size(fiteredReferenceAllAvailableList)));
		labelReferencedDocumentCounter.textProperty().bind(Bindings.format("(%d)", Bindings.size(fiteredReferencedList)));
		
		listViewAllAvailableDocuments.setCellFactory(param -> new ReferenceListCellFeature());
		listViewReferencedDocuments.setCellFactory(param -> new ReferenceListCellFeature());
		
		textSearchForAvailableDocuments.textProperty().addListener((observable, oldValue, newValue) -> fiteredReferenceAllAvailableList.setPredicate(p->{
			boolean isNewValueEmpty = newValue==null || newValue.isEmpty();
			boolean isNameEquals = p.getName().toLowerCase().contains(newValue.toLowerCase());
			boolean isIdEquals = String.valueOf(p.getId()).contains(newValue);
			return isNewValueEmpty || isNameEquals || isIdEquals;
		}));
		
		textSearchForReferencedDocuments.textProperty().addListener((observable, oldValue, newValue) -> fiteredReferencedList.setPredicate(p->{
			boolean isNewValueEmpty = newValue==null || newValue.isEmpty();
			boolean isNameEquals = p.getName().toLowerCase().contains(newValue.toLowerCase());
			boolean isIdEquals = String.valueOf(p.getId()).contains(newValue);
			return isNewValueEmpty || isNameEquals || isIdEquals;
		}));
	}
	
	private void initBindings() {
		// Document Properties
		textAreaComment.textProperty().bindBidirectional(context.documentComment);
		labelDocumentName.textProperty().bind(context.documentName);
		labelDocumentId.textProperty().bind(context.documentId);
		labelDocumentDescription.textProperty().bind(context.documentDescription);
		labelCreatedOn.textProperty().bind(context.documentCreatedOn);
		labelUpdatedOn.textProperty().bind(context.documentUpdatedOn);

		textAreaComment.textProperty().bindBidirectional(context.documentComment);

		// Counters
		labelFilesCount.textProperty().bind(context.countFile);
		labelCommentCount.textProperty().bind(context.countComment);
		labelReferenceCount.textProperty().bind(context.countReference);
		context.countFile.bind(Bindings.format("(%d)", Bindings.size(vboxFiles.getChildren())));
		context.countComment.bind(Bindings.format("(%d)", Bindings.size(vboxComment.getChildren()).subtract(1)));
		context.countReference.bind(Bindings.format("(%d)", Bindings.size(vboxReferences.getChildren())));

		// Webdownload Dialog
		buttonDownloadDialogAccept.disableProperty().bind(context.downloadFileName.isEmpty());
		textDownloadFileID.textProperty().bindBidirectional(context.downloadFileID);
		textDownloadFilename.textProperty().bindBidirectional(context.downloadFileName);
		textDownloadTransactionMessage.textProperty().bindBidirectional(context.downloadTransactionMessage);
		textDownloadTUrl.textProperty().bindBidirectional(context.downloadUrl);

		// Clipboard Dialog
		buttonClipboardHelperAccept.disableProperty().bind(context.clipboardFileName.isEmpty());
		textFilename.textProperty().bindBidirectional(context.clipboardFileName);
		textFileID.textProperty().bindBidirectional(context.clipboardFileID);
		textTransactionMessage.textProperty().bindBidirectional(context.clipboardTransactionMessage);
		imageViewClipboard.imageProperty().bindBidirectional(context.clipboardImageContent);
		
		// Add Listeners
		context.current.addListener(this::onDocumentChanged);
		context.toOpenFile.addListener(this::onOpenFileChanged);
	}

	@Subscribe
	public void setDocumentViaEventBroker(EventContext<Document> context) {
		if (context.getEventId().equals("/set/current/doccument")) {
			setSelection(context.getInput());
		}
	}
	
	@Subscribe
	public void openFileAttachmentViaEventBroker(EventContext<String> context) {
		if (context.getEventId().contentEquals("/open/file/attachment")) {
			onOpenFileChanged(null, null, context.getInput());
		}
	}
	
	private void onOpenFileChanged(ObservableValue<? extends String> obs, String oldValue, String newValue) {
		try {
			File file = JRegisPlatform.getInstance(DocumentFolderService.class).getAttachmentByName(context.current.get(), newValue);
			documentPreview.show(file);
			root.setVvalue(0d);
		} catch (Exception e) {
			Notifications.create().darkStyle().text(e.getLocalizedMessage()).title("File Error").showError();
		}
	}

	private void onDocumentChanged(ObservableValue<? extends Document> obs, Document oldValue,
			Document newValue) {
		vboxReferences.getChildren().clear();
		flowPaneFiles.getChildren().clear();
		vboxFiles.getChildren().clear();
		referencesRegistry.clear();
		
		context.documentComment.set("");

		rating.setRating(0);
		
		// Fill References
		List<Reference> references = JRegisPlatform.getInstance(ReferenceRepository.class).findAll();
		references = references.stream().filter(e-> e.getFirstId()==context.current.get().getId()).collect(Collectors.toList());
		references.forEach(e->vboxReferences.getChildren().add(new ReferenceControl(e, false)));
		// Parent References
		references = JRegisPlatform.getInstance(ReferenceRepository.class).findAll();
		references = references.stream().filter(e-> e.getSecondId()==context.current.get().getId()).collect(Collectors.toList());
		references.forEach(e->{
			referencesRegistry.add(e);
			vboxReferences.getChildren().add(new ReferenceControl(e, true));
		});
		
		populateHistoryList(newValue);

		// Set document properties
		context.documentCreatedOn.set(newValue.getCreatedOnAsString());
		context.documentUpdatedOn.set(newValue.getUpdatedOnAsString());
		context.documentDescription.set(newValue.getDescription());
		context.documentId.set(String.format("JREG-%05d", newValue.getId()));
		context.documentName.set(newValue.getName());
	}

	public void setSelection(Document document) {
		context.current.set(document);

		// Used focus for handle escape key
		root.requestFocus();
	}

	private void populateHistoryList(Document document) {
		vboxComment.getChildren().clear();
		vboxComment.getChildren().add(vboxCommentEditBox);
		vboxFiles.getChildren().clear();
		
		filteredHistory.setPredicate(e -> {
			boolean filterCriteria = e.getDocumentId() == document.getId();
			if (checkBoxShowDeletedComments.isSelected()) {
				filterCriteria = filterCriteria && e.getStatus() == HistoryStatus.ADD.getStatusValue();
			}
			return filterCriteria;
		});
		filteredHistory.stream().forEach(e -> {
			// Workaround: Fix oherwise on each click attachments will be added
			e.getAttachments().clear();
			addAttachment(e);
			addHistory(e);
		});
		
		if (vboxComment.getChildren().size()==1) {
			File[] contents = JRegisPlatform.getInstance(DocumentFolderService.class).getFolderContent(context.current.get());
			if (contents.length>0) {
				HistoryRepository historyRepository = JRegisPlatform.getInstance(HistoryRepository.class);
				AttachmentRepository attachmentRepository = JRegisPlatform.getInstance(AttachmentRepository.class);
				
				LocalDateTime createdOn = context.current.get().getCreatedOn();
				LocalDateTime updatedOn = LocalDateTime.now();
				Long documentId = context.current.get().getId();
				History history = new History("Reimport file(s) to history, because no history available.", createdOn , updatedOn, documentId );
				long historyId = historyRepository.save(history);
				history.setId(historyId);
				
				for (File file : contents) {
					Attachment attachment = new Attachment(file.getName(), createdOn, updatedOn, historyId);
					long attachmentId = attachmentRepository.save(attachment);
					attachment.setId(attachmentId);
					history.getAttachments().add(attachment);
				}
				addHistory(history);
			}
		}
	}

	private void addAttachment(History history) {
		JRegisPlatform.getInstance(AttachmentRepository.class).findAll().stream()
				.filter(e -> e.getHistoryId() == history.getId())
				.filter(e -> e.getStatus() == AttachmentStatus.ADD.getStatusValue()).forEach(e -> {
					vboxFiles.getChildren().add(new AttachmentControl(e));
					history.getAttachments().add(e);
				});
	}

	private void addHistory(History history) {
		DocumentHistoryItem item = new DocumentHistoryItem();
		item.setHistory(history, t -> context.toOpenFile.set(t));
		vboxComment.getChildren().add(item);
	}

	@Override
	protected void onLinkBackAction(ActionEvent event) {
		root.toBack();
	}

	@Override
	protected void onButtonSubmitComment(ActionEvent event) {
		History history = JRegisPlatform.getInstance(HistoryService.class).create(context);

		flowPaneFiles.getChildren().stream().forEach(e -> {
			try {
				JRegisPlatform.getInstance(DocumentFolderService.class).copyFile(context.current.get(),
						e.getAccessibleText());
			} catch (IOException e1) {
				Notifications.create().darkStyle().text("Failed to copy file " + e.getAccessibleText())
						.title("File Copy Error!").show();
				return;
			}

			Attachment attachment = JRegisPlatform.getInstance(AttachmentService.class).create(history, ((Hyperlink) e).getText());

			vboxFiles.getChildren().add(new AttachmentControl(attachment));
			history.getAttachments().add(attachment);
		});

		textAreaComment.clear();
		flowPaneFiles.getChildren().clear();

		Notifications.create().title("New Comment").text("Created new comment with attachments!").darkStyle().show();

		addHistory(history);
	}

	@Override
	protected void onButtonAttachmentsAction(ActionEvent event) {
		FileChooser chooser = new FileChooser();
		List<File> files = chooser.showOpenMultipleDialog(new Stage());
		if (files != null) {
			files.stream().forEach(e -> {
				Hyperlink link = new Hyperlink(e.getName(), new ImageView(getFileIcon(e.getName())));
				link.setAccessibleText(e.getAbsolutePath());
				flowPaneFiles.getChildren().add(link);
			});
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
		if (db.hasFiles()) {
			LocalDateTime timestamp = LocalDateTime.now();

			context.documentComment.set("Dragged Files.");
			History history = JRegisPlatform.getInstance(HistoryService.class).create(context);
			
			String destination = JRegisPlatform.getInstance(DocumentFolderService.class)
					.getFolderBy(context.current.get()).getAbsolutePath();

			db.getFiles().stream().forEach(f -> {
				Attachment attachment = new Attachment(f.getName(), timestamp, timestamp, history.getId());

				JRegisPlatform.getInstance(DocumentFolderService.class).copyFileTo(f, new File(destination, f.getName()));
				JRegisPlatform.getInstance(AttachmentRepository.class).save(attachment);
				
				vboxFiles.getChildren().add(new AttachmentControl(attachment));
				history.getAttachments().add(attachment);
			});
			addHistory(history);

			success = true;
			Optional<String> files = db.getFiles().stream().map(File::getName).reduce((e1, e2) -> e1 + "," + e2);
			files.ifPresent(s -> Notifications.create().title("Clipboard Notification")
					.text("Import file(s): " + s + " sucessfully!")
					.onAction(e -> onOpenFileChanged(null, null, destination))
					.darkStyle().showInformation());
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
	public void restoreStage(EventContext<Image> context) {
		if (context.getEventId().equals("/store/add/screenshot/image")) {
			Stage mainStage = (Stage) root.getScene().getWindow();
			mainStage.setIconified(false);
			
			LocalDateTime createdOn = LocalDateTime.now();
			History history = new History("Added Screenshot", createdOn , createdOn, this.context.current.get().getId());
			long historyId = JRegisPlatform.getInstance(HistoryRepository.class).save(history);
			history.setId(historyId);
			
			String dateFormat = new SimpleDateFormat("yyyy-MM-dd_HHmmss").format(new Date());
			Attachment attachment = new Attachment(dateFormat+"_Screenshot.png", createdOn, createdOn, historyId);
			long attachmentId = JRegisPlatform.getInstance(AttachmentRepository.class).save(attachment);
			attachment.setId(attachmentId);
			history.getAttachments().add(attachment);
			
			JRegisPlatform.getInstance(DocumentFolderService.class).copyImageTo(this.context.current.get(), dateFormat+"_Screenshot.png", context.getInput());
			
			addHistory(history);
		}
	}

	@Subscribe
	public void deleteHistory(IEventContext<History> context) {
		if (context.getEventId().equals(ID_DELETE_HISTORY)) {
			History input = context.getInput();
			DocumentHistoryItem toDeleteItem = null;
			for (Node node : vboxComment.getChildren()) {
				if (node instanceof DocumentHistoryItem) {
					DocumentHistoryItem item = (DocumentHistoryItem) node;
					if (item.isHistory(input)) {
						toDeleteItem = item;
					}
				}
			}

			if (toDeleteItem != null) {
				vboxComment.getChildren().remove(toDeleteItem);
			}

			JRegisPlatform.getInstance(HistoryRepository.class).delete(input);

			Notifications.create().title("Delete").text("Delete Comment with ID: " + input.getId()).darkStyle().show();
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
			if (toDeleteControl != null) {
				vboxFiles.getChildren().remove(toDeleteControl);
			}
			vboxComment.getChildren().forEach(e -> {
				if (e instanceof DocumentHistoryItem) {
					DocumentHistoryItem item = (DocumentHistoryItem) e;
					item.findAndDeactivateAttachment(input);
				}
			});

			this.context.documentComment.set("Delete selected file " + input.getName());
			History history = JRegisPlatform.getInstance(HistoryService.class).delete(this.context);

			history.getAttachments().add(input);
			addHistory(history);

			historyList.add(history);
		}
	}

	@Override
	protected void onCheckBoxShowDeletedCommentsAction(ActionEvent event) {
		populateHistoryList(context.current.get());
	}

	@Override
	protected void onButtonClipboardHelperAcceptAction(ActionEvent event) {
		clipboardHelperDialog.toBack();
		clipboardHelperDialog.setVisible(false);

		context.documentComment.set(context.clipboardTransactionMessage.get());
		History history = JRegisPlatform.getInstance(HistoryService.class).create(context);
		JRegisPlatform.getInstance(DocumentFolderService.class).copyImageTo(context);

		Attachment attachment = JRegisPlatform.getInstance(AttachmentService.class).create(history, context.clipboardFileName.get()+".png");
		
		Notifications.create().text("Added File " + attachment.getName() + " from Clipboard").title("File Clipboard")
				.darkStyle().show();

		addHistory(history);
		vboxFiles.getChildren().add(new AttachmentControl(attachment));
	}

	@Override
	protected void onLinkClipboardHelperCancelAction(ActionEvent event) {
		clipboardHelperDialog.toBack();
		clipboardHelperDialog.setVisible(false);
	}

	@Override
	protected void onButtonClipboardHelperAction(ActionEvent event) {
		clipboardHelperDialog.setVisible(true);
		clipboardHelperDialog.toFront();

		ClipboardHelper.getImage().ifPresent(e -> {
			imageViewClipboard.setFitHeight(e.getHeight());
			imageViewClipboard.setFitWidth(e.getWidth());
			context.clipboardImageContent.set(e);
		});
	}

	@Override
	protected void onImageViewClipboardHelperClicked(MouseEvent event) {
		if (event.getClickCount() == 2) {
			ClipboardHelper.getImage().ifPresent(e -> {
				imageViewClipboard.setFitHeight(e.getHeight());
				imageViewClipboard.setFitWidth(e.getWidth());
				context.clipboardImageContent.set(e);
			});
		}
	}

	@Override
	protected void onLinkAddNewSuggestionAction(ActionEvent event) {
		if (textFilename.getText().isEmpty()) {
			Notifications.create().text("File Name cannot be empty").title("File Name Suggestion").darkStyle()
					.showWarning();
		} else {
			String name = textFilename.getText();
			JRegisPlatform.getInstance(ClipboardNameSuggestionRepository.class).save(name);

			nameSuggestionList.add(name);
		}
	}

	@Override
	protected void onLinkDeleteNewSuggestionAction(ActionEvent event) {
		if (textFilename.getText().isEmpty()) {
			Notifications.create().text("File Name cannot be empty").title("File Name Suggestion").darkStyle()
					.showWarning();
		} else {
			String name = textFilename.getText();
			JRegisPlatform.getInstance(ClipboardNameSuggestionRepository.class).delete(name);

			nameSuggestionList.remove(name);
		}
	}

	@Override
	protected void onLinkDownloadDialogAcceptAction(ActionEvent event) {
		if (context.downloadUrl.get().isEmpty()) {
			Notifications.create().darkStyle().text("Url cannot be empty!").title("Url Parse Error").showWarning();
			return;
		} else {
			try {
				File file = JRegisPlatform.getInstance(DocumentFolderService.class).downloadFile(context);
				Notifications.create().darkStyle().text("Download url to " + context.downloadUrl.get())
						.title("Download Finished").onAction(e1 -> onOpenFileChanged(null, null, file.getParent()))
						.showInformation();

				context.documentComment.set(context.downloadTransactionMessage.get());
				History history = JRegisPlatform.getInstance(HistoryService.class).create(context);
				
				Attachment attachment = new Attachment(context.downloadFileName.get(), LocalDateTime.now(), LocalDateTime.now(), history.getId());
				JRegisPlatform.getInstance(AttachmentRepository.class).save(attachment);
				
				history.getAttachments().add(attachment);
				
				vboxFiles.getChildren().add(new AttachmentControl(attachment));
				
				addHistory(history);
			} catch (IOException e) {
				Notifications.create().darkStyle()
						.text(e.getLocalizedMessage())
						.title("Error on Downloading").showError();
				return;
			}
		}

		downloadDialog.setVisible(false);
		downloadDialog.toBack();
	}

	@Override
	protected void onLinkDownloadDialogCancelAction(ActionEvent event) {
		downloadDialog.setVisible(false);
		downloadDialog.toBack();
	}

	@Override
	protected void onButtonDownloadDialogAction(ActionEvent event) {
		context.downloadUrl.set(ClipboardHelper.getString());
		
		downloadDialog.setVisible(true);
		downloadDialog.toFront();
	}

	@Override
	protected void onImageViewDownloadClipboardClicked(MouseEvent event) {
		context.downloadUrl.set(ClipboardHelper.getString());
	}

	@Override
	protected void onImageViewOpenFolder(MouseEvent event) {
		try {
			JRegisPlatform.getInstance(DocumentFolderService.class).openFolder(context.current.get());
		} catch (Exception e) {
			Notifications.create().darkStyle()
			.text(e.getLocalizedMessage())
			.title("Failed to open folder!").showError();
		}
	}

	@Override
	protected void onButtonReferenceDialogApply(ActionEvent event) {
		referenceDialog.setVisible(false);
		referenceDialog.toBack();
		
		LocalDateTime createdOn = LocalDateTime.now();
		long firstId = context.current.get().getId();

		referencedList.forEach(e->{
			long secondId = e.getId();
			JRegisPlatform.getInstance(ReferenceRepository.class).save(new Reference(createdOn , createdOn, 0, firstId, secondId));
		});
	}

	@Override
	protected void onButtonSelectAllDocument(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onButtonSelectDocument(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onButtonUnselectAllDocument(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onButtonUnselectDocument(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onLinkCancelReferenceDialog(ActionEvent event) {
		referenceDialog.setVisible(false);
		referenceDialog.toBack();		
	}

	@Override
	protected void onButtonOpenReferenceDialog(ActionEvent event) {
		referenceDialog.toFront();
		referenceDialog.setVisible(true);
	}
	
	@Override
	protected void onReferenceDialogKeyPressed(KeyEvent event) {
		if (event.getCode().equals(KeyCode.ESCAPE)) {
			onLinkCancelReferenceDialog(null);
		}
	}

	@Override
	protected void onListViewAllAvailableDocuments(MouseEvent event) {
		Document selection = listViewAllAvailableDocuments.getSelectionModel().getSelectedItem();
		if (selection!=null && event.getClickCount()==2) {
			referencedList.add(selection);
			referenceAllAvailableList.remove(selection);
		}		
	}

	@Override
	protected void onListViewReferencedDocuments(MouseEvent event) {
		Document selection = listViewReferencedDocuments.getSelectionModel().getSelectedItem();
		if (selection!=null && event.getClickCount()==2) {
			referenceAllAvailableList.add(selection);
			referencedList.remove(selection);
		}
	}

	@Override
	protected void onButtonScreenshotAction(ActionEvent event) {
		Stage mainStage = (Stage) root.getScene().getWindow();
		mainStage.setIconified(true);
		
		ScreenshotStage stage = new ScreenshotStage(false);
		stage.show();
	}

	@Override
	protected void onButtonFullScreenshotAction(ActionEvent event) {
		Stage mainStage = (Stage) root.getScene().getWindow();
		mainStage.setIconified(true);
		
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		ScreenshotStage stage = new ScreenshotStage(true);
		stage.show();
		
	}
}
