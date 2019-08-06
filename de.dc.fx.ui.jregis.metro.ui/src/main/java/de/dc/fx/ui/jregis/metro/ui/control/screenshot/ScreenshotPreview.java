package de.dc.fx.ui.jregis.metro.ui.control.screenshot;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.filechooser.FileSystemView;

import de.dc.fx.ui.jregis.metro.ui.di.JRegisPlatform;
import de.dc.fx.ui.jregis.metro.ui.eventbus.EventContext;
import de.dc.fx.ui.jregis.metro.ui.eventbus.IEventBroker;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.input.ZoomEvent;
import javafx.scene.transform.Scale;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class ScreenshotPreview extends BaseScreenshotPreview {

	private Logger log = Logger.getLogger(ScreenshotPreview.class.getSimpleName());

	private Image image;
    private Screen primary = Screen.getPrimary();
    private Rectangle2D bounds = primary.getBounds();
    
	public static final String FXML = "/de/dc/fx/ui/jregis/metro/ui/ScreenshotPreview.fxml";

    private static final double ZOOM_FACTOR = 1.0014450997779993488675056142818;
    private final DoubleProperty zoomProperty = new SimpleDoubleProperty(1000);
    private final DoubleProperty mouseXProperty = new SimpleDoubleProperty();
    private final DoubleProperty mouseYProperty = new SimpleDoubleProperty();
	
    private Stage stage = new Stage();
    
	public ScreenshotPreview() {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(FXML));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);

		try {
			fxmlLoader.load();
		} catch (IOException exception) {
			log.log(Level.SEVERE, "Failed to load fxml "+FXML, exception);
		}
		
		initScrollPane();
		
	}
	
	private void initScrollPane() {
		scrollPane.setHbarPolicy(ScrollBarPolicy.NEVER);
		scrollPane.setVbarPolicy(ScrollBarPolicy.NEVER);

		scrollPane.setOnMouseMoved(event -> {
		    mouseXProperty.set(event.getX());
		    mouseYProperty.set(event.getY());
		});

        addEventFilter(ScrollEvent.ANY, event -> {
		    ImageView image = (ImageView) scrollPane.getContent();

		    // Original size of the image.
		    double sourceWidth = zoomProperty.get() * image.getImage().getWidth();
		    double sourceHeight = zoomProperty.get() * image.getImage().getHeight();

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
		    double targetWidth = zoomProperty.get() * image.getImage().getWidth();
		    double targetHeight = zoomProperty.get() * image.getImage().getHeight();

		    // Image pixels outside the visible area which need to be scrolled.
		    double postScrollXFactor = Math.max(0, targetWidth - getWidth());
		    double postScrollYFactor = Math.max(0, targetHeight - getHeight());

		    // Correction applied to compensate the vertical scrolling done by ScrollPane
		    double verticalCorrection = (postScrollYFactor / sourceHeight) * event.getDeltaY();

		    // New scrollbar positions keeping the mouse position.
		    double newHvalue = ((mouseXPosition * targetWidth) - mouseXProperty.get()) / postScrollXFactor;
		    double newVvalue =
		            ((mouseYPosition * targetHeight) - mouseYProperty.get() + verticalCorrection)
		                    / postScrollYFactor;

		    image.setFitWidth(targetWidth);
		    image.setFitHeight(targetHeight);

		    scrollPane.setHvalue(newHvalue);
		    scrollPane.setVvalue(newVvalue);
		});

        scrollPane.addEventFilter(ZoomEvent.ANY, event -> {
		    zoomProperty.set(zoomProperty.get() * event.getZoomFactor());
		    ImageView image = (ImageView) scrollPane.getContent();
		    image.setFitWidth(zoomProperty.get() * image.getImage().getWidth());
		    image.setFitHeight(zoomProperty.get() * image.getImage().getHeight());
		});		
	}

	@Override
	protected void onButtonExport(ActionEvent event) {
		String separator = File.separator;
        String absolutePath = FileSystemView.getFileSystemView().getHomeDirectory().getAbsolutePath() + separator;
        String dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-S").format(new Date());
        File pictureFile = new File(absolutePath + dateFormat + ".png");
        BufferedImage bufferedImage = SwingFXUtils.fromFXImage(image, null);
        try {
            boolean successfully = ImageIO.write(bufferedImage, "png", pictureFile);
            labelMessage.setText(successfully ? "Successfully" : "Failed");
            
            stage.close();
            
            JRegisPlatform.getInstance(IEventBroker.class).post(new EventContext<Image>("/store/add/screenshot/image", image));
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	@Override
	protected void onButtonNewScreenshot(ActionEvent event) {

	}
	
	public void getScreenImage(int startX,int startY, int imageWidth, int imageHeight){
        try {
            Robot robot = new Robot();
            Rectangle rectangle = new Rectangle( startX, startY, imageWidth, imageHeight);
            BufferedImage screenCapture = robot.createScreenCapture(rectangle);
            WritableImage writableImage = SwingFXUtils.toFXImage(screenCapture, null);

            init(writableImage);

            Clipboard systemClipboard = Clipboard.getSystemClipboard();
            ClipboardContent content = new ClipboardContent();
            content.putImage(writableImage);
            systemClipboard.setContent(content);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
	
	public void init(Image image) {
		this.image=image;

        double width = image.getWidth();
        double height = image.getHeight();
        String title = (int) width + " × " + (int) height;
        
        imageViewScreenshot.setImage(image);
        
        if (width>=height) {
        	imageViewScreenshot.setFitWidth(adaptationW(700));
        	imageViewScreenshot.setPreserveRatio(true);
        }else {
        	imageViewScreenshot.setFitHeight(adaptationH(500));
        	imageViewScreenshot.setPreserveRatio(true);
        }
        
        zoomProperty.set(Math.min(imageViewScreenshot.getFitWidth() / imageViewScreenshot.getImage().getWidth(), imageViewScreenshot.getFitHeight()
                / imageViewScreenshot.getImage().getHeight()));
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Screenshot " + title);

        stage.setWidth(adaptationW(1300));
        stage.setHeight(adaptationH(800));
        stage.show();
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
    
    public double getScreenWidth() {
        return bounds.getWidth();
    }

    public double getScreenHeight() {
        return bounds.getHeight();
    }
}
