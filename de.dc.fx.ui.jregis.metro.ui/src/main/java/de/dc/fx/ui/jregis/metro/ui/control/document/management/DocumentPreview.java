package de.dc.fx.ui.jregis.metro.ui.control.document.management;

import java.io.File;
import java.io.IOException;

import org.controlsfx.control.Notifications;

import de.dc.fx.ui.jregis.metro.ui.di.JRegisPlatform;
import de.dc.fx.ui.jregis.metro.ui.service.DocumentFolderService;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.input.ZoomEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;

public class DocumentPreview extends BaseDocumentPreview {

	public static final String FXML = "/de/dc/fx/ui/jregis/metro/ui/control/document/management/DocumentPreview.fxml";

	private Screen primary = Screen.getPrimary();
	private Rectangle2D bounds = primary.getBounds();
	private static final double ZOOM_FACTOR = 1.0014450997779993488675056142818;
	private final DoubleProperty zoomProperty = new SimpleDoubleProperty(1000);
	private final DoubleProperty mouseXProperty = new SimpleDoubleProperty();
	private final DoubleProperty mouseYProperty = new SimpleDoubleProperty();

	private Image image;

	public DocumentPreview() {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(FXML));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);

		try {
			fxmlLoader.load();
		} catch (IOException exception) {
			throw new RuntimeException(exception);
		}

		AnchorPane.setBottomAnchor(this, 0d);
		AnchorPane.setTopAnchor(this, 0d);
		AnchorPane.setLeftAnchor(this, 0d);
		AnchorPane.setRightAnchor(this, 0d);

		initScrollPane();

		setVisible(false);
		toBack();
	}

	private void initScrollPane() {
		scrollPane.setHbarPolicy(ScrollBarPolicy.NEVER);
		scrollPane.setVbarPolicy(ScrollBarPolicy.NEVER);

		scrollPane.setOnMouseMoved(event -> {
			mouseXProperty.set(event.getX());
			mouseYProperty.set(event.getY());
		});

		addEventFilter(ScrollEvent.ANY, event -> {
			// Original size of the image.
			double sourceWidth = zoomProperty.get() * imageViewPreview.getImage().getWidth();
			double sourceHeight = zoomProperty.get() * imageViewPreview.getImage().getHeight();

			zoomProperty.set(zoomProperty.get() * Math.pow(ZOOM_FACTOR, event.getDeltaY()));

			// Old values of the scrollbars.
			double oldHvalue = scrollPane.getHvalue();
			double oldVvalue = scrollPane.getVvalue();

			// Image pixels outside the visible area which need to be scrolled.
			double preScrollXFactor = Math.max(0, sourceWidth - getWidth());
			double preScrollYFactor = Math.max(0, sourceHeight - getHeight());

			// Relative position of the mouse in the image.
			double mouseXPosition = (mouseXProperty.get() + preScrollXFactor * oldHvalue) / sourceWidth;
			double mouseYPosition = (mouseYProperty.get() + preScrollYFactor * oldVvalue) / sourceHeight;

			// Target size of the image.
			double targetWidth = zoomProperty.get() * imageViewPreview.getImage().getWidth();
			double targetHeight = zoomProperty.get() * imageViewPreview.getImage().getHeight();

			// Image pixels outside the visible area which need to be scrolled.
			double postScrollXFactor = Math.max(0, targetWidth - getWidth());
			double postScrollYFactor = Math.max(0, targetHeight - getHeight());

			// Correction applied to compensate the vertical scrolling done by ScrollPane
			double verticalCorrection = (postScrollYFactor / sourceHeight) * event.getDeltaY();

			// New scrollbar positions keeping the mouse position.
			double newHvalue = ((mouseXPosition * targetWidth) - mouseXProperty.get()) / postScrollXFactor;
			double newVvalue = ((mouseYPosition * targetHeight) - mouseYProperty.get() + verticalCorrection)
					/ postScrollYFactor;

			imageViewPreview.setFitWidth(targetWidth);
			imageViewPreview.setFitHeight(targetHeight);

			scrollPane.setHvalue(newHvalue);
			scrollPane.setVvalue(newVvalue);
		});

		scrollPane.addEventFilter(ZoomEvent.ANY, event -> {
			zoomProperty.set(zoomProperty.get() * event.getZoomFactor());
			imageViewPreview.setFitWidth(zoomProperty.get() * image.getWidth());
			imageViewPreview.setFitHeight(zoomProperty.get() * image.getHeight());
		});
	}

	@Override
	protected void onImageViewPreviewCloseClicked(MouseEvent event) {
		panePreview.setVisible(false);
		panePreview.toBack();
	}

	public void show(File attachmentFile) {
		String name = attachmentFile.getName().toLowerCase();
		if (name.endsWith(".jpeg") ||name.endsWith(".jpg") || name.endsWith(".png") || name.endsWith(".bmp")) {
			panePreview.setVisible(true);
			panePreview.toFront();
			
			image = new Image(attachmentFile.toURI().toString());
			double width = image.getWidth();
			double height = image.getHeight();
			
			imageViewPreview.setImage(image);
			imageViewPreview.setFitHeight(height);
			imageViewPreview.setFitWidth(width);
			
			zoomProperty.set(Math.min(imageViewPreview.getFitWidth() / imageViewPreview.getImage().getWidth(),
					imageViewPreview.getFitHeight() / imageViewPreview.getImage().getHeight()));
		}else {
			try {
				JRegisPlatform.getInstance(DocumentFolderService.class).openFile(attachmentFile);
			} catch (Exception e) {
				Notifications.create().darkStyle().text(e.getLocalizedMessage()).title("File Error").showError();
			}
		}
	}

	public double getScreenWidth() {
		return bounds.getWidth();
	}

	public double getScreenHeight() {
		return bounds.getHeight();
	}

	@Override
	protected void onButtonClicked(ActionEvent event) {
		if (event.getSource() == button100Percent) {
			imageViewPreview.setFitHeight(image.getHeight());
			imageViewPreview.setFitWidth(image.getWidth());
			zoomProperty.set(Math.min(imageViewPreview.getFitWidth() / imageViewPreview.getImage().getWidth(),
					imageViewPreview.getFitHeight() / imageViewPreview.getImage().getHeight()));
		} else if (event.getSource() == buttonPlus10Percent) {
			zoomProperty.set(zoomProperty.multiply(1.1).get());
		} else if (event.getSource() == buttonMinus10Percent) {
			zoomProperty.set(zoomProperty.multiply(0.9).get());
		}

		imageViewPreview.setFitWidth(zoomProperty.get() * image.getWidth());
		imageViewPreview.setFitHeight(zoomProperty.get() * image.getHeight());
	}

}
