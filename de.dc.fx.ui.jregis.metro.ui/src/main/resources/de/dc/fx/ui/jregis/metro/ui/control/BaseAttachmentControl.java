package de.dc.fx.ui.jregis.metro.ui.control;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public abstract class BaseAttachmentControl extends AnchorPane {

	@FXML
	protected Tooltip tooltip;
	
    @FXML
    protected ImageView imageViewFileType;

    @FXML
    protected Label labelFilename;

    @FXML
    protected ImageView imageViewExport;

}
