package de.dc.spring.fx.ui.jregis.metro.ui.dashboard;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.fxml.FXMLLoader;

public class RecentlyActivityItem extends BaseRecentlyActivityItem {

	private Logger log = Logger.getLogger(getClass().getSimpleName());
	
	public static final String FXML = "/de/dc/spring/fx/ui/jregis/metro/ui/dashboard/RecentlyActivityItem.fxml";

	public RecentlyActivityItem() {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(FXML));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);

		try {
			fxmlLoader.load();
		} catch (IOException exception) {
			log.log(Level.SEVERE, "Failed to load fxml "+FXML, exception);
		}
	}
}
