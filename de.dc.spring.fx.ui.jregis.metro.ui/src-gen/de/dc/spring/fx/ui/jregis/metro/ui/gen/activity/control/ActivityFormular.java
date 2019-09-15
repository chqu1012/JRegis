package de.dc.spring.fx.ui.jregis.metro.ui.gen.activity.control;

import de.dc.spring.fx.ui.jregis.metro.ui.gen.activity.model.*;
import de.dc.spring.fx.ui.jregis.metro.ui.gen.activity.repository.*;
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
public class ActivityFormular extends VBox{

	@Autowired private ActivityFX context;
	@Autowired private ActivityRepository activityRepository;
	
	@PostConstruct
	public void init() {
		setPadding(new Insets(10));
		getChildren().add(new Label("Title:"));
		javafx.scene.control.TextField titleTextField = new javafx.scene.control.TextField();
		titleTextField.setPromptText("Please enter a Title");
		titleTextField.textProperty().bindBidirectional(context.getTitleProperty() );
		getChildren().add(titleTextField);
		getChildren().add(new Label("Status:"));
		javafx.scene.control.TextField statusTextField = new javafx.scene.control.TextField();
		statusTextField.setPromptText("Please enter a Status");
		statusTextField.textProperty().bindBidirectional(context.getStatusProperty() , java.text.NumberFormat.getInstance());
		getChildren().add(statusTextField);
		getChildren().add(new Label("UserId:"));
		javafx.scene.control.TextField userIdTextField = new javafx.scene.control.TextField();
		userIdTextField.setPromptText("Please enter a UserId");
		userIdTextField.textProperty().bindBidirectional(context.getUserIdProperty() , java.text.NumberFormat.getInstance());
		getChildren().add(userIdTextField);
		getChildren().add(new Label("Description:"));
		javafx.scene.control.TextField descriptionTextField = new javafx.scene.control.TextField();
		descriptionTextField.setPromptText("Please enter a Description");
		descriptionTextField.textProperty().bindBidirectional(context.getDescriptionProperty() );
		getChildren().add(descriptionTextField);
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
		Activity activity = context.getActivity ();
		activityRepository.save(activity);
		context.getMasterData().add(activity);
		context.clear();
	}
}
