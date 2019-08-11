package de.dc.fx.ui.jregis.metro.ui.init;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.h2.tools.RunScript;

import de.dc.fx.ui.jregis.metro.ui.repository.BaseRepository;

public class JRegisTableInitializer{
	public static void main(String[] args) throws SQLException, FileNotFoundException {
		Connection connection = DriverManager.getConnection(BaseRepository.JDBC_URL,"SA", "SA");
		URL createUrl = JRegisTableInitializer.class.getResource("/sql/create.sql");
		URL createUserUrl = JRegisTableInitializer.class.getResource("/sql/create_user.sql");
		RunScript.execute(connection, new FileReader(new File(createUrl.getFile())));
		RunScript.execute(connection, new FileReader(new File(createUserUrl.getFile())));
		
		System.out.println("Tables initialized!");
	}
}

