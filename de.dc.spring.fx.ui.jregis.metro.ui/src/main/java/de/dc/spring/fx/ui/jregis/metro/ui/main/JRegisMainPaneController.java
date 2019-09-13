package de.dc.spring.fx.ui.jregis.metro.ui.main;

import static de.dc.spring.fx.ui.jregis.metro.ui.main.UIConstants.FXML_DOCUMENT;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.controlsfx.control.PopOver;
import org.controlsfx.control.PopOver.ArrowLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;

import com.google.common.eventbus.Subscribe;

import de.dc.spring.fx.ui.jregis.metro.ui.dashboard.Dashboard;
import de.dc.spring.fx.ui.jregis.metro.ui.events.EventBroker;
import de.dc.spring.fx.ui.jregis.metro.ui.events.EventContext;
import de.dc.spring.fx.ui.jregis.metro.ui.inbox.Inbox;
import de.dc.spring.fx.ui.jregis.metro.ui.preferences.PreferencePage;
import de.dc.spring.fx.ui.jregis.metro.ui.toolbar.NotificationAlerts;
import de.dc.spring.fx.ui.jregis.metro.ui.toolbar.NotificationUser;
import de.dc.spring.fx.ui.jregis.metro.ui.toolbar.ProfilePage;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

@Controller
public class JRegisMainPaneController extends BaseFxmlJRegisMainPaneController {

	private Logger log = Logger.getLogger(getClass().getSimpleName());

	@Autowired ConfigurableApplicationContext springContext;

	private NotificationUser notificationUser = new NotificationUser();
	private NotificationAlerts notificationAlerts = new NotificationAlerts();
	
	// No injection required, only static pages
	private ProfilePage profilePage = new ProfilePage();
	private Inbox inbox = new Inbox();
	private PreferencePage preferencePage = new PreferencePage();
	private Dashboard dashboard = new Dashboard();
	
	private PopOver popOverNotification = new PopOver();
	private PopOver popOverPreferences = new PopOver();
	private PopOver popOverUser = new PopOver();
	
	private Pane paneDocument;
	private Pane paneUser;

	public void initialize() {
		paneDocument = load(FXML_DOCUMENT);
		paneUser = load(UIConstants.FXML_USER);
		
		mainStackPane.getChildren().add(paneUser);
		mainStackPane.getChildren().add(preferencePage);
		mainStackPane.getChildren().add(inbox);
		mainStackPane.getChildren().add(profilePage);
		mainStackPane.getChildren().add(paneDocument);
		mainStackPane.getChildren().add(dashboard);
		
		popOverNotification.setContentNode(notificationAlerts);
		popOverUser.setContentNode(notificationUser);
		
		EventBroker.getDefault().register(this);
	}

	private Pane load(String fxml) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxml));
	        fxmlLoader.setControllerFactory(springContext::getBean);
			return fxmlLoader.load();
		} catch (IOException e) {
			log.error("Failed to load fxml " + fxml, e);
		}
		return null;
	}

	@Override
	protected void onHBoxUserClicked(MouseEvent event) {
		popOverUser.setArrowLocation(ArrowLocation.TOP_CENTER);
		popOverUser.setDetachable(false);
		popOverUser.setAutoFix(true);
		popOverUser.setArrowSize(0);
		popOverUser.show(panelUser);
	}

	@Override
	protected void onMouseClicked(MouseEvent event) {
		Object source = event.getSource();
		if (source == labelDocument) {
			paneDocument.toFront();
		}else if (source == imageViewNotification) {
			popOverNotification.setArrowLocation(ArrowLocation.TOP_RIGHT);
			popOverNotification.setDetachable(false);
			popOverNotification.setAutoFix(true);
			popOverNotification.show(imageViewNotification);
		}else if (source == imageViewPreferences) {
			popOverPreferences.setArrowLocation(ArrowLocation.TOP_RIGHT);
			popOverPreferences.setDetachable(false);
			popOverPreferences.setAutoFix(true);
			popOverPreferences.show(imageViewPreferences);
		}else if (source== labelPreferences) {
			preferencePage.toFront();
			preferencePage.init();
		}else if (source == labelUserManagement) {
			paneUser.toFront();
		}
	}

	@Subscribe
	public void subscribeEventBus(EventContext<String> context) {
		if (context.getEventId().equals("/close/notification")) {
			if (context.getInput().equals("user")) {
				popOverUser.hide();
				profilePage.toFront();
			} else if (context.getInput().equals("preferences")) {
				popOverUser.hide();
			} else if (context.getInput().equals("notifications")) {
				popOverUser.hide();
			} else if (context.getInput().equals("logout")) {
				popOverUser.hide();
//				paneLogin.toFront();
			}
		}else if (context.getEventId().equals("/open/see/all/alerts")) {
			popOverNotification.hide();
			inbox.toFront();
		}
	}
	
//	public void initialize() {
//		initData();
//		initTableView();
//		initCategoryComboBox();
//		initControls();
//		initBindings();
//
//		popOverNotification.setContentNode(new NotificationAlerts());
//		mainStackPane.getChildren().add(preferencePage);
//		mainStackPane.getChildren().add(JRegisPlatform.getInstance(UserManagementPage.class));
//		mainStackPane.getChildren().add(documentFlatDetails);
//		mainStackPane.getChildren().add(profilePage);
//		mainStackPane.getChildren().add(dashboard);
//		mainStackPane.getChildren().add(inbox);
//		mainStackPane.getChildren().add(JRegisPlatform.getInstance(ContactPage.class));
//		mainStackPane.getChildren().add(calendarPage);
//
//		dashboard.toFront();
//	}

//	@Override
//	protected void onNavigationItemClicked(MouseEvent event) {
//		Object source = event.getSource();
//		if (source instanceof Label) {
//			Label label = (Label) source;
//			if (label.getText().equals("Dashboard")) {
//				dashboard.toFront();
//			} else if (label.getText().equals("Document")) {
//				paneDocumentTableView.toFront();
//			} else if (label.getText().equals("User Management")) {
//				userManagementPage.toFront();
//			} else if (label.getText().equals("Information")) {
//
//			} else if (label.getText().equals("License")) {
//
//			} else if (label.getText().equals("Preferences")) {
//				preferencePage.toFront();
//			}
//		}
//	}
//
//	@Override
//	protected void onImageViewAdbookClicked(MouseEvent event) {
//		contactPage.toFront();
//	}
//
//	@Override
//	protected void onImageViewCalendarClicked(MouseEvent event) {
//		calendarPage.toFront();
//	}
}
