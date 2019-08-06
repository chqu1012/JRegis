package de.dc.fx.ui.jregis.metro.ui.control.contact;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;

public class ContactPage extends BaseContactPage{

	private Logger log = Logger.getLogger(ContactPage.class.getSimpleName());
	
	public static final String FXML = "/de/dc/fx/ui/jregis/metro/ui/Contacts.fxml";

	public ContactPage() {
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
	protected void onImageViewNewUser(MouseEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onImageViewPreferences(MouseEvent event) {
		// TODO Auto-generated method stub
		
	}

}
