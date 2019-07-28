package de.dc.fx.ui.jregis.metro.ui.control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.h2.tools.Server;

import com.google.common.eventbus.Subscribe;

import de.dc.fx.ui.jregis.metro.ui.di.JRegisPlatform;
import de.dc.fx.ui.jregis.metro.ui.eventbus.EventContext;
import de.dc.fx.ui.jregis.metro.ui.eventbus.IEventBroker;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXMLLoader;

public class PreferencePage extends BasePreferencesPage {

	private Logger log = Logger.getLogger(getClass().getSimpleName());
	private Server server;

	public PreferencePage() {
		FXMLLoader fxmlLoader = new FXMLLoader(
				getClass().getResource("/de/dc/fx/ui/jregis/metro/ui/Preferences.fxml"));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);

		try {
			fxmlLoader.load();
		} catch (IOException exception) {
			log.log(Level.SEVERE, "Failed to load fxml ", exception);
		}
		
		JRegisPlatform.getInstance(IEventBroker.class).register(this);
		
		Task<Void> task = new Task<Void>() {
			@Override
			protected Void call() throws Exception {
				startWebView();
				return null;
			}
		};
		new Thread(task).start();
	}

	private void startWebView() {
		try {
			Class.forName("org.h2.Driver");
			server = Server.createWebServer("-web", "-webAllowOthers", "-webPort", "9081");
			server.start();
			String serverUrl = server.getURL();
			Platform.runLater(() ->webView.getEngine().load(serverUrl));
		} catch (ClassNotFoundException | SQLException e) {
			log.log(Level.SEVERE, "Failed to open h2 console!", e);
		}
	}
	
	@Subscribe
	public void stopServer(EventContext<Void> context) {
		if (context.getEventId().equals("/close/h2/server")) {
			server.stop();
		}
	}
}
