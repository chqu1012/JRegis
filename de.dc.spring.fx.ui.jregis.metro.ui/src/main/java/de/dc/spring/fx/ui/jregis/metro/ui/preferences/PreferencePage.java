package de.dc.spring.fx.ui.jregis.metro.ui.preferences;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.eventbus.Subscribe;

import de.dc.spring.fx.ui.jregis.metro.ui.events.EventBroker;
import de.dc.spring.fx.ui.jregis.metro.ui.events.EventContext;
import de.dc.spring.fx.ui.jregis.metro.ui.gen.activity.control.ActivityFormular;
import de.dc.spring.fx.ui.jregis.metro.ui.gen.activity.control.ActivityTableView;
import de.dc.spring.fx.ui.jregis.metro.ui.gen.activity.model.ActivityFX;
import de.dc.spring.fx.ui.jregis.metro.ui.gen.activity.repository.ActivityRepository;
import de.dc.spring.fx.ui.jregis.metro.ui.gen.todo.control.TodoFormular;
import de.dc.spring.fx.ui.jregis.metro.ui.gen.todo.control.TodoTableView;
import de.dc.spring.fx.ui.jregis.metro.ui.gen.todo.model.TodoFX;
import de.dc.spring.fx.ui.jregis.metro.ui.gen.todo.repository.TodoRepository;
import javafx.application.Platform;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebView;

@Component
public class PreferencePage extends BasePreferencesPage {

	private boolean isInitialized = false;
	
	@Autowired ActivityTableView tableViewActivity;
	@Autowired ActivityFormular formActivity;
	@Autowired ActivityRepository repositoryActivity;
	@Autowired ActivityFX contextActivity;
	
	@Autowired TodoTableView tableViewTodo;
	@Autowired TodoFormular formTodo;
	@Autowired TodoRepository repositoryTodo;
	@Autowired TodoFX contextTodo;
	
	public void initialize() {
		initPaneActivity();
		initPaneTodo();
		
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

	private void initPaneTodo() {
		contextTodo.getCreatedOnProperty().set(LocalDateTime.now());
		contextTodo.getUpdatedOnProperty().set(LocalDateTime.now());
		
		tableViewTodo.getMasterData().addAll(repositoryTodo.findAll());	
		splitPaneTodo.setDividerPosition(0, 0.75);
		splitPaneTodo.getItems().add(tableViewTodo);
		splitPaneTodo.getItems().add(formTodo);
	}

	private void initPaneActivity() {
		contextActivity.getCreatedOnProperty().set(LocalDateTime.now());
		contextActivity.getUpdatedOnProperty().set(LocalDateTime.now());
		
		tableViewActivity.getMasterData().addAll(repositoryActivity.findAll());
		splitPaneActivity.setDividerPosition(0, 0.75);
		splitPaneActivity.getItems().add(tableViewActivity);
		splitPaneActivity.getItems().add(formActivity);
	}
}

