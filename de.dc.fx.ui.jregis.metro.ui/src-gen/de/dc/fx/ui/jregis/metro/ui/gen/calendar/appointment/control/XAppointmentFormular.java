package de.dc.fx.ui.jregis.metro.ui.gen.calendar.appointment.control;

import com.google.inject.Inject;

import de.dc.fx.ui.jregis.metro.ui.gen.calendar.appointment.model.*;
import de.dc.fx.ui.jregis.metro.ui.gen.calendar.appointment.repository.*;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.input.MouseEvent;

public class XAppointmentFormular extends VBox{

	private XAppointmentFX context;
	private XAppointmentRepository xAppointmentRepository;
	
	@Inject
	public XAppointmentFormular(XAppointmentFX context, XAppointmentRepository xAppointmentRepository) {
		this.context = context;
		this.xAppointmentRepository = xAppointmentRepository;
		
		setPadding(new Insets(10));
		getChildren().add(new Label("ContactId:"));
		javafx.scene.control.TextField contactIdTextField = new javafx.scene.control.TextField();
		contactIdTextField.setPromptText("Please enter a ContactId");
		contactIdTextField.textProperty().bindBidirectional(context.getContactIdProperty() , java.text.NumberFormat.getInstance());
		getChildren().add(contactIdTextField);
		getChildren().add(new Label("Topic:"));
		javafx.scene.control.TextField topicTextField = new javafx.scene.control.TextField();
		topicTextField.setPromptText("Please enter a Topic");
		topicTextField.textProperty().bindBidirectional(context.getTopicProperty() );
		getChildren().add(topicTextField);
		getChildren().add(new Label("Summary:"));
		javafx.scene.control.TextField summaryTextField = new javafx.scene.control.TextField();
		summaryTextField.setPromptText("Please enter a Summary");
		summaryTextField.textProperty().bindBidirectional(context.getSummaryProperty() );
		getChildren().add(summaryTextField);
		getChildren().add(new Label("Start:"));
		jfxtras.scene.control.LocalDateTimeTextField startLocalDateTimeTextField = new jfxtras.scene.control.LocalDateTimeTextField();
		startLocalDateTimeTextField.setPromptText("Please enter a Start");
		startLocalDateTimeTextField.localDateTimeProperty().bindBidirectional(context.getStartProperty());
		getChildren().add(startLocalDateTimeTextField);
		getChildren().add(new Label("End:"));
		jfxtras.scene.control.LocalDateTimeTextField endLocalDateTimeTextField = new jfxtras.scene.control.LocalDateTimeTextField();
		endLocalDateTimeTextField.setPromptText("Please enter a End");
		endLocalDateTimeTextField.localDateTimeProperty().bindBidirectional(context.getEndProperty());
		getChildren().add(endLocalDateTimeTextField);
		getChildren().add(new Label("AppointmentGroupId:"));
		javafx.scene.control.TextField appointmentGroupIdTextField = new javafx.scene.control.TextField();
		appointmentGroupIdTextField.setPromptText("Please enter a AppointmentGroupId");
		appointmentGroupIdTextField.textProperty().bindBidirectional(context.getAppointmentGroupIdProperty() , java.text.NumberFormat.getInstance());
		getChildren().add(appointmentGroupIdTextField);
		
		Button submitButton = new Button("Submit");
		submitButton.setOnMouseClicked(this::onButtonSubmit);
		submitButton.disableProperty().bind(context.getEnabledSubmitProperty().not());
		getChildren().add(submitButton);
	}
	
	public void onButtonSubmit(MouseEvent e) {
		XAppointment xAppointment = context.getXAppointment ();
		xAppointmentRepository.save(xAppointment);
		context.getMasterData().add(xAppointment);
		context.clear();
	}
}
