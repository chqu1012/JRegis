package de.dc.fx.ui.jregis.metro.ui.control.contact;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.controlsfx.control.Notifications;

import javafx.application.Platform;
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public abstract class BaseContactItem<T> extends AnchorPane {

    @FXML
    protected AnchorPane root;

    @FXML
    protected HBox panePreview;

    @FXML
    protected ImageView imageViewMain;

    @FXML
    protected Label labelType;

    @FXML
    protected Hyperlink labelValue;

    @FXML
    protected ImageView imageViewEdit;

    @FXML
    protected ImageView imageViewDelete;

    @FXML
    protected HBox panelEdit;

    @FXML
    protected TextField textType;

    @FXML
    protected TextField textValue;

    @FXML
    protected Button buttonAccept;

    @FXML
    protected abstract void onButtonAccept(ActionEvent event);

    @FXML
	protected void onButtonCancel(ActionEvent event) {
		if (getItemId(item)!=null) {
			panePreview.toFront();
		}else {
			Parent parent = root.getParent();
			if (parent instanceof VBox) {
				VBox vbox = (VBox) parent;
				vbox.getChildren().remove(root);
			}
		}
	}

    @FXML
	protected void onImageViewDeleteItem(MouseEvent event) {
    	deleteItem(item);
    	Platform.runLater(() -> Notifications.create().darkStyle().title(getClass().getSimpleName()+" delete!").text("Deleted "+textValue.getText()+"!").show());
		Parent parent = root.getParent();
		if (parent instanceof VBox) {
			VBox vbox = (VBox) parent;
			vbox.getChildren().remove(root);
		}
	}
    
    protected abstract void deleteItem(T item);

    protected abstract Long getItemId(T item);

	@FXML
	protected void onImageViewEditItem(MouseEvent event) {
		panelEdit.toFront();
	}
    
    private Logger log = Logger.getLogger(ContactAddressItem.class.getSimpleName());

	public static final String FXML = "/de/dc/fx/ui/jregis/metro/ui/control/contact/ContactBaseItem.fxml";

	protected T item;
	
	public BaseContactItem(T item) {
		this.item=item;
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(FXML));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);

		try {
			fxmlLoader.load();
		} catch (IOException exception) {
			log.log(Level.SEVERE, "Failed to load fxml " + FXML, exception);
		}
		
		Image image = getImage(getImageName());
		if (image!=null) {
			imageViewEdit.setImage(image);
			imageViewMain.setImage(image);
		}
		
		initializeEditFields();
	}

	protected void initializeEditFields() {
		labelValue.textProperty().bindBidirectional(textValue.textProperty());
		labelType.textProperty().bindBidirectional(textType.textProperty());
		
		labelType.setText(getType()==null? "" : getType());
		labelValue.setText(getValue()==null? "" : getValue());

		BooleanBinding isValueEmptyProperty = textValue.textProperty().isEmpty();
		BooleanBinding isTypeEmptyProperty = textType.textProperty().isEmpty();
		buttonAccept.disableProperty().bind(isTypeEmptyProperty.or(isValueEmptyProperty));
	}
	
	public void setEditMode(boolean isEditMode) {
		if (isEditMode) {
			panelEdit.toFront();
		}else {
			panePreview.toFront();
		}
	}
	
	protected abstract String getValue();

	protected abstract String getType();

	protected abstract String getImageName();

	public Image getImage(String imageName) {
		return new Image(getClass().getResourceAsStream("/de/dc/fx/ui/jregis/metro/ui/images/"+imageName));
	}
	
	@FXML
	protected void onLinkValueAction(ActionEvent e) {
	}

}
