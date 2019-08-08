package de.dc.fx.ui.jregis.metro.ui.gen.contacts.email;

import de.dc.fx.ui.jregis.metro.ui.gen.contacts.email.control.*;
import de.dc.fx.ui.jregis.metro.ui.gen.contacts.email.di.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class EmailDemo extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		EmailTableView emailTableView = EmailPlatform.getInstance(EmailTableView.class);
		EmailFormular emailFormular = EmailPlatform.getInstance(EmailFormular.class);

		BorderPane root = new BorderPane();
		root.setCenter(emailTableView);
		root.setRight(emailFormular);
		stage.setScene(new Scene(root , 1200, 600));
		stage.show();
	}

	public static void main(String[] args) {
		EmailPlatform.init();
		
		launch(args);
	}
}
