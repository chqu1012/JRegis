package de.dc.fx.ui.jregis.metro.ui.gen.contacts.dates.di;

import com.google.inject.AbstractModule;

import de.dc.fx.ui.jregis.metro.ui.gen.contacts.dates.control.*;
import de.dc.fx.ui.jregis.metro.ui.gen.contacts.dates.model.*;
import de.dc.fx.ui.jregis.metro.ui.gen.contacts.dates.repository.*;

public class DatesModule extends AbstractModule{

	@Override
	protected void configure() {
		bind(DatesFX.class).asEagerSingleton();
		
		bind(DatesRepository.class).asEagerSingleton();
		
		bind(DatesTableView.class).asEagerSingleton();
		bind(DatesFormular.class).asEagerSingleton();
	}
}

