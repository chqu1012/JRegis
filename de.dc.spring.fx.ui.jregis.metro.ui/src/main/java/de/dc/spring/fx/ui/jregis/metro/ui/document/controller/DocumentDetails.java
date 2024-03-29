package de.dc.spring.fx.ui.jregis.metro.ui.document.controller;

import static de.dc.spring.fx.ui.jregis.metro.ui.document.controller.DocumentFileItem.getFileIcon;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.controlsfx.control.Notifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.google.common.eventbus.Subscribe;

import de.dc.spring.fx.ui.jregis.metro.ui.clipboard.model.ClipboardFileNameSuggestion;
import de.dc.spring.fx.ui.jregis.metro.ui.clipboard.respository.ClipboardFileNameSuggestionRepository;
import de.dc.spring.fx.ui.jregis.metro.ui.document.BaseDocumentDetails;
import de.dc.spring.fx.ui.jregis.metro.ui.document.factory.ReferenceListCellFeature;
import de.dc.spring.fx.ui.jregis.metro.ui.document.model.Document;
import de.dc.spring.fx.ui.jregis.metro.ui.document.model.DocumentAttachment;
import de.dc.spring.fx.ui.jregis.metro.ui.document.model.DocumentAttachmentStatus;
import de.dc.spring.fx.ui.jregis.metro.ui.document.model.DocumentContext;
import de.dc.spring.fx.ui.jregis.metro.ui.document.model.DocumentHistory;
import de.dc.spring.fx.ui.jregis.metro.ui.document.model.DocumentHistoryStatus;
import de.dc.spring.fx.ui.jregis.metro.ui.document.model.DocumentReference;
import de.dc.spring.fx.ui.jregis.metro.ui.document.repository.DocumentHistoryRepository;
import de.dc.spring.fx.ui.jregis.metro.ui.document.repository.DocumentRepository;
import de.dc.spring.fx.ui.jregis.metro.ui.document.service.DocumentAttachmentService;
import de.dc.spring.fx.ui.jregis.metro.ui.document.service.DocumentFolderService;
import de.dc.spring.fx.ui.jregis.metro.ui.document.service.DocumentHistoryService;
import de.dc.spring.fx.ui.jregis.metro.ui.document.service.DocumentReferenceService;
import de.dc.spring.fx.ui.jregis.metro.ui.events.EventBroker;
import de.dc.spring.fx.ui.jregis.metro.ui.events.EventContext;
import de.dc.spring.fx.ui.jregis.metro.ui.screenshot.ScreenshotStage;
import de.dc.spring.fx.ui.jregis.metro.ui.screenshot.model.ScreenshotContext;
import de.dc.spring.fx.ui.jregis.metro.ui.util.ClipboardHelper;
import impl.org.controlsfx.autocompletion.AutoCompletionTextFieldBinding;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
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

@Controller
public class DocumentDetails extends BaseDocumentDetails {

	private DocumentContext context = new DocumentContext();

	public static final String ID_DELETE_ATTACHMENT = "/attachment/delete";
	public static final String ID_DELETE_HISTORY = "/history/delete";
	
	private ObservableList<DocumentHistory> historyList = FXCollections.observableArrayList();
	private FilteredList<DocumentHistory> filteredHistory = new FilteredList<>(historyList, p -> true);

	private ObservableList<String> nameSuggestionList = FXCollections.observableArrayList();
	private FilteredList<String> filteredNameSuggestion = new FilteredList<>(nameSuggestionList, p -> true);

	private ObservableList<Document> referenceAllAvailableList = FXCollections.observableArrayList();
	private FilteredList<Document> fiteredReferenceAllAvailableList = new FilteredList<>(referenceAllAvailableList,
			p -> true);

	private ObservableList<Document> referencedList = FXCollections.observableArrayList();
	private FilteredList<Document> fiteredReferencedList = new FilteredList<>(referencedList, p -> true);

	private List<DocumentReference> referencesRegistry = new ArrayList<>();
	
	private DocumentViewer viewer = new DocumentViewer();

	@Autowired
	DocumentHistoryRepository historyRepository;

	@Autowired
	DocumentHistoryService historyService;
	
	@Autowired 
	DocumentRepository documentRepository;

	@Autowired 
	DocumentFolderService folderService;
	
	@Autowired
	DocumentAttachmentService attachmentService;
	
	@Autowired
	DocumentReferenceService referenceService;
	
	@Autowired
	ClipboardFileNameSuggestionRepository fileNameSuggestionRepository;
	
	@Override
	public void initialize() {
		super.initialize();

		// Fill Histories
		List<DocumentHistory> histories = historyRepository.findAll();
		historyList.addAll(histories);

//		List<String> fileNames = JRegisPlatform.getInstance(ClipboardNameSuggestionRepository.class).findAll();
//		nameSuggestionList.addAll(fileNames);

		new AutoCompletionTextFieldBinding<>(textFilename, param -> {
			filteredNameSuggestion.setPredicate(p -> p.toLowerCase().contains(param.getUserText().toLowerCase()));
			return filteredNameSuggestion;
		});

		initBindings();
		initReferenceDialog();

		mainContent.getChildren().add(viewer);
		viewer.toBack();

		EventBroker.getDefault().register(this);
	}

	@Subscribe
	public void subscribeEventBroker(EventContext<?> context) {
		if (context.getEventId().equals("/open/document/details")) {
			setSelection((Document) context.getInput());
		}else if (context.getEventId().equals("/set/current/doccument")) {
			Optional<Document> optionalDocument = documentRepository.findById((Long)context.getInput());
			optionalDocument.ifPresent(this::setSelection);
		}else if (context.getEventId().equals("/open/file/attachment")) {
			onOpenFileChanged(null, null, (String)context.getInput());
		}else if (context.getEventId().equals("/store/add/screenshot/image")) {
			dispatchAddScreenshot(context);
		}
	}

	@Override
	protected void onButtonAction(ActionEvent event) {
		Object source = event.getSource();
		if (linkBack == source) {
			root.toBack();
		} else if (source == buttonReferenceDialogApply) {
			dispatchApplySelectedReferences();
		} else if (source == buttonOpenReferenceDialog) {
			dispatchOpenReferenceDialog();
		} else if (source==buttonAttachment) {
			dispatchAttachSelectedFiles();
		} else if (source == buttonClipboardHelperAccept) {
			dispatchAcceptClipboardHelperResult();
		} else if (source == linkClipboardHelperCancel) {
			dispatchCloseClipboardHelperDialog();
		} else if (source == buttonClipboard) {
			dispatchOpenClipboardHelperDialog();
		}else if (source == buttomSubmitComment) {
			dispatchSubmitComment();
		}else if (source == checkBoxShowDeletedComments) {
			populateHistoryList(context.current.get());
		}else if (source == linkAddNewSuggestion) {
			dispatchCreateNewSuggestion();
		}else if (source == linkDeleteSuggestion) {
			dispatchDeleteSuggestion();
		}else if (source == buttonFullscreenshot) {
			dispatchOpenFullscreenshot(true);
		}else if (source == buttonScreenshot) {
			dispatchOpenFullscreenshot(false);
		}else if (source == linkCancelReferenceDialog) {
			dispatchCloseReferenceDialog();
		}else if (source == buttonDownload) {
			dispatchOpenDownloadDialog();
		}else if (source == linkDownloadDialogCancel) {
			dispatchCloseDownloadDialog();
		}else if (source == buttonDownloadDialogAccept) {
			dispatchAcceptDownloadDialog();
		}
	}

	private void dispatchOpenDownloadDialog() {
		context.downloadUrl.set(ClipboardHelper.getString());
		downloadDialog.setVisible(true);
		downloadDialog.toFront();
	}

	private void dispatchCloseDownloadDialog() {
		downloadDialog.setVisible(false);
		downloadDialog.toBack();
	}

	private void dispatchAcceptDownloadDialog() {
		if (context.downloadUrl.get().isEmpty()) {
			Notifications.create().darkStyle().text("Url cannot be empty!").title("Url Parse Error").showWarning();
			return;
		} else {
			try {
				File file = folderService.downloadFile(context);
				Notifications.create().darkStyle().text("Download url to " + context.downloadUrl.get())
						.title("Download Finished").onAction(e1 -> onOpenFileChanged(null, null, file.getParent()))
						.showInformation();

				context.documentComment.set(context.downloadTransactionMessage.get());
				DocumentHistory history = historyService.create(context);
				
				DocumentAttachment attachment = new DocumentAttachment(context.downloadFileName.get(), LocalDateTime.now(), LocalDateTime.now(), history.getId());
				attachmentService.save(attachment);
				
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

		dispatchCloseDownloadDialog();
	}

	private void dispatchOpenDocumentFolder() {
		try {
			folderService.openFolder(context.current.get());
		} catch (Exception e) {
			Notifications.create().darkStyle().text(e.getMessage())
			.title("Failed to open folder!").showError();
		}
	}

	private void dispatchOpenFullscreenshot(boolean isFullscreenshot) {
		Stage mainStage = (Stage) root.getScene().getWindow();
		mainStage.setIconified(true);
		
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			log.error("Error on running thread#sleep", e);
		}
		
		ScreenshotStage stage = new ScreenshotStage(isFullscreenshot);
		stage.show();
	}

	private void dispatchDeleteSuggestion() {
		if (textFilename.getText().isEmpty()) {
			Notifications.create().text("File Name cannot be empty").title("File Name Suggestion").darkStyle()
					.showWarning();
		} else {
			String name = textFilename.getText();
			fileNameSuggestionRepository.deleteByName(name);
			nameSuggestionList.remove(name);
		}
	}

	private void dispatchCreateNewSuggestion() {
		if (textFilename.getText().isEmpty()) {
			Notifications.create().text("File Name cannot be empty").title("File Name Suggestion").darkStyle()
					.showWarning();
		} else {
			String name = textFilename.getText();
			fileNameSuggestionRepository.save(new ClipboardFileNameSuggestion(name, LocalDateTime.now(), LocalDateTime.now()));
			nameSuggestionList.add(name);
		}
	}

	private void dispatchAddScreenshot(EventContext<?> context) {
		Stage mainStage = (Stage) root.getScene().getWindow();
		mainStage.setIconified(false);
		
		ScreenshotContext screenshotContext = (ScreenshotContext) context.getInput();
		String dateFormat = new SimpleDateFormat("yyyy-MM-dd_HHmmss").format(new Date());
		String name = dateFormat+screenshotContext.getName();
		Image image = screenshotContext.getImage();
		
		LocalDateTime createdOn = LocalDateTime.now();
		DocumentHistory history = new DocumentHistory("Added Screenshot", createdOn , createdOn, this.context.current.get().getId());
		history.setStatus(DocumentHistoryStatus.ADD.getStatusValue());
		history = historyRepository.save(history);
		
		DocumentAttachment attachment = new DocumentAttachment(name, createdOn, createdOn, history.getId());
		attachment.setStatus(DocumentAttachmentStatus.ADD.getStatusValue());
		attachment = attachmentService.save(attachment);
		history.getAttachments().add(attachment);
		
		folderService.copyImageTo(this.context.current.get(), name, image);
		
		addHistory(history);
	}
	
	private void dispatchOpenClipboardHelperDialog() {
		clipboardHelperDialog.setVisible(true);
		clipboardHelperDialog.toFront();

		ClipboardHelper.getImage().ifPresent(e -> {
			imageViewClipboard.setFitHeight(e.getHeight());
			imageViewClipboard.setFitWidth(e.getWidth());
			context.clipboardImageContent.set(e);
		});
	}

	private void dispatchCloseClipboardHelperDialog() {
		clipboardHelperDialog.toBack();
		clipboardHelperDialog.setVisible(false);
	}

	private void dispatchOpenReferenceDialog() {
		referenceDialog.toFront();
		referenceDialog.setVisible(true);
	}

	private void dispatchAcceptClipboardHelperResult() {
		dispatchCloseClipboardHelperDialog();

		context.documentComment.set(context.clipboardTransactionMessage.get());
		DocumentHistory history = historyService.create(context);
		folderService.copyImageTo(context);

		DocumentAttachment attachment = attachmentService.create(history, context.clipboardFileName.get()+".png");
		
		Notifications.create().text("Added File " + attachment.getName() + " from Clipboard").title("File Clipboard")
				.darkStyle().show();

		addHistory(history);
		vboxFiles.getChildren().add(new AttachmentControl(attachment));
	}

	private void dispatchAttachSelectedFiles() {
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

	private void dispatchApplySelectedReferences() {
		referenceDialog.setVisible(false);
		referenceDialog.toBack();

		LocalDateTime createdOn = LocalDateTime.now();
		Document document = context.current.get();
		long firstId = document.getId();

		referencedList.forEach(e ->{ 
			DocumentReference reference = new DocumentReference(createdOn , createdOn, 0L, firstId, e.getId(), e.getName());
			referenceService.save(reference);
			vboxReferences.getChildren().add(new ReferenceControl(reference, false));
		});
		
	}

	private void dispatchSubmitComment() {
		DocumentHistory history = historyService.create(context);
		flowPaneFiles.getChildren().stream().forEach(e -> {
			try {
				folderService.copyFile(context.current.get(), e.getAccessibleText());
			} catch (IOException e1) {
				Notifications.create().darkStyle().text("Failed to copy file " + e.getAccessibleText())
						.title("File Copy Error!").show();
				return;
			}
			DocumentAttachment attachment = attachmentService.create(history, ((Hyperlink) e).getText());
			vboxFiles.getChildren().add(new AttachmentControl(attachment));
			history.getAttachments().add(attachment);
		});

		textAreaComment.clear();
		flowPaneFiles.getChildren().clear();

		Notifications.create().title("New Comment").text("Created new comment with attachments!").darkStyle()
				.show();

		addHistory(history);
	}

	@Override
	protected void onReferenceDialogKeyPressed(KeyEvent event) {
		if (event.getCode().equals(KeyCode.ESCAPE)) {
			dispatchCloseReferenceDialog();
		}
	}

	private void dispatchCloseReferenceDialog() {
		referenceDialog.setVisible(false);
		referenceDialog.toBack();			
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
			DocumentHistory history = historyService.create(context);
			
			String destination = folderService.getFolderBy(context.current.get()).getAbsolutePath();

			db.getFiles().stream().forEach(f -> {
				DocumentAttachment attachment = new DocumentAttachment(f.getName(), timestamp, timestamp, history.getId());
				attachment.setStatus(DocumentAttachmentStatus.ADD.getStatusValue());

				folderService.copyFileTo(f, new File(destination, f.getName()));
				attachmentService.save(attachment);
				
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

	private void initReferenceDialog() {
		// texytToReferencedDocument.textProperty().bind(Bindings.format("JREG-%05d:
		// %s", context.current.get().getId(), context.current.get().getName()));

		referenceAllAvailableList.addAll(documentRepository.findAll());

		listViewAllAvailableDocuments.setItems(fiteredReferenceAllAvailableList);
		listViewReferencedDocuments.setItems(fiteredReferencedList);

		labelAllAvailableDocumentsCounter.textProperty()
				.bind(Bindings.format("(%d)", Bindings.size(fiteredReferenceAllAvailableList)));
		labelReferencedDocumentCounter.textProperty()
				.bind(Bindings.format("(%d)", Bindings.size(fiteredReferencedList)));

		listViewAllAvailableDocuments.setCellFactory(param -> new ReferenceListCellFeature());
		listViewReferencedDocuments.setCellFactory(param -> new ReferenceListCellFeature());

		textSearchForAvailableDocuments.textProperty()
				.addListener((observable, oldValue, newValue) -> fiteredReferenceAllAvailableList.setPredicate(p -> {
					boolean isNewValueEmpty = newValue == null || newValue.isEmpty();
					boolean isNameEquals = p.getName().toLowerCase().contains(newValue.toLowerCase());
					boolean isIdEquals = String.valueOf(p.getId()).contains(newValue);
					return isNewValueEmpty || isNameEquals || isIdEquals;
				}));

		textSearchForReferencedDocuments.textProperty()
				.addListener((observable, oldValue, newValue) -> fiteredReferencedList.setPredicate(p -> {
					boolean isNewValueEmpty = newValue == null || newValue.isEmpty();
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

	private void onOpenFileChanged(ObservableValue<? extends String> obs, String oldValue, String newValue) {
		try {
			File file = folderService.getAttachmentByName(context.current.get(), newValue);
			viewer.show(file);
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
		List<DocumentReference> references = referenceService.findAllChildById(context.current.get().getId());
		references.forEach(e->vboxReferences.getChildren().add(new ReferenceControl(e, false)));
		// Parent References
		references = referenceService.findAllParentsById(context.current.get().getId());
		references.forEach(e->{
			referencesRegistry.add(e);
			vboxReferences.getChildren().add(new ReferenceControl(e, true));
		});
		
		populateHistoryList(newValue);

		// Set document properties
		context.documentCreatedOn.set(newValue.getCreatedOn().toString());
		context.documentUpdatedOn.set(newValue.getUpdatedOn().toString());
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
				filterCriteria = filterCriteria && e.getStatus() == DocumentHistoryStatus.ADD.getStatusValue();
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
			File[] contents = folderService.getFolderContent(context.current.get());
			if (contents.length>0) {
				LocalDateTime createdOn = context.current.get().getCreatedOn();
				LocalDateTime updatedOn = LocalDateTime.now();
				Long documentId = context.current.get().getId();
				DocumentHistory history = new DocumentHistory("Reimport file(s) to history, because no history available.", createdOn , updatedOn, documentId );
				history = historyRepository.save(history);
				
				for (File file : contents) {
					DocumentAttachment attachment = new DocumentAttachment(file.getName(), createdOn, updatedOn, history.getId());
					attachment = attachmentService.save(attachment);
					history.getAttachments().add(attachment);
				}
				addHistory(history);
			}
		}
	}

	private void addAttachment(DocumentHistory history) {
		attachmentService.findAll().stream()
				.filter(e -> e.getHistoryId().equals(history.getId()))
				.filter(e -> e.getStatus() == DocumentAttachmentStatus.ADD.getStatusValue()).forEach(e -> {
					vboxFiles.getChildren().add(new AttachmentControl(e));
					history.getAttachments().add(e);
				});
	}

	private void addHistory(DocumentHistory history) {
		DocumentHistoryItem item = new DocumentHistoryItem();
		item.setHistory(history, t -> context.toOpenFile.set(t));
		vboxComment.getChildren().add(item);
	}

	
	@Override
	protected void onMouseClicked(MouseEvent e) {
		Document selection = listViewAllAvailableDocuments.getSelectionModel().getSelectedItem();
		Object source = e.getSource();
		if (source == imageViewOpenFolder) {
			dispatchOpenDocumentFolder();
		}else if (source == listViewAllAvailableDocuments) {
			if (selection != null && e.getClickCount() == 2) {
				referencedList.add(selection);
				referenceAllAvailableList.remove(selection);
			}
		}else if (source == listViewReferencedDocuments) {
			if (selection!=null && e.getClickCount()==2) {
				referenceAllAvailableList.add(selection);
				referencedList.remove(selection);
			}
		}else if (source == imageViewClipboard) {
			if (e.getClickCount() == 2) {
				ClipboardHelper.getImage().ifPresent(e1 -> {
					imageViewClipboard.setFitHeight(e1.getHeight());
					imageViewClipboard.setFitWidth(e1.getWidth());
					context.clipboardImageContent.set(e1);
				});
			}
		}else if (source == imageViewDownloadPaste) {
			context.downloadUrl.set(ClipboardHelper.getString());
		}
	}
	
//	@Subscribe
//	public void deleteHistory(IEventContext<History> context) {
//		if (context.getEventId().equals(ID_DELETE_HISTORY)) {
//			History input = context.getInput();
//			DocumentHistoryItem toDeleteItem = null;
//			for (Node node : vboxComment.getChildren()) {
//				if (node instanceof DocumentHistoryItem) {
//					DocumentHistoryItem item = (DocumentHistoryItem) node;
//					if (item.isHistory(input)) {
//						toDeleteItem = item;
//					}
//				}
//			}
//
//			if (toDeleteItem != null) {
//				vboxComment.getChildren().remove(toDeleteItem);
//			}
//
//			JRegisPlatform.getInstance(HistoryRepository.class).delete(input);
//
//			Notifications.create().title("Delete").text("Delete Comment with ID: " + input.getId()).darkStyle().show();
//		}
//	}
//
//	@Subscribe
//	public void deleteAttachment(IEventContext<Attachment> context) {
//		if (context.getEventId().equals(ID_DELETE_ATTACHMENT)) {
//			Attachment input = context.getInput();
//			AttachmentControl toDeleteControl = null;
//			for (Node node : vboxFiles.getChildren()) {
//				if (node instanceof AttachmentControl) {
//					AttachmentControl attachmentControl = (AttachmentControl) node;
//					if (attachmentControl.getAttachment().equals(input)) {
//						toDeleteControl = attachmentControl;
//						JRegisPlatform.getInstance(AttachmentRepository.class).delete(input);
//					}
//				}
//			}
//			if (toDeleteControl != null) {
//				vboxFiles.getChildren().remove(toDeleteControl);
//			}
//			vboxComment.getChildren().forEach(e -> {
//				if (e instanceof DocumentHistoryItem) {
//					DocumentHistoryItem item = (DocumentHistoryItem) e;
//					item.findAndDeactivateAttachment(input);
//				}
//			});
//
//			this.context.documentComment.set("Delete selected file " + input.getName());
//			History history = JRegisPlatform.getInstance(HistoryService.class).delete(this.context);
//
//			history.getAttachments().add(input);
//			addHistory(history);
//
//			historyList.add(history);
//		}
//	}

}
