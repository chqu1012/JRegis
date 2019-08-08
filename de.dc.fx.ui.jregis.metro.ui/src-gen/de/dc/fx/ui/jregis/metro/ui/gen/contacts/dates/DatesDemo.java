package de.dc.fx.ui.jregis.metro.ui.gen.contacts.dates;

import de.dc.fx.ui.jregis.metro.ui.gen.contacts.dates.control.*;
import de.dc.fx.ui.jregis.metro.ui.gen.contacts.dates.di.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class DatesDemo extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		DatesTableView datesTableView = DatesPlatform.getInstance(DatesTableView.class);
		DatesFormular datesFormular = DatesPlatform.getInstance(DatesFormular.class);

		BorderPane root = new BorderPane();
		root.setCenter(datesTableView);
		root.setRight(datesFormular);
		stage.setScene(new Scene(root , 1200, 600));
		stage.show();
	}

	public static void main(String[] args) {
		DatesPlatform.init();
		
		launch(args);
	}
}
