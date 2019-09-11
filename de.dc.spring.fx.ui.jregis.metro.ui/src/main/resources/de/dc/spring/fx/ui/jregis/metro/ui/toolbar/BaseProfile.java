package de.dc.spring.fx.ui.jregis.metro.ui.toolbar;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;

public abstract class BaseProfile extends ScrollPane{

	@FXML
	protected ScrollPane root;
	
    @FXML
    protected ImageView imageViewUser;

    @FXML
    protected Label labelUsername;

    @FXML
    protected Label labelRole;

    @FXML
    protected Label labelTotalCountOfDocument;

    @FXML
    protected Label labelUserSince;

    @FXML
    protected Label labelLastUpdate;

    @FXML
    protected abstract void onButtonEditProfile(ActionEvent event);

    @FXML
    protected abstract void onLinkClosePage(ActionEvent event);

}
