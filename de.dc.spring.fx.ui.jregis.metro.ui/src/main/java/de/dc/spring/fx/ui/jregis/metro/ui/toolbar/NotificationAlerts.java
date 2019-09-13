package de.dc.spring.fx.ui.jregis.metro.ui.toolbar;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Controller;

import de.dc.spring.fx.ui.jregis.metro.ui.events.EventBroker;
import de.dc.spring.fx.ui.jregis.metro.ui.events.EventContext;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;

@Controller
public class NotificationAlerts extends BaseNotificationAlerts{

	private Logger log = Logger.getLogger(getClass().getSimpleName());
	
	public static final String FXML = "/de/dc/spring/fx/ui/jregis/metro/ui/toolbar/NotificationAlerts.fxml";
	
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
		EventBroker.getDefault().post(new EventContext<String>("/open/see/all/alerts", "alerts"));
	}

}
