package de.dc.fx.ui.jregis.metro.ui.gen.contacts.address.control;

import com.google.inject.Inject;

import de.dc.fx.ui.jregis.metro.ui.gen.contacts.address.model.*;
import de.dc.fx.ui.jregis.metro.ui.gen.contacts.address.repository.*;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.input.MouseEvent;

public class AddressFormular extends VBox{

	private AddressFX context;
	private AddressRepository addressRepository;
	
	@Inject
	public AddressFormular(AddressFX context, AddressRepository addressRepository) {
		this.context = context;
		this.addressRepository = addressRepository;
		
		setPadding(new Insets(10));
		getChildren().add(new Label("ContactId:"));
		javafx.scene.control.TextField contactIdTextField = new javafx.scene.control.TextField();
		contactIdTextField.setPromptText("Please enter a ContactId");
		contactIdTextField.textProperty().bindBidirectional(context.getContactIdProperty() , java.text.NumberFormat.getInstance());
		getChildren().add(contactIdTextField);
		getChildren().add(new Label("AddressType:"));
		javafx.scene.control.TextField addressTypeTextField = new javafx.scene.control.TextField();
		addressTypeTextField.setPromptText("Please enter a AddressType");
		addressTypeTextField.textProperty().bindBidirectional(context.getAddressTypeProperty() );
		getChildren().add(addressTypeTextField);
		getChildren().add(new Label("Street:"));
		javafx.scene.control.TextField streetTextField = new javafx.scene.control.TextField();
		streetTextField.setPromptText("Please enter a Street");
		streetTextField.textProperty().bindBidirectional(context.getStreetProperty() );
		getChildren().add(streetTextField);
		getChildren().add(new Label("Country:"));
		javafx.scene.control.TextField countryTextField = new javafx.scene.control.TextField();
		countryTextField.setPromptText("Please enter a Country");
		countryTextField.textProperty().bindBidirectional(context.getCountryProperty() );
		getChildren().add(countryTextField);
		getChildren().add(new Label("State:"));
		javafx.scene.control.TextField stateTextField = new javafx.scene.control.TextField();
		stateTextField.setPromptText("Please enter a State");
		stateTextField.textProperty().bindBidirectional(context.getStateProperty() );
		getChildren().add(stateTextField);
		getChildren().add(new Label("ZipCode:"));
		javafx.scene.control.TextField zipCodeTextField = new javafx.scene.control.TextField();
		zipCodeTextField.setPromptText("Please enter a ZipCode");
		zipCodeTextField.textProperty().bindBidirectional(context.getZipCodeProperty() , java.text.NumberFormat.getInstance());
		getChildren().add(zipCodeTextField);
		
		Button submitButton = new Button("Submit");
		submitButton.setOnMouseClicked(this::onButtonSubmit);
		submitButton.disableProperty().bind(context.getEnabledSubmitProperty().not());
		getChildren().add(submitButton);
	}
	
	public void onButtonSubmit(MouseEvent e) {
		Address address = context.getAddress ();
		addressRepository.save(address);
		context.getMasterData().add(address);
		context.clear();
	}
}
