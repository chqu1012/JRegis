package de.dc.fx.ui.jregis.metro.ui.gen.contacts.contact.di;

import com.google.inject.AbstractModule;

import de.dc.fx.ui.jregis.metro.ui.gen.contacts.contact.control.*;
import de.dc.fx.ui.jregis.metro.ui.gen.contacts.contact.model.*;
import de.dc.fx.ui.jregis.metro.ui.gen.contacts.contact.repository.*;

public class ContactModule extends AbstractModule{

	@Override
	protected void configure() {
		bind(ContactFX.class).asEagerSingleton();
		
		bind(ContactRepository.class).asEagerSingleton();
		
		bind(ContactTableView.class).asEagerSingleton();
		bind(ContactFormular.class).asEagerSingleton();
	}
}

