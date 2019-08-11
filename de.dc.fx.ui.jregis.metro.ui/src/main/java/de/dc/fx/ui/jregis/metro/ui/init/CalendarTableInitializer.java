package de.dc.fx.ui.jregis.metro.ui.init;

import java.io.FileNotFoundException;
import java.sql.SQLException;

import de.dc.fx.ui.jregis.metro.ui.gen.calendar.appointment.init.XAppointmentTableInitializer;
import de.dc.fx.ui.jregis.metro.ui.gen.calendar.group.init.XAppointmentGroupTableInitializer;

public class CalendarTableInitializer {

	public static void main(String[] args) throws FileNotFoundException, SQLException {
		XAppointmentTableInitializer.main(args);
		XAppointmentGroupTableInitializer.main(args);
	}
}
