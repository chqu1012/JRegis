package de.dc.fx.ui.jregis.metro.ui.control;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.fxml.FXMLLoader;

public class UserManagementPage extends BaseUserManagementPage {

	private Logger log = Logger.getLogger(AttachmentControl.class.getSimpleName());
	public static final String FXML = "/de/dc/fx/ui/jregis/metro/ui/UserManagement.fxml";

	public UserManagementPage() {
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
