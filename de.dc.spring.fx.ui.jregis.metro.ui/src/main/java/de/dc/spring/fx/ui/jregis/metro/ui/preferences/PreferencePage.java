package de.dc.spring.fx.ui.jregis.metro.ui.preferences;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.eventbus.Subscribe;

import de.dc.spring.fx.ui.jregis.metro.ui.events.EventBroker;
import de.dc.spring.fx.ui.jregis.metro.ui.events.EventContext;
import de.dc.spring.fx.ui.jregis.metro.ui.gen.activity.control.ActivityFormular;
import de.dc.spring.fx.ui.jregis.metro.ui.gen.activity.control.ActivityTableView;
import de.dc.spring.fx.ui.jregis.metro.ui.gen.activity.repository.ActivityRepository;
import javafx.application.Platform;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebView;

@Component
public class PreferencePage extends BasePreferencesPage {

	private boolean isInitialized = false;
	
	@Autowired ActivityTableView tableViewActivity;
	@Autowired ActivityFormular formActivity;
	@Autowired ActivityRepository repositoryActivity;
	
	public void initialize() {
		initPaneActivity();
		
		EventBroker.getDefault().register(this);
	}
	
	@Subscribe
	public void subscribeEventBroker(EventContext<String> context) {
		if (context.getEventId().equals("/init/web/browser/preferences") && !isInitialized) {
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

	private void initPaneActivity() {
		tableViewActivity.getMasterData().addAll(repositoryActivity.findAll());
		borderPaneActivity.setCenter(tableViewActivity);
		borderPaneActivity.setRight(formActivity);
	}
}

