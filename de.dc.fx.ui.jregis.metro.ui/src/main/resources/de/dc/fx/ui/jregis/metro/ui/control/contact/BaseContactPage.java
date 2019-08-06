package de.dc.fx.ui.jregis.metro.ui.control.contact;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public abstract class BaseContactPage extends SplitPane{

    @FXML
    protected TreeView<?> treeViewEmail;

    @FXML
    protected VBox vboxContactList;

    @FXML
    protected ComboBox<?> comboInboxType;

    @FXML
    protected TextField textSearchContact;

    @FXML
    protected ImageView imageViewUser;

    @FXML
    protected Label labelName;

    @FXML
    protected Label labelNickname;

    @FXML
    protected VBox vboxEmail;

    @FXML
    protected VBox vboxPhoneNumbers;

    @FXML
    protected VBox vboxDates;

    @FXML
    protected VBox vboxAddresses;

    @FXML
    protected abstract void onImageViewNewUser(MouseEvent event);

    @FXML
    protected abstract void onImageViewPreferences(MouseEvent event);

}
