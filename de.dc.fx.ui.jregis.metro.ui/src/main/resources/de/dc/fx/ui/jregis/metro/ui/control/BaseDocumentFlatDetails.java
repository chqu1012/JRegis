package de.dc.fx.ui.jregis.metro.ui.control;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

public abstract class BaseDocumentFlatDetails extends ScrollPane{

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
    protected TextArea textAreaComment;

    @FXML
    protected VBox vboxComment;

}
