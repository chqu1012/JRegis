package de.dc.spring.fx.ui.jregis.metro.ui.gen.contacts.phone.control;

import de.dc.spring.fx.ui.jregis.metro.ui.gen.contacts.phone.model.*;
import de.dc.spring.fx.ui.jregis.metro.ui.gen.contacts.phone.repository.*;
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
public class ContactPhonenumberFormular extends VBox{

	@Autowired private ContactPhonenumberFX context;
	@Autowired private ContactPhonenumberRepository contactPhonenumberRepository;
	
	@PostConstruct
	public void init() {
		setPadding(new Insets(10));
		getChildren().add(new Label("ContactId:"));
		javafx.scene.control.TextField contactIdTextField = new javafx.scene.control.TextField();
		contactIdTextField.setPromptText("Please enter a ContactId");
		contactIdTextField.textProperty().bindBidirectional(context.getContactIdProperty() , java.text.NumberFormat.getInstance());
		getChildren().add(contactIdTextField);
		getChildren().add(new Label("Name:"));
		javafx.scene.control.TextField nameTextField = new javafx.scene.control.TextField();
		nameTextField.setPromptText("Please enter a Name");
		nameTextField.textProperty().bindBidirectional(context.getNameProperty() );
		getChildren().add(nameTextField);
		getChildren().add(new Label("Number:"));
		javafx.scene.control.TextField numberTextField = new javafx.scene.control.TextField();
		numberTextField.setPromptText("Please enter a Number");
		numberTextField.textProperty().bindBidirectional(context.getNumberProperty() );
		getChildren().add(numberTextField);
		getChildren().add(new Label("NumberType:"));
		javafx.scene.control.TextField numberTypeTextField = new javafx.scene.control.TextField();
		numberTypeTextField.setPromptText("Please enter a NumberType");
		numberTypeTextField.textProperty().bindBidirectional(context.getNumberTypeProperty() );
		getChildren().add(numberTypeTextField);
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
		ContactPhonenumber contactPhonenumber = context.getContactPhonenumber ();
		contactPhonenumberRepository.save(contactPhonenumber);
		context.getMasterData().add(contactPhonenumber);
		context.clear();
	}
}
