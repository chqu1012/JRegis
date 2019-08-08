package de.dc.fx.ui.jregis.metro.ui.gen.contacts.email.control;

import com.google.inject.Inject;

import de.dc.fx.ui.jregis.metro.ui.gen.contacts.email.model.*;
import de.dc.fx.ui.jregis.metro.ui.gen.contacts.email.repository.*;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.input.MouseEvent;

public class EmailFormular extends VBox{

	private EmailFX context;
	private EmailRepository emailRepository;
	
	@Inject
	public EmailFormular(EmailFX context, EmailRepository emailRepository) {
		this.context = context;
		this.emailRepository = emailRepository;
		
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
		getChildren().add(new Label("Email:"));
		javafx.scene.control.TextField emailTextField = new javafx.scene.control.TextField();
		emailTextField.setPromptText("Please enter a Email");
		emailTextField.textProperty().bindBidirectional(context.getEmailProperty() );
		getChildren().add(emailTextField);
		
		Button submitButton = new Button("Submit");
		submitButton.setOnMouseClicked(this::onButtonSubmit);
		submitButton.disableProperty().bind(context.getEnabledSubmitProperty().not());
		getChildren().add(submitButton);
	}
	
	public void onButtonSubmit(MouseEvent e) {
		Email email = context.getEmail ();
		emailRepository.save(email);
		context.getMasterData().add(email);
		context.clear();
	}
}
