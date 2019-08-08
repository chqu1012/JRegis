package de.dc.fx.ui.jregis.metro.ui.gen.contacts.address.di;

import com.google.inject.AbstractModule;

import de.dc.fx.ui.jregis.metro.ui.gen.contacts.address.control.*;
import de.dc.fx.ui.jregis.metro.ui.gen.contacts.address.model.*;
import de.dc.fx.ui.jregis.metro.ui.gen.contacts.address.repository.*;

public class AddressModule extends AbstractModule{

	@Override
	protected void configure() {
		bind(AddressFX.class).asEagerSingleton();
		
		bind(AddressRepository.class).asEagerSingleton();
		
		bind(AddressTableView.class).asEagerSingleton();
		bind(AddressFormular.class).asEagerSingleton();
	}
}

