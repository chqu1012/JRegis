package de.dc.fx.ui.jregis.metro.ui.gen.contacts.image.di;

import com.google.inject.AbstractModule;

import de.dc.fx.ui.jregis.metro.ui.gen.contacts.image.control.*;
import de.dc.fx.ui.jregis.metro.ui.gen.contacts.image.model.*;
import de.dc.fx.ui.jregis.metro.ui.gen.contacts.image.repository.*;

public class ContactImageModule extends AbstractModule{

	@Override
	protected void configure() {
		bind(ContactImageFX.class).asEagerSingleton();
		
		bind(ContactImageRepository.class).asEagerSingleton();
		
		bind(ContactImageTableView.class).asEagerSingleton();
		bind(ContactImageFormular.class).asEagerSingleton();
	}
}

