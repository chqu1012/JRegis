package de.dc.fx.ui.jregis.metro.ui.gen.contacts.group.di;

import com.google.inject.AbstractModule;

import de.dc.fx.ui.jregis.metro.ui.gen.contacts.group.control.*;
import de.dc.fx.ui.jregis.metro.ui.gen.contacts.group.model.*;
import de.dc.fx.ui.jregis.metro.ui.gen.contacts.group.repository.*;

public class ContactGroupModule extends AbstractModule{

	@Override
	protected void configure() {
		bind(ContactGroupFX.class).asEagerSingleton();
		
		bind(ContactGroupRepository.class).asEagerSingleton();
		
		bind(ContactGroupTableView.class).asEagerSingleton();
		bind(ContactGroupFormular.class).asEagerSingleton();
	}
}

