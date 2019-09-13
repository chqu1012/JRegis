package de.dc.spring.fx.ui.jregis.metro.ui.document;

import de.dc.spring.fx.ui.jregis.metro.ui.document.model.Document;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public abstract class AbstractFxmlDocumentDetails extends ScrollPane {

	@FXML
	protected ScrollPane root;

	@FXML
	protected AnchorPane mainContent;

	@FXML
	protected AnchorPane referenceDialog;

	@FXML
	protected TextField texytToReferencedDocument;

	@FXML
	protected Label labelAllAvailableDocumentsCounter;

	@FXML
	protected Label labelReferencedDocumentCounter;

	@FXML
	protected Button buttonSelectDocument;

	@FXML
	protected Button buttonUnselectDocument;

	@FXML
	protected Button buttonSelectAllDocument;

	@FXML
	protected Button buttonUnselectAllDocument;

	@FXML
	protected TextField textSearchForAvailableDocuments;

	@FXML
	protected TextField textSearchForReferencedDocuments;

	@FXML
	protected Hyperlink linkCancelReferenceDialog;

	@FXML
	protected Button buttonReferenceDialogApply;

	@FXML
	protected ListView<Document> listViewAllAvailableDocuments;

	@FXML
	protected ListView<Document> listViewReferencedDocuments;

	@FXML
	protected AnchorPane downloadDialog;

	@FXML
	protected Button buttonDownloadDialogAccept;

	@FXML
	protected Hyperlink linkDownloadDialogCancel;

	@FXML
	protected TextField textDownloadTransactionMessage;

	@FXML
	protected TextField textDownloadFileID;

	@FXML
	protected TextField textDownloadFilename;

	@FXML
	protected CheckBox checkBoxUsingDownloadFileId;

	@FXML
	protected TextField textDownloadTUrl;

	@FXML
	protected ImageView imageViewDownloadPaste;

	@FXML
	protected AnchorPane clipboardHelperDialog;

	@FXML
	protected Button buttonClipboardHelperAccept;

	@FXML
	protected Hyperlink linkClipboardHelperCancel;

	@FXML
	protected TextField textTransactionMessage;

	@FXML
	protected TextField textFileID;

	@FXML
	protected TextField textFilename;

	@FXML
	protected CheckBox checkBoxUsingFileId;

	@FXML
	protected ImageView imageViewClipboard;

	@FXML
	protected Hyperlink linkAddNewSuggestion;

	@FXML
	protected Hyperlink linkDeleteSuggestion;

	@FXML
	protected HBox hboxTitle;

	@FXML
	protected Label labelDocumentId;

	@FXML
	protected Label labelDocumentName;

	@FXML
	protected Label labelDocumentDescription;

	@FXML
	protected Label labelCreatedOn;

	@FXML
	protected Label labelUpdatedOn;

	@FXML
	protected Label labelEditor;

	@FXML
	protected VBox vboxComment;

	@FXML
	protected VBox vboxCommentEditBox;

	@FXML
	protected FlowPane flowPaneFiles;

	@FXML
	protected TextArea textAreaComment;

	@FXML
	protected CheckBox checkBoxShowDeletedComments;

	@FXML
	protected Button buttonScreenshot;

	@FXML
	protected Button buttonFullscreenshot;

	@FXML
	protected Button buttonClipboard;

	@FXML
	protected Button buttonAttachment;

	@FXML
	protected Button buttonDownload;

	@FXML
	protected Button buttomSubmitComment;

	@FXML
	protected Label labelCommentCount;

	@FXML
	protected Label labelDraggingFilesArea;

	@FXML
	protected VBox vboxDraggingFilesBox;

	@FXML
	protected VBox vboxReferences;

	@FXML
	protected Label labelReferenceCount;

	@FXML
	protected Button buttonOpenReferenceDialog;

	@FXML
	protected VBox vboxFiles;

	@FXML
	protected Label labelFilesCount;

	@FXML
	protected ImageView imageViewOpenFolder;

	@FXML
	protected Hyperlink linkBack;

	@FXML
	protected abstract void onButtonAction(ActionEvent event);

	@FXML
	protected abstract void onReferenceDialogKeyPressed(KeyEvent event);

	@FXML
	protected abstract void onScrollPaneKeyPressed(KeyEvent event);

	@FXML
	protected abstract void onVBoxDraggingFileBoxDragDropped(DragEvent event);

	@FXML
	protected abstract void onVBoxDraggingFileBoxDragOver(DragEvent event);
	
	@FXML
	protected abstract void onMouseClicked(MouseEvent e);
}
