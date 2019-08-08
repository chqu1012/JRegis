package de.dc.fx.ui.jregis.metro.ui.control.contact;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public abstract class BaseContactAddressItem extends HBox{

    @FXML
    protected ImageView imageViewAddress;

    @FXML
    protected Label labelAddressType;

    @FXML
    protected Hyperlink labelAddress;

}
