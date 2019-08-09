package de.dc.fx.ui.jregis.metro.ui.control.contact;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public abstract class BaseContactEmailItem extends HBox{

    @FXML
    protected ImageView imageViewEmail;

    @FXML
    protected Label labelEmailType;

    @FXML
    protected Hyperlink labelEmail;

}
