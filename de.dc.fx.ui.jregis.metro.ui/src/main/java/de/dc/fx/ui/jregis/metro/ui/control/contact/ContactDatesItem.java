package de.dc.fx.ui.jregis.metro.ui.control.contact;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

import de.dc.fx.ui.jregis.metro.ui.di.JRegisPlatform;
import de.dc.fx.ui.jregis.metro.ui.eventbus.EventContext;
import de.dc.fx.ui.jregis.metro.ui.eventbus.IEventBroker;
import de.dc.fx.ui.jregis.metro.ui.gen.contacts.dates.model.Dates;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;

public class ContactDatesItem extends BaseContactDatesItem {

	private Logger log = Logger.getLogger(ContactDatesItem.class.getSimpleName());

	public static final String FXML = "/de/dc/fx/ui/jregis/metro/ui/control/contact/ContactDatesItem.fxml";

	private Dates item;

	public ContactDatesItem(Dates item) {
		this.item = item;
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

	@Override
	protected void onLinkDateAction(ActionEvent event) {
		JRegisPlatform.getInstance(IEventBroker.class).post(new EventContext<Dates>("/open/contact/date", item));
	}
}
