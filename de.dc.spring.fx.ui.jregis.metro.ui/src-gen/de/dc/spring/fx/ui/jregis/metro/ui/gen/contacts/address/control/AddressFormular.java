package de.dc.spring.fx.ui.jregis.metro.ui.gen.contacts.address.control;

import de.dc.spring.fx.ui.jregis.metro.ui.gen.contacts.address.model.*;
import de.dc.spring.fx.ui.jregis.metro.ui.gen.contacts.address.repository.*;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.input.MouseEvent;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class AddressFormular extends VBox{

	@Autowired private AddressFX context;
	@Autowired private AddressRepository addressRepository;
	
	@PostConstruct
	public void init() {
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
		getChildren().add(new Label("Status:"));
		javafx.scene.control.TextField statusTextField = new javafx.scene.control.TextField();
		statusTextField.setPromptText("Please enter a Status");
		statusTextField.textProperty().bindBidirectional(context.getStatusProperty() , java.text.NumberFormat.getInstance());
		getChildren().add(statusTextField);
		getChildren().add(new Label("CreatedOn:"));
		jfxtras.scene.control.LocalDateTimeTextField createdOnLocalDateTimeTextField = new jfxtras.scene.control.LocalDateTimeTextField();
		createdOnLocalDateTimeTextField.setPromptText("Please enter a CreatedOn");
		createdOnLocalDateTimeTextField.localDateTimeProperty().bindBidirectional(context.getCreatedOnProperty());
		getChildren().add(createdOnLocalDateTimeTextField);
		getChildren().add(new Label("UpdatedOn:"));
		jfxtras.scene.control.LocalDateTimeTextField updatedOnLocalDateTimeTextField = new jfxtras.scene.control.LocalDateTimeTextField();
		updatedOnLocalDateTimeTextField.setPromptText("Please enter a UpdatedOn");
		updatedOnLocalDateTimeTextField.localDateTimeProperty().bindBidirectional(context.getUpdatedOnProperty());
		getChildren().add(updatedOnLocalDateTimeTextField);
		
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
