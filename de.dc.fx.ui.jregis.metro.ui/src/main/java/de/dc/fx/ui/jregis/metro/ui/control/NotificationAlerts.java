package de.dc.fx.ui.jregis.metro.ui.control;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;

public class NotificationAlerts extends BaseNotificationAlerts{

	private Logger log = Logger.getLogger(AttachmentControl.class.getSimpleName());
	
	public static final String FXML = "/de/dc/fx/ui/jregis/metro/ui/NotificationAlerts.fxml";
	
	public NotificationAlerts() {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(FXML));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);

		try {
			fxmlLoader.load();
		} catch (IOException exception) {
			log.log(Level.SEVERE, "Failed to load fxml "+FXML, exception);
		}
		
		vboxAlerts.getChildren().add(new NotificationAlertItem());
		vboxAlerts.getChildren().add(new NotificationAlertItem());
		vboxAlerts.getChildren().add(new NotificationAlertItem());
		vboxAlerts.getChildren().add(new NotificationAlertItem());
	}	
	
	@Override
	protected void onLabelSeeAllAlertsClicked(MouseEvent event) {
		
	}

}
