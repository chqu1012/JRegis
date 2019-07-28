package de.dc.fx.ui.jregis.metro.ui.control;

import de.dc.fx.ui.jregis.metro.ui.model.Attachment;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
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
import javafx.scene.layout.VBox;

public abstract class BaseDocumentFlatDetails extends ScrollPane {

	@FXML
	protected Button buttonClipboardHelperAccept;

	@FXML
	protected Button buttonDownloadDialogAccept;
	
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
	protected AnchorPane downloadDialog;
	
	@FXML
	protected AnchorPane clipboardHelperDialog;
	
	@FXML
	protected CheckBox checkBoxShowDeletedComments;

	@FXML
	protected Label labelDraggingFilesArea;

	@FXML
	protected VBox vboxDraggingFilesBox;

	@FXML
	protected VBox vboxReferences;

	@FXML
	protected VBox vboxCommentEditBox;

	@FXML
	protected FlowPane flowPaneFiles;

	@FXML
	protected ListView<Attachment> listViewFiles;

	@FXML
	protected ScrollPane root;

	@FXML
	protected Label labelDocumentName;

	@FXML
	protected Label labelDocumentId;

	@FXML
	protected Label labelDocumentDescription;

	@FXML
	protected Label labelCreatedOn;

	@FXML
	protected Label labelUpdatedOn;

	@FXML
	protected Label labelEditor;

	@FXML
	protected Label labelFilesCount;

	@FXML
	protected Label labelCommentCount;

	@FXML
	protected Label labelReferenceCount;

	@FXML
	protected TextArea textAreaComment;

	@FXML
	protected VBox vboxComment;

	@FXML
	protected VBox vboxFiles;

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
	protected abstract void onLinkBackAction(ActionEvent event);

	@FXML
	protected abstract void onButtonSubmitComment(ActionEvent event);

	@FXML
	protected abstract void onButtonAttachmentsAction(ActionEvent event);

	@FXML
	protected abstract void onScrollPaneKeyPressed(KeyEvent event);

	@FXML
	protected abstract void onVBoxDraggingFileBoxDragOver(DragEvent event);

	@FXML
	protected abstract void onVBoxDraggingFileBoxDragDropped(DragEvent event);

	@FXML
	protected abstract void onCheckBoxShowDeletedCommentsAction(ActionEvent event);

	@FXML
	protected abstract void onButtonClipboardHelperAcceptAction(ActionEvent event);

	@FXML
	protected abstract void onLinkClipboardHelperCancelAction(ActionEvent event);

	@FXML
	protected abstract void onButtonClipboardHelperAction(ActionEvent event);

	@FXML
	protected abstract void onImageViewClipboardHelperClicked(MouseEvent event);
	
	@FXML
	protected abstract void onLinkAddNewSuggestionAction(ActionEvent event);
	
	@FXML
	protected abstract void onLinkDeleteNewSuggestionAction(ActionEvent event);
	
    @FXML
    protected abstract void onLinkDownloadDialogAcceptAction(ActionEvent event);

    @FXML
    protected abstract void onLinkDownloadDialogCancelAction(ActionEvent event);

    @FXML
    protected abstract void onButtonDownloadDialogAction(ActionEvent event);

    @FXML
    protected abstract void onImageViewDownloadClipboardClicked(MouseEvent event);

}
