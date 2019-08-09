package de.dc.fx.ui.jregis.metro.ui.gen.calendar.appointment;

import de.dc.fx.ui.jregis.metro.ui.gen.calendar.appointment.control.*;
import de.dc.fx.ui.jregis.metro.ui.gen.calendar.appointment.di.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class XAppointmentDemo extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		XAppointmentTableView xAppointmentTableView = XAppointmentPlatform.getInstance(XAppointmentTableView.class);
		XAppointmentFormular xAppointmentFormular = XAppointmentPlatform.getInstance(XAppointmentFormular.class);

		BorderPane root = new BorderPane();
		root.setCenter(xAppointmentTableView);
		root.setRight(xAppointmentFormular);
		stage.setScene(new Scene(root , 1200, 600));
		stage.show();
	}

	public static void main(String[] args) {
		XAppointmentPlatform.init();
		
		launch(args);
	}
}
