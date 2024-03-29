package de.dc.spring.fx.ui.jregis.metro.ui.dashboard;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public abstract class BaseDashboard extends ScrollPane{

	@FXML
	protected VBox hboxRecentlyActivities;
	
	@FXML
	protected VBox paneTodoList;
	
	@FXML
	protected Label labelUserCounter;
	
	@FXML
	protected Label labelDocumentsCounter;
	
}
