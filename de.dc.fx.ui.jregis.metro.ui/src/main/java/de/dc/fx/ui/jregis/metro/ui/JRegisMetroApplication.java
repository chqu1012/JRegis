package de.dc.fx.ui.jregis.metro.ui;

import de.dc.fx.ui.jregis.metro.ui.control.MainApplication;
import de.dc.fx.ui.jregis.metro.ui.di.JRegisPlatform;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class JRegisMetroApplication extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = new MainApplication();
		primaryStage.setScene(new Scene(root , 1200, 700));
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		JRegisPlatform.init();
		
		launch(args);
	}
}
