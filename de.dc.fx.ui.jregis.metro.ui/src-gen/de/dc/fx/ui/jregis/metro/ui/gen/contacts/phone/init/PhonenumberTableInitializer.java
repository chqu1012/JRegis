package de.dc.fx.ui.jregis.metro.ui.gen.contacts.phone.init;

import java.io.*;
import java.net.URL;
import java.sql.*;

import org.h2.tools.RunScript;

import de.dc.fx.ui.jregis.metro.ui.gen.contacts.phone.repository.*;
public class PhonenumberTableInitializer{
	public static void main(String[] args) throws SQLException, FileNotFoundException {
		Connection connection = DriverManager.getConnection(PhonenumberRepository.JDBC_URL,"SA", "SA");
		URL createUrl = PhonenumberTableInitializer.class.getResource("/de/dc/fx/ui/jregis/metro/ui/gen/contacts/phone/init/create.sql");
		RunScript.execute(connection, new FileReader(new File(createUrl.getFile())));
		
		System.out.println("Tables initialized!");
	}
}
