package de.dc.fx.ui.jregis.metro.ui.control;
import de.dc.fx.ui.jregis.metro.ui.model.Attachment;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

public abstract class BaseDocumentFlatDetails extends ScrollPane{

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
    protected TextArea textAreaComment;

    @FXML
    protected VBox vboxComment;

    @FXML
    protected VBox vboxFiles;
    
    @FXML
    protected abstract void onLinkBackAction(ActionEvent event);

    @FXML
    protected abstract void onButtonSubmitComment(ActionEvent event);
    
    @FXML
    protected abstract void onButtonAttachmentsAction(ActionEvent event);

    @FXML
    protected abstract void onScrollPaneKeyPressed(KeyEvent event);

}
