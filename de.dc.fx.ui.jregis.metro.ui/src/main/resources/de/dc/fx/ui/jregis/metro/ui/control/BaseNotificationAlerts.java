package de.dc.fx.ui.jregis.metro.ui.control;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public abstract class BaseNotificationAlerts extends VBox{

    @FXML
    protected VBox vboxAlerts;

    @FXML
    protected abstract void onLabelSeeAllAlertsClicked(MouseEvent event);

}
