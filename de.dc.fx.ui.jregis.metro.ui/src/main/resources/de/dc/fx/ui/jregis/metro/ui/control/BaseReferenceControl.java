package de.dc.fx.ui.jregis.metro.ui.control;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;

public abstract class BaseReferenceControl {

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
