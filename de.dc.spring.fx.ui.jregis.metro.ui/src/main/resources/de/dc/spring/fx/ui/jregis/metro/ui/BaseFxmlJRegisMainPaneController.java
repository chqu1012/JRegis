package de.dc.spring.fx.ui.jregis.metro.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

public abstract class BaseFxmlJRegisMainPaneController {

	@FXML
	protected BorderPane root;

	@FXML
	protected StackPane mainStackPane;

	@FXML
	protected BorderPane paneLogin;

	@FXML
	protected TextField textUsername;

	@FXML
	protected ImageView imageViewUser;

	@FXML
	protected Button buttonLogin;

	@FXML
	protected PasswordField textPassword;

	@FXML
	protected ImageView imageViewCalendar;

	@FXML
	protected ImageView imageViewAdbook;

	@FXML
	protected ImageView imageViewPreferences;

	@FXML
	protected ImageView imageViewNotification;

	@FXML
	protected HBox panelUser;

	@FXML
	protected abstract void onButtonLoginAction(ActionEvent event);

	@FXML
	protected abstract void onHBoxUserClicked(MouseEvent event);

	@FXML
	protected abstract void onImageViewAdbookClicked(MouseEvent event);

	@FXML
	protected abstract void onImageViewCalendarClicked(MouseEvent event);

	@FXML
	protected abstract void onImageViewNotificationClicked(MouseEvent event);

	@FXML
	protected abstract void onImageViewPreferencesClicked(MouseEvent event);

	@FXML
	protected abstract void onLinkCreateNewUserAction(ActionEvent event);

	@FXML
	protected abstract void onLinkForgottenPasswordAction(ActionEvent event);

	@FXML
	protected abstract void onNavigationItemClicked(MouseEvent event);
}
