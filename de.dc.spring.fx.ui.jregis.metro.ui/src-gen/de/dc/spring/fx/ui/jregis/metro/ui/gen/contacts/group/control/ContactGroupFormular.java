package de.dc.spring.fx.ui.jregis.metro.ui.gen.contacts.group.control;

import de.dc.spring.fx.ui.jregis.metro.ui.gen.contacts.group.model.*;
import de.dc.spring.fx.ui.jregis.metro.ui.gen.contacts.group.repository.*;
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
public class ContactGroupFormular extends VBox{

	@Autowired private ContactGroupFX context;
	@Autowired private ContactGroupRepository contactGroupRepository;
	
	@PostConstruct
	public void init() {
		setPadding(new Insets(10));
		getChildren().add(new Label("Name:"));
		javafx.scene.control.TextField nameTextField = new javafx.scene.control.TextField();
		nameTextField.setPromptText("Please enter a Name");
		nameTextField.textProperty().bindBidirectional(context.getNameProperty() );
		getChildren().add(nameTextField);
		getChildren().add(new Label("Status:"));
		javafx.scene.control.TextField statusTextField = new javafx.scene.control.TextField();
		statusTextField.setPromptText("Please enter a Status");
		statusTextField.textProperty().bindBidirectional(context.getStatusProperty() , java.text.NumberFormat.getInstance());
		getChildren().add(statusTextField);
		getChildren().add(new Label("Color:"));
		javafx.scene.control.TextField colorTextField = new javafx.scene.control.TextField();
		colorTextField.setPromptText("Please enter a Color");
		colorTextField.textProperty().bindBidirectional(context.getColorProperty() );
		getChildren().add(colorTextField);
		getChildren().add(new Label("HoverColor:"));
		javafx.scene.control.TextField hoverColorTextField = new javafx.scene.control.TextField();
		hoverColorTextField.setPromptText("Please enter a HoverColor");
		hoverColorTextField.textProperty().bindBidirectional(context.getHoverColorProperty() );
		getChildren().add(hoverColorTextField);
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
		ContactGroup contactGroup = context.getContactGroup ();
		contactGroupRepository.save(contactGroup);
		context.getMasterData().add(contactGroup);
		context.clear();
	}
}
