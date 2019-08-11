package de.dc.fx.ui.jregis.metro.ui.control.document.management;

import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public abstract class BaseDocumentPreview extends AnchorPane{

	@FXML
	protected ScrollPane scrollPane;
	
    @FXML
    protected AnchorPane panePreview;

    @FXML
    protected ImageView imageViewPreview;

    @FXML
    protected ImageView imageViewClose;

    @FXML
    protected VBox hboxFiles;

    @FXML
    protected abstract void onImageViewPreviewCloseClicked(MouseEvent event);

}