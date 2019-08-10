package de.dc.fx.ui.jregis.metro.ui.gen.contacts.image.control;

import com.google.inject.Inject;

import de.dc.fx.ui.jregis.metro.ui.gen.contacts.image.model.*;
import de.dc.fx.ui.jregis.metro.ui.gen.contacts.image.repository.*;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.input.MouseEvent;

public class ContactImageFormular extends VBox{

	private ContactImageFX context;
	private ContactImageRepository contactImageRepository;
	
	@Inject
	public ContactImageFormular(ContactImageFX context, ContactImageRepository contactImageRepository) {
		this.context = context;
		this.contactImageRepository = contactImageRepository;
		
		setPadding(new Insets(10));
		getChildren().add(new Label("Name:"));
		javafx.scene.control.TextField nameTextField = new javafx.scene.control.TextField();
		nameTextField.setPromptText("Please enter a Name");
		nameTextField.textProperty().bindBidirectional(context.getNameProperty() );
		getChildren().add(nameTextField);
		getChildren().add(new Label("CreatedOn:"));
		jfxtras.scene.control.LocalDateTimeTextField createdOnLocalDateTimeTextField = new jfxtras.scene.control.LocalDateTimeTextField();
		createdOnLocalDateTimeTextField.setPromptText("Please enter a CreatedOn");
		createdOnLocalDateTimeTextField.localDateTimeProperty().bindBidirectional(context.getCreatedOnProperty());
		getChildren().add(createdOnLocalDateTimeTextField);
		
		Button submitButton = new Button("Submit");
		submitButton.setOnMouseClicked(this::onButtonSubmit);
		submitButton.disableProperty().bind(context.getEnabledSubmitProperty().not());
		getChildren().add(submitButton);
	}
	
	public void onButtonSubmit(MouseEvent e) {
		ContactImage contactImage = context.getContactImage ();
		contactImageRepository.save(contactImage);
		context.getMasterData().add(contactImage);
		context.clear();
	}
}
