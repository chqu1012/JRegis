package de.dc.fx.ui.jregis.metro.ui;

import de.dc.fx.ui.jregis.metro.ui.control.MainApplication;
import de.dc.fx.ui.jregis.metro.ui.di.JRegisPlatform;
import de.dc.fx.ui.jregis.metro.ui.eventbus.EventContext;
import de.dc.fx.ui.jregis.metro.ui.eventbus.IEventBroker;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class JRegisMetroApplication extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = JRegisPlatform.getInstance(MainApplication.class);
		primaryStage.setScene(new Scene(root , 1200, 700));
		primaryStage.show();
		primaryStage.setOnCloseRequest(e -> JRegisPlatform.getInstance(IEventBroker.class).post(new EventContext<Void>("/close/h2/server", null)));
	}
	
	public static void main(String[] args) {
		JRegisPlatform.init();
		
		launch(args);
	}
}
