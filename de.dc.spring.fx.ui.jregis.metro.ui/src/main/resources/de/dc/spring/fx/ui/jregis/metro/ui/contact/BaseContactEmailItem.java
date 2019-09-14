package de.dc.spring.fx.ui.jregis.metro.ui.contact;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

public abstract class BaseContactEmailItem extends AnchorPane{

	@FXML
	protected ImageView imageViewEdit;
	
	@FXML
	protected ImageView imageViewDelete;
	
	@FXML
	protected Button buttonAccept;
	
	@FXML
	protected AnchorPane root;
	
    @FXML
    protected HBox panelEdit;

    @FXML
    protected ImageView imageViewEmailEdit;

    @FXML
    protected TextField textEmailType;

    @FXML
    protected TextField textEmail;

    @FXML
    protected HBox panePreview;

    @FXML
    protected ImageView imageViewEmail;

    @FXML
    protected Label labelEmailType;

    @FXML
    protected Hyperlink labelEmail;

    @FXML
    protected abstract void onButtonAccept(ActionEvent event);

    @FXML
    protected abstract void onButtonCancel(ActionEvent event);

    @FXML
    protected abstract void onImageViewDeleteEmail(MouseEvent event);

    @FXML
    protected abstract void onImageViewEditEmail(MouseEvent event);
}
