package de.dc.fx.ui.jregis.metro.ui.init;

import java.io.FileNotFoundException;
import java.sql.SQLException;

import de.dc.fx.ui.jregis.metro.ui.gen.contacts.address.init.AddressTableInitializer;
import de.dc.fx.ui.jregis.metro.ui.gen.contacts.contact.init.ContactTableInitializer;
import de.dc.fx.ui.jregis.metro.ui.gen.contacts.dates.init.DatesTableInitializer;
import de.dc.fx.ui.jregis.metro.ui.gen.contacts.email.init.EmailTableInitializer;
import de.dc.fx.ui.jregis.metro.ui.gen.contacts.group.init.ContactGroupTableInitializer;
import de.dc.fx.ui.jregis.metro.ui.gen.contacts.image.init.ContactImageTableInitializer;
import de.dc.fx.ui.jregis.metro.ui.gen.contacts.phone.init.PhonenumberTableInitializer;

public class ContactsTableInitializer {

	public static void main(String[] args) throws FileNotFoundException, SQLException {
		ContactTableInitializer.main(args);
		AddressTableInitializer.main(args);
		DatesTableInitializer.main(args);
		EmailTableInitializer.main(args);
		PhonenumberTableInitializer.main(args);
		ContactGroupTableInitializer.main(args);
		ContactImageTableInitializer.main(args);
	}

}
