package de.dc.fx.ui.jregis.metro.ui.gen.contacts.image;

import de.dc.fx.ui.jregis.metro.ui.gen.contacts.image.control.*;
import de.dc.fx.ui.jregis.metro.ui.gen.contacts.image.di.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ContactImageDemo extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		ContactImageTableView contactImageTableView = ContactImagePlatform.getInstance(ContactImageTableView.class);
		ContactImageFormular contactImageFormular = ContactImagePlatform.getInstance(ContactImageFormular.class);

		BorderPane root = new BorderPane();
		root.setCenter(contactImageTableView);
		root.setRight(contactImageFormular);
		stage.setScene(new Scene(root , 1200, 600));
		stage.show();
	}

	public static void main(String[] args) {
		ContactImagePlatform.init();
		
		launch(args);
	}
}
