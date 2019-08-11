package de.dc.fx.ui.jregis.metro.ui.init;

import java.io.FileNotFoundException;
import java.sql.SQLException;

public class AllTableInitializer {

	public static void main(String[] args) throws FileNotFoundException, SQLException {
		System.out.println("** START INITIALISING ****************************************************");
		JRegisTableInitializer.main(args);
		ContactsTableInitializer.main(args);
		CalendarTableInitializer.main(args);
		System.out.println("** END INITIALISING ******************************************************");
	}
}
