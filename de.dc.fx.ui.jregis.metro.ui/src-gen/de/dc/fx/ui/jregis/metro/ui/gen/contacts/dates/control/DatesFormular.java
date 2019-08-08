package de.dc.fx.ui.jregis.metro.ui.gen.contacts.dates.control;

import com.google.inject.Inject;

import de.dc.fx.ui.jregis.metro.ui.gen.contacts.dates.model.*;
import de.dc.fx.ui.jregis.metro.ui.gen.contacts.dates.repository.*;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.input.MouseEvent;

public class DatesFormular extends VBox{

	private DatesFX context;
	private DatesRepository datesRepository;
	
	@Inject
	public DatesFormular(DatesFX context, DatesRepository datesRepository) {
		this.context = context;
		this.datesRepository = datesRepository;
		
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
		getChildren().add(new Label("Date:"));
		jfxtras.scene.control.LocalDateTimeTextField dateLocalDateTimeTextField = new jfxtras.scene.control.LocalDateTimeTextField();
		dateLocalDateTimeTextField.setPromptText("Please enter a Date");
		dateLocalDateTimeTextField.localDateTimeProperty().bindBidirectional(context.getDateProperty());
		getChildren().add(dateLocalDateTimeTextField);
		
		Button submitButton = new Button("Submit");
		submitButton.setOnMouseClicked(this::onButtonSubmit);
		submitButton.disableProperty().bind(context.getEnabledSubmitProperty().not());
		getChildren().add(submitButton);
	}
	
	public void onButtonSubmit(MouseEvent e) {
		Dates dates = context.getDates ();
		datesRepository.save(dates);
		context.getMasterData().add(dates);
		context.clear();
	}
}
