package de.dc.fx.ui.jregis.metro.ui.control;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;

public class ProfilePage extends BaseProfile {

	private Logger log = Logger.getLogger(AttachmentControl.class.getSimpleName());
	
	public static final String FXML = "/de/dc/fx/ui/jregis/metro/ui/Profile.fxml";

	public ProfilePage() {
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
	protected void onButtonEditProfile(ActionEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void onLinkClosePage(ActionEvent event) {
		root.toBack();
	}

}
