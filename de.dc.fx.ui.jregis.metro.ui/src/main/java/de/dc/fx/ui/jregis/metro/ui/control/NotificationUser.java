package de.dc.fx.ui.jregis.metro.ui.control;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import de.dc.fx.ui.jregis.metro.ui.di.JRegisPlatform;
import de.dc.fx.ui.jregis.metro.ui.eventbus.EventContext;
import de.dc.fx.ui.jregis.metro.ui.eventbus.IEventBroker;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;

public class NotificationUser extends BaseNotificationUser{

private Logger log = Logger.getLogger(AttachmentControl.class.getSimpleName());
	
	public static final String FXML = "/de/dc/fx/ui/jregis/metro/ui/NotificationUser.fxml";

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
		JRegisPlatform.getInstance(IEventBroker.class).post(new EventContext<>("/close/notification", "user"));
	}

	@Override
	protected void onLinkLockScreenClicked(MouseEvent event) {
		JRegisPlatform.getInstance(IEventBroker.class).post(new EventContext<>("/close/notification", "user"));	
	}

	@Override
	protected void onLinkLogOutClicked(MouseEvent event) {
		JRegisPlatform.getInstance(IEventBroker.class).post(new EventContext<>("/close/notification", "logout"));		
	}

	@Override
	protected void onLinkSettingsClicked(MouseEvent event) {
		JRegisPlatform.getInstance(IEventBroker.class).post(new EventContext<>("/close/notification", "user"));		
	}

	@Override
	protected void onLinkSupportClicked(MouseEvent event) {
		JRegisPlatform.getInstance(IEventBroker.class).post(new EventContext<>("/close/notification", "user"));		
	}

}
