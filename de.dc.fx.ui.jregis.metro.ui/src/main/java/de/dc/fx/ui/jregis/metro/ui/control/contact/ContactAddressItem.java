package de.dc.fx.ui.jregis.metro.ui.control.contact;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import de.dc.fx.ui.jregis.metro.ui.gen.contacts.address.model.Address;
import javafx.fxml.FXMLLoader;

public class ContactAddressItem extends BaseContactAddressItem{

	private Logger log = Logger.getLogger(ContactAddressItem.class.getSimpleName());

	public static final String FXML = "/de/dc/fx/ui/jregis/metro/ui/control/contact/ContactAddressItem.fxml";

	public ContactAddressItem(Address item) {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(FXML));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);

		try {
			fxmlLoader.load();
		} catch (IOException exception) {
			log.log(Level.SEVERE, "Failed to load fxml " + FXML, exception);
		}
		
		labelAddress.setText(String.format("%s, %s %s, %s", item.getStreet(), item.getZipCode(), item.getState(), item.getCountry()));
		labelAddressType.setText(item.getAddressType());
	}
}
