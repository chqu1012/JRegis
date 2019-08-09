package de.dc.fx.ui.jregis.metro.ui.gen.calendar.group.control;

import com.google.inject.Inject;

import de.dc.fx.ui.jregis.metro.ui.gen.calendar.group.model.*;
import de.dc.fx.ui.jregis.metro.ui.gen.calendar.group.repository.*;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.input.MouseEvent;

public class XAppointmentGroupFormular extends VBox{

	private XAppointmentGroupFX context;
	private XAppointmentGroupRepository xAppointmentGroupRepository;
	
	@Inject
	public XAppointmentGroupFormular(XAppointmentGroupFX context, XAppointmentGroupRepository xAppointmentGroupRepository) {
		this.context = context;
		this.xAppointmentGroupRepository = xAppointmentGroupRepository;
		
		setPadding(new Insets(10));
		getChildren().add(new Label("AppointmentId:"));
		javafx.scene.control.TextField appointmentIdTextField = new javafx.scene.control.TextField();
		appointmentIdTextField.setPromptText("Please enter a AppointmentId");
		appointmentIdTextField.textProperty().bindBidirectional(context.getAppointmentIdProperty() , java.text.NumberFormat.getInstance());
		getChildren().add(appointmentIdTextField);
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
		XAppointmentGroup xAppointmentGroup = context.getXAppointmentGroup ();
		xAppointmentGroupRepository.save(xAppointmentGroup);
		context.getMasterData().add(xAppointmentGroup);
		context.clear();
	}
}
