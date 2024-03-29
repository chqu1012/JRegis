package de.dc.fx.ui.jregis.metro.ui.control.document.management;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public abstract class BaseDocumentPreview extends AnchorPane{

	@FXML
	protected AnchorPane pdfView;
	
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
    protected Button button100Percent;

    @FXML
    protected Button buttonPlus10Percent;

    @FXML
    protected Button buttonMinus10Percent;

    @FXML
    protected Button buttonPreviousPage;

    @FXML
    protected TextField textPdfCurrentPage;

    @FXML
    protected TextField textPdfPageCounter;

    @FXML
    protected Button buttonNextPage;
    
    @FXML
    protected abstract void onButtonClicked(ActionEvent event);
    
    @FXML
    protected abstract void onImageViewPreviewCloseClicked(MouseEvent event);

    @FXML
    protected abstract void onRootKeyReleased(KeyEvent event);

}