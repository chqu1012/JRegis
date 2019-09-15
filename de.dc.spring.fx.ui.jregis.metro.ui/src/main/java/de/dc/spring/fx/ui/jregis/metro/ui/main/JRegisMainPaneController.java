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
import javafx.application.HostServices;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;

@Controller
public class JRegisMainPaneController extends BaseFxmlJRegisMainPaneController {

	private Logger log = Logger.getLogger(getClass().getSimpleName());

	@Autowired ConfigurableApplicationContext springContext;
	@Autowired HostServices hostServices;

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
	
	private Region paneContact;
	private Region paneDocument;
	private Region paneUser;
	private Region paneCalendar;
	private Region paneDocumentDetails;

	public void initialize() {
		paneDocument = load(FXML_DOCUMENT);
		paneUser = load(UIConstants.FXML_USER);
		paneDocumentDetails = load(UIConstants.FXML_DOCUMENT_DETAILS);
		paneContact = load(UIConstants.FXML_CONTACT);
		paneCalendar= load(UIConstants.FXML_CALENDAR);
		
		mainStackPane.getChildren().add(paneCalendar);
		mainStackPane.getChildren().add(paneUser);
		mainStackPane.getChildren().add(paneDocumentDetails);
		mainStackPane.getChildren().add(paneDocument);
		mainStackPane.getChildren().add(paneContact);
		mainStackPane.getChildren().add(preferencePage);
		mainStackPane.getChildren().add(inbox);
		mainStackPane.getChildren().add(profilePage);
		mainStackPane.getChildren().add(dashboard);
		
		popOverNotification.setContentNode(notificationAlerts);
		popOverUser.setContentNode(notificationUser);
		
		EventBroker.getDefault().register(this);
	}

	private Region load(String fxml) {
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
		}else if (source == labelDashboard) {
			dashboard.toFront();
		}else if (source == imageViewAdbook) {
			paneContact.toFront();
		}else if (source == imageViewCalendar) {
			paneCalendar.toFront();
		}
	}

	@Subscribe
	public void subscribeEventBus(EventContext<String> context) {
		String eventId = context.getEventId();
		if (eventId.equals("/close/notification")) {
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
		}else if (eventId.equals("/open/see/all/alerts")) {
			popOverNotification.hide();
			inbox.toFront();
		}else if (eventId.equals("/open/document/details")) {
			paneDocumentDetails.toFront();
		}else if (eventId.equals("/open/file")) {
			hostServices.showDocument(context.getInput());
		}
	}
}
