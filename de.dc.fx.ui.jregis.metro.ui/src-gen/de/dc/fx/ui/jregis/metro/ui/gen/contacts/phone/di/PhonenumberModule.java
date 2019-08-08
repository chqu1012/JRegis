package de.dc.fx.ui.jregis.metro.ui.gen.contacts.phone.di;

import com.google.inject.AbstractModule;

import de.dc.fx.ui.jregis.metro.ui.gen.contacts.phone.control.*;
import de.dc.fx.ui.jregis.metro.ui.gen.contacts.phone.model.*;
import de.dc.fx.ui.jregis.metro.ui.gen.contacts.phone.repository.*;

public class PhonenumberModule extends AbstractModule{

	@Override
	protected void configure() {
		bind(PhonenumberFX.class).asEagerSingleton();
		
		bind(PhonenumberRepository.class).asEagerSingleton();
		
		bind(PhonenumberTableView.class).asEagerSingleton();
		bind(PhonenumberFormular.class).asEagerSingleton();
	}
}

