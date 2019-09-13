package de.dc.spring.fx.ui.jregis.metro.ui.preferences;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebView;

public class PreferencePage extends BasePreferencesPage {

	private Logger log = Logger.getLogger(getClass().getSimpleName());
	
	private static final String FXML = "/de/dc/spring/fx/ui/jregis/metro/ui/preferences/Preferences.fxml";

	private boolean isInitialized = false;
	
	public PreferencePage() {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(FXML));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);

		try {
			fxmlLoader.load();
		} catch (IOException exception) {
			log.log(Level.SEVERE, "Failed to load fxml ", exception);
		}
	}
	
	public void init() {
		if (!isInitialized) {
			WebView webView = new WebView();
			Platform.runLater(() -> webView.getEngine().load("http://localhost:8080/h2-console"));
			AnchorPane.setBottomAnchor(webView, 0d);
			AnchorPane.setTopAnchor(webView, 0d);
			AnchorPane.setLeftAnchor(webView, 0d);
			AnchorPane.setRightAnchor(webView, 0d);
			main.getChildren().add(webView);
			isInitialized=true;
		}
	}
}

