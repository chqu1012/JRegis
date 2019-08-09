package de.dc.fx.ui.jregis.metro.ui.control.contact;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

import de.dc.fx.ui.jregis.metro.ui.gen.contacts.dates.model.Dates;
import javafx.fxml.FXMLLoader;

public class ContactDatesItem extends BaseContactDatesItem {

	private Logger log = Logger.getLogger(ContactDatesItem.class.getSimpleName());

	public static final String FXML = "/de/dc/fx/ui/jregis/metro/ui/control/contact/ContactDatesItem.fxml";

	public ContactDatesItem(Dates item) {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(FXML));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);

		try {
			fxmlLoader.load();
		} catch (IOException exception) {
			log.log(Level.SEVERE, "Failed to load fxml " + FXML, exception);
		}
		
		labelDate.setText(item.getDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm")));
		labelDateType.setText(item.getName());
	}
}
