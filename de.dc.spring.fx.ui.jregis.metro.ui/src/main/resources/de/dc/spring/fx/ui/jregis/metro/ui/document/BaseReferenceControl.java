package de.dc.spring.fx.ui.jregis.metro.ui.document;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public abstract class BaseReferenceControl extends AnchorPane{

    @FXML
    protected Label labelDocumentName;

    @FXML
    protected Tooltip tooltip;

    @FXML
    protected Label labelReferenceType;

    @FXML
    protected abstract void onImageIconDeleteClicked(MouseEvent event);

    @FXML
    protected abstract void onLabelFilenameClicked(MouseEvent event);

}
