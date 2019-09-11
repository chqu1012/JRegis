package de.dc.spring.fx.ui.jregis.metro.ui.toolbar;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import de.dc.spring.fx.ui.jregis.metro.ui.events.EventContext;
import de.dc.spring.fx.ui.jregis.metro.ui.events.IEventBroker;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;

@Controller
public class NotificationUser extends BaseNotificationUser{

private Logger log = Logger.getLogger(getClass().getSimpleName());

public static final String FXML = "/de/dc/spring/fx/ui/jregis/metro/ui/toolbar/NotificationUser.fxml";

	@Autowired IEventBroker eventBroker;

	public NotificationUser() {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(FXML));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);

		try {
			fxmlLoader.load();
		} catch (IOException exception) {
			log.log(Level.SEVERE, "Failed to load fxml "+FXML, exception);
		}
	}
	
	@Override
	protected void onLinkAccountClicked(MouseEvent event) {
		eventBroker.post(new EventContext<>("/close/notification", "user"));
	}

	@Override
	protected void onLinkLockScreenClicked(MouseEvent event) {
		eventBroker.post(new EventContext<>("/close/notification", "user"));	
	}

	@Override
	protected void onLinkLogOutClicked(MouseEvent event) {
		eventBroker.post(new EventContext<>("/close/notification", "logout"));		
	}

	@Override
	protected void onLinkSettingsClicked(MouseEvent event) {
		eventBroker.post(new EventContext<>("/close/notification", "user"));		
	}

	@Override
	protected void onLinkSupportClicked(MouseEvent event) {
		eventBroker.post(new EventContext<>("/close/notification", "user"));		
	}

}
