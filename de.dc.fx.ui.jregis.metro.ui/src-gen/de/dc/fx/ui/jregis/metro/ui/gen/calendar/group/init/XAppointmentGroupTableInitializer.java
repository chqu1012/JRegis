package de.dc.fx.ui.jregis.metro.ui.gen.calendar.group.init;

import java.io.*;
import java.net.URL;
import java.sql.*;

import org.h2.tools.RunScript;

import de.dc.fx.ui.jregis.metro.ui.gen.calendar.group.repository.*;
public class XAppointmentGroupTableInitializer{
	public static void main(String[] args) throws SQLException, FileNotFoundException {
		Connection connection = DriverManager.getConnection(XAppointmentGroupRepository.JDBC_URL,"SA", "SA");
		URL createUrl = XAppointmentGroupTableInitializer.class.getResource("/de/dc/fx/ui/jregis/metro/ui/gen/calendar/group/init/create.sql");
		RunScript.execute(connection, new FileReader(new File(createUrl.getFile())));
		
		System.out.println("XAppointmentGroup table initialized!");
	}
}
