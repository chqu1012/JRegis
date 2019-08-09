package de.dc.fx.ui.jregis.metro.ui.control.contact;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import de.dc.fx.ui.jregis.metro.ui.gen.contacts.email.model.Email;
import javafx.fxml.FXMLLoader;

public class ContactEmailItem extends BaseContactEmailItem {

	private Logger log = Logger.getLogger(ContactEmailItem.class.getSimpleName());

	public static final String FXML = "/de/dc/fx/ui/jregis/metro/ui/control/contact/ContactEmailItem.fxml";

	public ContactEmailItem(Email item) {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(FXML));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);

		try {
			fxmlLoader.load();
		} catch (IOException exception) {
			log.log(Level.SEVERE, "Failed to load fxml " + FXML, exception);
		}
		
		labelEmailType.setText(item.getName());
		labelEmail.setText(item.getAddress());
	}
}
