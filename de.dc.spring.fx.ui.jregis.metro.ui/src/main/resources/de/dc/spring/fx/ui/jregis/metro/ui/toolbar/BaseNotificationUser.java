package de.dc.spring.fx.ui.jregis.metro.ui.toolbar;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public abstract class BaseNotificationUser extends VBox{

    @FXML
    protected Label labelUsername;

    @FXML
    protected abstract void onLinkAccountClicked(MouseEvent event);

    @FXML
    protected abstract void onLinkLockScreenClicked(MouseEvent event);

    @FXML
    protected abstract void onLinkLogOutClicked(MouseEvent event);

    @FXML
    protected abstract void onLinkSettingsClicked(MouseEvent event);

    @FXML
    protected abstract void onLinkSupportClicked(MouseEvent event);

}
