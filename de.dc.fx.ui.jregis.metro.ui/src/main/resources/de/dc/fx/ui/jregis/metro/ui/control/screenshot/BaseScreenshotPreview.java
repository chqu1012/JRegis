package de.dc.fx.ui.jregis.metro.ui.control.screenshot;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

public abstract class BaseScreenshotPreview extends BorderPane{

	@FXML
	protected TextField textExportName;
	
	@FXML
	protected ScrollPane scrollPane;
	
	@FXML
	protected BorderPane root;
	
    @FXML
    protected Label labelMessage;

    @FXML
    protected ImageView imageViewScreenshot;

    @FXML
    protected abstract void onButtonExport(ActionEvent event);

    @FXML
    protected abstract void onButtonNewScreenshot(ActionEvent event);

}
