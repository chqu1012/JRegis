package de.dc.fx.ui.jregis.metro.ui.control.toolbar;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class NotificationAlertItem extends AnchorPane{

	private Logger log = Logger.getLogger(NotificationAlertItem.class.getSimpleName());
	
	public static final String FXML = "/de/dc/fx/ui/jregis/metro/ui/control/toolbar/NotificationAlertItem.fxml";
	
	public NotificationAlertItem() {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(FXML));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);

		try {
			fxmlLoader.load();
		} catch (IOException exception) {
			log.log(Level.SEVERE, "Failed to load fxml "+FXML, exception);
		}
	}
	
	
}
