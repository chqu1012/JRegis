package de.dc.fx.ui.jregis.metro.ui.gen.contacts.contact;

import de.dc.fx.ui.jregis.metro.ui.gen.contacts.contact.control.*;
import de.dc.fx.ui.jregis.metro.ui.gen.contacts.contact.di.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ContactDemo extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		ContactTableView contactTableView = ContactPlatform.getInstance(ContactTableView.class);
		ContactFormular contactFormular = ContactPlatform.getInstance(ContactFormular.class);

		BorderPane root = new BorderPane();
		root.setCenter(contactTableView);
		root.setRight(contactFormular);
		stage.setScene(new Scene(root , 1200, 600));
		stage.show();
	}

	public static void main(String[] args) {
		ContactPlatform.init();
		
		launch(args);
	}
}
