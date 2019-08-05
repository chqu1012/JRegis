package de.dc.fx.ui.jregis.metro.ui.control;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

public abstract class BaseRecentlyActivityItem extends AnchorPane{

    @FXML
    protected Circle circle;

    @FXML
    protected Label labelDescription;

    @FXML
    protected Label labelTimestamp;

    @FXML
    protected Label labelUser;

    @FXML
    protected Label labelContent;

}
