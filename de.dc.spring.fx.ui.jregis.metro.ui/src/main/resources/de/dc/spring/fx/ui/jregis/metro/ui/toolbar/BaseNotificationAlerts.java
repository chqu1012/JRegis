package de.dc.spring.fx.ui.jregis.metro.ui.toolbar;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public abstract class BaseNotificationAlerts extends VBox{

    @FXML
    protected VBox vboxAlerts;

    @FXML
    protected abstract void onLabelSeeAllAlertsClicked(MouseEvent event);

}
