package de.dc.fx.ui.jregis.metro.ui.gen.calendar.appointment.init;

import java.io.*;
import java.net.URL;
import java.sql.*;

import org.h2.tools.RunScript;

import de.dc.fx.ui.jregis.metro.ui.gen.calendar.appointment.repository.*;
public class XAppointmentTableInitializer{
	public static void main(String[] args) throws SQLException, FileNotFoundException {
		Connection connection = DriverManager.getConnection(XAppointmentRepository.JDBC_URL,"SA", "SA");
		URL createUrl = XAppointmentTableInitializer.class.getResource("/de/dc/fx/ui/jregis/metro/ui/gen/calendar/appointment/init/create.sql");
		RunScript.execute(connection, new FileReader(new File(createUrl.getFile())));
		
		System.out.println("XAppointment table initialized!");
	}
}
