package de.dc.fx.ui.jregis.metro.ui.gen.contacts.email.di;

import com.google.inject.AbstractModule;

import de.dc.fx.ui.jregis.metro.ui.gen.contacts.email.control.*;
import de.dc.fx.ui.jregis.metro.ui.gen.contacts.email.model.*;
import de.dc.fx.ui.jregis.metro.ui.gen.contacts.email.repository.*;

public class EmailModule extends AbstractModule{

	@Override
	protected void configure() {
		bind(EmailFX.class).asEagerSingleton();
		
		bind(EmailRepository.class).asEagerSingleton();
		
		bind(EmailTableView.class).asEagerSingleton();
		bind(EmailFormular.class).asEagerSingleton();
	}
}

