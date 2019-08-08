package de.dc.fx.ui.jregis.metro.ui.gen.contacts.address;

import de.dc.fx.ui.jregis.metro.ui.gen.contacts.address.control.*;
import de.dc.fx.ui.jregis.metro.ui.gen.contacts.address.di.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class AddressDemo extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		AddressTableView addressTableView = AddressPlatform.getInstance(AddressTableView.class);
		AddressFormular addressFormular = AddressPlatform.getInstance(AddressFormular.class);

		BorderPane root = new BorderPane();
		root.setCenter(addressTableView);
		root.setRight(addressFormular);
		stage.setScene(new Scene(root , 1200, 600));
		stage.show();
	}

	public static void main(String[] args) {
		AddressPlatform.init();
		
		launch(args);
	}
}
