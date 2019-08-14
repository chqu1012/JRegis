package de.dc.fx.ui.jregis.metro.ui.gen.contacts.contact.control;

import com.google.inject.Inject;

import de.dc.fx.ui.jregis.metro.ui.gen.contacts.contact.model.*;
import de.dc.fx.ui.jregis.metro.ui.gen.contacts.contact.repository.*;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.input.MouseEvent;

public class ContactFormular extends VBox{

	private ContactFX context;
	private ContactRepository contactRepository;
	
	@Inject
	public ContactFormular(ContactFX context, ContactRepository contactRepository) {
		this.context = context;
		this.contactRepository = contactRepository;
		
		setPadding(new Insets(10));
		getChildren().add(new Label("Firstname:"));
		javafx.scene.control.TextField firstnameTextField = new javafx.scene.control.TextField();
		firstnameTextField.setPromptText("Please enter a Firstname");
		firstnameTextField.textProperty().bindBidirectional(context.getFirstnameProperty() );
		getChildren().add(firstnameTextField);
		getChildren().add(new Label("Lastname:"));
		javafx.scene.control.TextField lastnameTextField = new javafx.scene.control.TextField();
		lastnameTextField.setPromptText("Please enter a Lastname");
		lastnameTextField.textProperty().bindBidirectional(context.getLastnameProperty() );
		getChildren().add(lastnameTextField);
		getChildren().add(new Label("Username:"));
		javafx.scene.control.TextField usernameTextField = new javafx.scene.control.TextField();
		usernameTextField.setPromptText("Please enter a Username");
		usernameTextField.textProperty().bindBidirectional(context.getUsernameProperty() );
		getChildren().add(usernameTextField);
		getChildren().add(new Label("ContactImageId:"));
		javafx.scene.control.TextField contactImageIdTextField = new javafx.scene.control.TextField();
		contactImageIdTextField.setPromptText("Please enter a ContactImageId");
		contactImageIdTextField.textProperty().bindBidirectional(context.getContactImageIdProperty() , java.text.NumberFormat.getInstance());
		getChildren().add(contactImageIdTextField);
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
		Contact contact = context.getContact ();
		contactRepository.save(contact);
		context.getMasterData().add(contact);
		context.clear();
	}
}
