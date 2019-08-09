package de.dc.fx.ui.jregis.metro.ui.gen.calendar.group;

import de.dc.fx.ui.jregis.metro.ui.gen.calendar.group.control.*;
import de.dc.fx.ui.jregis.metro.ui.gen.calendar.group.di.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class XAppointmentGroupDemo extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		XAppointmentGroupTableView xAppointmentGroupTableView = XAppointmentGroupPlatform.getInstance(XAppointmentGroupTableView.class);
		XAppointmentGroupFormular xAppointmentGroupFormular = XAppointmentGroupPlatform.getInstance(XAppointmentGroupFormular.class);

		BorderPane root = new BorderPane();
		root.setCenter(xAppointmentGroupTableView);
		root.setRight(xAppointmentGroupFormular);
		stage.setScene(new Scene(root , 1200, 600));
		stage.show();
	}

	public static void main(String[] args) {
		XAppointmentGroupPlatform.init();
		
		launch(args);
	}
}
