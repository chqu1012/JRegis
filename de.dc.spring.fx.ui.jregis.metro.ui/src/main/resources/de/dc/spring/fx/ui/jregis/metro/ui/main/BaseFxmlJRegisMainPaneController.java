package de.dc.spring.fx.ui.jregis.metro.ui.main;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
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
    protected Label labelDashboard;

    @FXML
    protected Label labelDocument;

    @FXML
    protected Label labelUserManagement;

    @FXML
    protected Label labelInformation;

    @FXML
    protected Label labelLicense;

    @FXML
    protected Label labelPreferences;

    @FXML
    protected abstract void onHBoxUserClicked(MouseEvent event);

    @FXML
    protected abstract void onMouseClicked(MouseEvent event);
}
