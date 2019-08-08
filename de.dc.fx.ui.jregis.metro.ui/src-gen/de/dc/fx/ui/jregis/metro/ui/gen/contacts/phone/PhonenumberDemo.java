package de.dc.fx.ui.jregis.metro.ui.gen.contacts.phone;

import de.dc.fx.ui.jregis.metro.ui.gen.contacts.phone.control.*;
import de.dc.fx.ui.jregis.metro.ui.gen.contacts.phone.di.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class PhonenumberDemo extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		PhonenumberTableView phonenumberTableView = PhonenumberPlatform.getInstance(PhonenumberTableView.class);
		PhonenumberFormular phonenumberFormular = PhonenumberPlatform.getInstance(PhonenumberFormular.class);

		BorderPane root = new BorderPane();
		root.setCenter(phonenumberTableView);
		root.setRight(phonenumberFormular);
		stage.setScene(new Scene(root , 1200, 600));
		stage.show();
	}

	public static void main(String[] args) {
		PhonenumberPlatform.init();
		
		launch(args);
	}
}
