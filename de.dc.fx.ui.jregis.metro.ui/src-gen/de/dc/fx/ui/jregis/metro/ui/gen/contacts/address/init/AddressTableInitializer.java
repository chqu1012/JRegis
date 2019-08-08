package de.dc.fx.ui.jregis.metro.ui.gen.contacts.address.init;

import java.io.*;
import java.net.URL;
import java.sql.*;

import org.h2.tools.RunScript;

import de.dc.fx.ui.jregis.metro.ui.gen.contacts.address.repository.*;
public class AddressTableInitializer{
	public static void main(String[] args) throws SQLException, FileNotFoundException {
		Connection connection = DriverManager.getConnection(AddressRepository.JDBC_URL,"SA", "SA");
		URL createUrl = AddressTableInitializer.class.getResource("/de/dc/fx/ui/jregis/metro/ui/gen/contacts/address/init/create.sql");
		RunScript.execute(connection, new FileReader(new File(createUrl.getFile())));
		
		System.out.println("Tables initialized!");
	}
}
