package de.dc.fx.ui.jregis.metro.ui.gen.contacts.group;

import de.dc.fx.ui.jregis.metro.ui.gen.contacts.group.control.*;
import de.dc.fx.ui.jregis.metro.ui.gen.contacts.group.di.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ContactGroupDemo extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		ContactGroupTableView contactGroupTableView = ContactGroupPlatform.getInstance(ContactGroupTableView.class);
		ContactGroupFormular contactGroupFormular = ContactGroupPlatform.getInstance(ContactGroupFormular.class);

		BorderPane root = new BorderPane();
		root.setCenter(contactGroupTableView);
		root.setRight(contactGroupFormular);
		stage.setScene(new Scene(root , 1200, 600));
		stage.show();
	}

	public static void main(String[] args) {
		ContactGroupPlatform.init();
		
		launch(args);
	}
}
