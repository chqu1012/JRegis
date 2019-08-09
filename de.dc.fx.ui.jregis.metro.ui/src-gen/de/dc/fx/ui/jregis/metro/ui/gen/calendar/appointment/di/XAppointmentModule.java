package de.dc.fx.ui.jregis.metro.ui.gen.calendar.appointment.di;

import com.google.inject.AbstractModule;

import de.dc.fx.ui.jregis.metro.ui.gen.calendar.appointment.control.*;
import de.dc.fx.ui.jregis.metro.ui.gen.calendar.appointment.model.*;
import de.dc.fx.ui.jregis.metro.ui.gen.calendar.appointment.repository.*;

public class XAppointmentModule extends AbstractModule{

	@Override
	protected void configure() {
		bind(XAppointmentFX.class).asEagerSingleton();
		
		bind(XAppointmentRepository.class).asEagerSingleton();
		
		bind(XAppointmentTableView.class).asEagerSingleton();
		bind(XAppointmentFormular.class).asEagerSingleton();
	}
}

