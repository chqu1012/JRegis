package de.dc.fx.ui.jregis.metro.ui.control;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onLinkLockScreenClicked(MouseEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onLinkLogOutClicked(MouseEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onLinkSettingsClicked(MouseEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onLinkSupportClicked(MouseEvent event) {
		// TODO Auto-generated method stub
		
	}

}
