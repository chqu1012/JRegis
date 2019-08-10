package de.dc.fx.ui.jregis.metro.ui.gen.contacts.image.init;

import java.io.*;
import java.net.URL;
import java.sql.*;

import org.h2.tools.RunScript;

import de.dc.fx.ui.jregis.metro.ui.gen.contacts.image.repository.*;
public class ContactImageTableInitializer{
	public static void main(String[] args) throws SQLException, FileNotFoundException {
		Connection connection = DriverManager.getConnection(ContactImageRepository.JDBC_URL,"SA", "SA");
		URL createUrl = ContactImageTableInitializer.class.getResource("/de/dc/fx/ui/jregis/metro/ui/gen/contacts/image/init/create.sql");
		RunScript.execute(connection, new FileReader(new File(createUrl.getFile())));
		
		System.out.println("ContactImage table initialized!");
	}
}
