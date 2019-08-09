package de.dc.fx.ui.jregis.metro.ui.control.contact;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public abstract class BaseContactDatesItem extends HBox {

    @FXML
    protected ImageView imageView;

    @FXML
    protected Label labelDateType;

    @FXML
    protected Hyperlink labelDate;

}
