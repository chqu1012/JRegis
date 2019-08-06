package de.dc.fx.ui.jregis.metro.ui.util.screenshot;

import static java.lang.Math.abs;

import de.dc.fx.ui.jregis.metro.ui.control.screenshot.ScreenshotPreview;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class ScreenshotSelection extends AnchorPane{

    private Screen primary = Screen.getPrimary();
    private Rectangle2D bounds = primary.getBounds();
	private Stage stage;
    private HBox rectangularFrame;
    private double startX;
    private double startY;
    private double sceneX;
    private double sceneY;
    private Label label = new Label();
    Button button = new Button("Accept");
    
	public ScreenshotSelection(Stage stage, boolean isFullscreen) {
		this.stage = stage;
		setStyle("-fx-background-color: rgba(17,17,17,0.19)");
		button.setStyle("-fx-background-color: dodgerblue; -fx-text-fill: white");
		
		label.setPrefHeight(30);
		label.setAlignment(Pos.CENTER);
		label.setPadding(new Insets(5));
		
		if (isFullscreen) {
			new ScreenshotPreview().getScreenImage(0, 0, (int)getScreenWidth(), (int)getScreenHeight());
		}else {
			setOnMousePressed(this::onMousePressed);
			setOnDragDetected(event -> startFullDrag());
			setOnMouseDragOver(this::onMouseDragOver);
			setOnMouseDragExited(this::onMouseDragExited);		
		}
	}

	private void onMouseDragExited(MouseDragEvent event) {
		rectangularFrame.getChildren().add(button);
		rectangularFrame.setAlignment(Pos.BOTTOM_RIGHT);
		button.setOnAction(e->shot(abs(startX - event.getSceneX()), abs(startY - event.getSceneY())));
	}

	private void shot(double imgWidth, double imgHeight) {
		stage.close();
		if (sceneX >= startX && sceneY >= startY) {
			new ScreenshotPreview().getScreenImage((int) startX, (int) startY, (int) imgWidth, (int) imgHeight);
		} else if (sceneX <= startX && sceneY <= startY) {
			new ScreenshotPreview().getScreenImage((int) sceneX, (int) sceneY, (int) imgWidth, (int) imgHeight);
		} else if (sceneX >= startX && sceneY <= startY) {
			new ScreenshotPreview().getScreenImage((int) startX, (int) sceneY, (int) imgWidth, (int) imgHeight);
		} else if (sceneX <= startX && sceneY >= startY) {
			new ScreenshotPreview().getScreenImage((int) sceneX, (int) startY, (int) imgWidth, (int) imgHeight);
		}
	}

	private void onMouseDragOver(MouseDragEvent event) {
		sceneX = event.getSceneX();
		sceneY = event.getSceneY();
		if (sceneX >= startX && sceneY >= startY) {
		    AnchorPane.setLeftAnchor(rectangularFrame, startX);
		    AnchorPane.setTopAnchor(rectangularFrame, startY);
		    AnchorPane.setLeftAnchor(label, startX);
		    AnchorPane.setTopAnchor(label, startY - label.getPrefHeight());
		} else if (sceneX <= startX && sceneY <= startY) {
		    AnchorPane.setLeftAnchor(rectangularFrame, sceneX);
		    AnchorPane.setTopAnchor(rectangularFrame, sceneY);
		    AnchorPane.setLeftAnchor(label, sceneX);
		    AnchorPane.setTopAnchor(label, sceneY - label.getPrefHeight());
		} else if (sceneX >= startX && sceneY <= startY) {
		    AnchorPane.setLeftAnchor(rectangularFrame, startX);
		    AnchorPane.setTopAnchor(rectangularFrame, sceneY);
		    AnchorPane.setLeftAnchor(label, startX);
		    AnchorPane.setTopAnchor(label, sceneY - label.getPrefHeight());
		} else if (sceneX <= startX && sceneY >= startY) {
		    AnchorPane.setLeftAnchor(rectangularFrame, sceneX);
		    AnchorPane.setTopAnchor(rectangularFrame, startY);
		    AnchorPane.setLeftAnchor(label, sceneX);
		    AnchorPane.setTopAnchor(label, startY - label.getPrefHeight());
		}
		double recWidth = Math.abs(sceneX - startX);
		double rectHeight = Math.abs(sceneY - startY);
		rectangularFrame.setPrefWidth(recWidth);
		rectangularFrame.setPrefHeight(rectHeight);
		label.setText(String.format("Width: %s px Height: %s px", recWidth, rectHeight));
		if (recWidth > 0) {
		    label.setStyle("-fx-background-color: #0a0a0a80; -fx-text-fill: #e8e8e8");
		}
	}

	private void onMousePressed(MouseEvent event) {
		getChildren().clear();
		rectangularFrame = new HBox();
		rectangularFrame.setStyle("-fx-background-color: #ffffff00; -fx-border-color: #ff312a; -fx-border-width: 2");

		startX = event.getSceneX();
		startY = event.getSceneY();
		getChildren().add(rectangularFrame);
		getChildren().add(label);
	}
	
    public double getScreenWidth() {
        return bounds.getWidth();
    }

    public double getScreenHeight() {
        return bounds.getHeight();
    }

    public double adaptationW(int adaptation) {
        double ratio = adaptation / 1920.0;
        double i = ((int) (getScreenWidth() * ratio * 100)) / 100;
        return Math.round(i);
    }

    public double adaptationH(int adaptation) {
        double ratio = adaptation / 1080.0;
        double i = ((int) (getScreenHeight() * ratio * 100)) / 100;
        return Math.round(i);
    }
}
