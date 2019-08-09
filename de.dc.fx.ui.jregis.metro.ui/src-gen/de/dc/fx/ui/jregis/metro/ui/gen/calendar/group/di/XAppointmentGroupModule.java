package de.dc.fx.ui.jregis.metro.ui.gen.calendar.group.di;

import com.google.inject.AbstractModule;

import de.dc.fx.ui.jregis.metro.ui.gen.calendar.group.control.*;
import de.dc.fx.ui.jregis.metro.ui.gen.calendar.group.model.*;
import de.dc.fx.ui.jregis.metro.ui.gen.calendar.group.repository.*;

public class XAppointmentGroupModule extends AbstractModule{

	@Override
	protected void configure() {
		bind(XAppointmentGroupFX.class).asEagerSingleton();
		
		bind(XAppointmentGroupRepository.class).asEagerSingleton();
		
		bind(XAppointmentGroupTableView.class).asEagerSingleton();
		bind(XAppointmentGroupFormular.class).asEagerSingleton();
	}
}

