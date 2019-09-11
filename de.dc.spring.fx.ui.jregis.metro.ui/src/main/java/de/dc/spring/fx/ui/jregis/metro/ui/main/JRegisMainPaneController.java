package de.dc.spring.fx.ui.jregis.metro.ui.main;

import static de.dc.spring.fx.ui.jregis.metro.ui.main.UIConstants.FXML_DOCUMENT;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;

import de.dc.spring.fx.ui.jregis.metro.ui.events.IEventBroker;
import de.dc.spring.fx.ui.jregis.metro.ui.main.BaseFxmlJRegisMainPaneController;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

@Controller
public class JRegisMainPaneController extends BaseFxmlJRegisMainPaneController {

	private Logger log = Logger.getLogger(getClass().getSimpleName());

	@Autowired ConfigurableApplicationContext springContext;
	@Autowired IEventBroker eventBroker;

	Pane paneDocument;

	public void initialize() {
		paneDocument = load(FXML_DOCUMENT);
		mainStackPane.getChildren().add(paneDocument);
		
		eventBroker.register(this);
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
		// TODO Auto-generated method stub

	}

	@Override
	protected void onMouseClicked(MouseEvent event) {
		Object source = event.getSource();
		if (source == labelDocument) {
			paneDocument.toFront();
		}
	}

//	@Subscribe
//	public void openSeeAllAlertsPane(EventContext<String> context) {
//		if (context.getEventId().equals("/open/see/all/alerts")) {
//			popOverNotification.hide();
//			inbox.toFront();
//		}
//	}
//
//	@Subscribe
//	public void closeNotificationViaEventBroker(EventContext<String> context) {
//		if (context.getEventId().equals("/close/notification")) {
//			if (context.getInput().equals("user")) {
//				popOverUser.hide();
//				profilePage.toFront();
//			} else if (context.getInput().equals("preferences")) {
//				popOverUser.hide();
//			} else if (context.getInput().equals("notifications")) {
//				popOverUser.hide();
//			} else if (context.getInput().equals("logout")) {
//				popOverUser.hide();
//				paneLogin.toFront();
//			}
//		}
//	}
//
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
//	protected void onImageViewNotificationClicked(MouseEvent event) {
//		popOverNotification.setArrowLocation(ArrowLocation.TOP_RIGHT);
//		popOverNotification.setDetachable(false);
//		popOverNotification.setAutoFix(true);
//		popOverNotification.show(imageViewNotification);
//	}
//
//	@Override
//	protected void onImageViewPreferencesClicked(MouseEvent event) {
//		popOverPreferences.setArrowLocation(ArrowLocation.TOP_RIGHT);
//		popOverPreferences.setDetachable(false);
//		popOverPreferences.setAutoFix(true);
//		popOverPreferences.show(imageViewPreferences);
//	}
//
//	@Override
//	protected void onHBoxUserClicked(MouseEvent event) {
//		popOverUser.setArrowLocation(ArrowLocation.TOP_CENTER);
//		popOverUser.setContentNode(new NotificationUser());
//		popOverUser.setDetachable(false);
//		popOverUser.setAutoFix(true);
//		popOverUser.setArrowSize(0);
//		popOverUser.show(panelUser);
//	}
//
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
