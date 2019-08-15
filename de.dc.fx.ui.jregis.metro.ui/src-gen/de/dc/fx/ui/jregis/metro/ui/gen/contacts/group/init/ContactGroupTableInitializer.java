package de.dc.fx.ui.jregis.metro.ui.gen.contacts.group.init;

import java.io.*;
import java.net.URL;
import java.sql.*;

import org.h2.tools.RunScript;

import de.dc.fx.ui.jregis.metro.ui.gen.contacts.group.repository.*;
public class ContactGroupTableInitializer{
	public static void main(String[] args) throws SQLException, FileNotFoundException {
		Connection connection = DriverManager.getConnection(ContactGroupRepository.JDBC_URL,"SA", "SA");
		URL createUrl = ContactGroupTableInitializer.class.getResource("/de/dc/fx/ui/jregis/metro/ui/gen/contacts/group/init/create.sql");
		RunScript.execute(connection, new FileReader(new File(createUrl.getFile())));
		
		System.out.println("ContactGroup table initialized!");
	}
}
