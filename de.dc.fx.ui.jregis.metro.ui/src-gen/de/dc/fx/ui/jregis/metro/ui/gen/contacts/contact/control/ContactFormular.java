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
		getChildren().add(new Label("Account:"));
		javafx.scene.control.TextField accountTextField = new javafx.scene.control.TextField();
		accountTextField.setPromptText("Please enter a Account");
		accountTextField.textProperty().bindBidirectional(context.getAccountProperty() );
		getChildren().add(accountTextField);
		getChildren().add(new Label("AvatarId:"));
		javafx.scene.control.TextField avatarIdTextField = new javafx.scene.control.TextField();
		avatarIdTextField.setPromptText("Please enter a AvatarId");
		avatarIdTextField.textProperty().bindBidirectional(context.getAvatarIdProperty() , java.text.NumberFormat.getInstance());
		getChildren().add(avatarIdTextField);
		
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
