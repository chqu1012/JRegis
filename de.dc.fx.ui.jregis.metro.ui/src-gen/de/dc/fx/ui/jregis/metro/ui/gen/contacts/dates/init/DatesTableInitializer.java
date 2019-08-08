package de.dc.fx.ui.jregis.metro.ui.gen.contacts.dates.init;

import java.io.*;
import java.net.URL;
import java.sql.*;

import org.h2.tools.RunScript;

import de.dc.fx.ui.jregis.metro.ui.gen.contacts.dates.repository.*;
public class DatesTableInitializer{
	public static void main(String[] args) throws SQLException, FileNotFoundException {
		Connection connection = DriverManager.getConnection(DatesRepository.JDBC_URL,"SA", "SA");
		URL createUrl = DatesTableInitializer.class.getResource("/de/dc/fx/ui/jregis/metro/ui/gen/contacts/dates/init/create.sql");
		RunScript.execute(connection, new FileReader(new File(createUrl.getFile())));
		
		System.out.println("Tables initialized!");
	}
}
