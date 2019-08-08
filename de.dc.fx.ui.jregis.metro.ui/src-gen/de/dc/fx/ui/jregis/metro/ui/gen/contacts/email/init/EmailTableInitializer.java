package de.dc.fx.ui.jregis.metro.ui.gen.contacts.email.init;

import java.io.*;
import java.net.URL;
import java.sql.*;

import org.h2.tools.RunScript;

import de.dc.fx.ui.jregis.metro.ui.gen.contacts.email.repository.*;
public class EmailTableInitializer{
	public static void main(String[] args) throws SQLException, FileNotFoundException {
		Connection connection = DriverManager.getConnection(EmailRepository.JDBC_URL,"SA", "SA");
		URL createUrl = EmailTableInitializer.class.getResource("/de/dc/fx/ui/jregis/metro/ui/gen/contacts/email/init/create.sql");
		RunScript.execute(connection, new FileReader(new File(createUrl.getFile())));
		
		System.out.println("Email table initialized!");
	}
}
