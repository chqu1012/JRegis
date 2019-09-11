package de.dc.spring.fx.ui.jregis.metro.ui.inbox;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public abstract class BaseInboxItem extends AnchorPane{

    @FXML
    protected ImageView imageViewuser;

    @FXML
    protected Label labelSender;

    @FXML
    protected Label labelTopic;

    @FXML
    protected Label labelTimestamp;

    @FXML
    protected Label labelDescription;

}
