package de.dc.fx.ui.jregis.metro.ui.control.contact;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.controlsfx.control.Notifications;

import de.dc.fx.ui.jregis.metro.ui.di.JRegisPlatform;
import de.dc.fx.ui.jregis.metro.ui.gen.contacts.email.model.Email;
import de.dc.fx.ui.jregis.metro.ui.gen.contacts.email.repository.EmailRepository;
import javafx.application.Platform;
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class ContactEmailItem extends BaseContactEmailItem {

	private Logger log = Logger.getLogger(ContactEmailItem.class.getSimpleName());

	public static final String FXML = "/de/dc/fx/ui/jregis/metro/ui/control/contact/ContactEmailItem.fxml";

	private Email item;

	public ContactEmailItem(Email item) {
		this.item = item;
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(FXML));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);

		try {
			fxmlLoader.load();
		} catch (IOException exception) {
			log.log(Level.SEVERE, "Failed to load fxml " + FXML, exception);
		}
		
		labelEmail.textProperty().bindBidirectional(textEmail.textProperty());
		labelEmailType.textProperty().bindBidirectional(textEmailType.textProperty());
		
		labelEmailType.setText(item.getName());
		labelEmail.setText(item.getAddress());
		
		BooleanBinding isEmailEmptyProperty = textEmail.textProperty().isEmpty();
		BooleanBinding isEmailTypeEmptyProperty = textEmailType.textProperty().isEmpty();
		buttonAccept.disableProperty().bind(isEmailTypeEmptyProperty.or(isEmailEmptyProperty));
	}

	public void setEditMode(boolean isEditMode) {
		if (isEditMode) {
			panelEdit.toFront();
		}else {
			panePreview.toFront();
		}
	}
	
	@Override
	protected void onButtonAccept(ActionEvent event) {
		item.setAddress(textEmail.getText());
		item.setName(textEmailType.getText());
		if (item.getId()!=null) {
			JRegisPlatform.getInstance(EmailRepository.class).update(item);
		}else {
			long itemId = JRegisPlatform.getInstance(EmailRepository.class).save(item);
			item.setId(itemId);
		}
		Platform.runLater(() -> Notifications.create().darkStyle().title("Email added!").text("Created "+textEmail.getText()+"!").show());
		panePreview.toFront();
	}

	@Override
	protected void onButtonCancel(ActionEvent event) {
		if (item.getId()!=null) {
			panePreview.toFront();
		}else {
			Parent parent = root.getParent();
			if (parent instanceof VBox) {
				VBox vbox = (VBox) parent;
				vbox.getChildren().remove(root);
			}
		}
	}

	@Override
	protected void onImageViewDeleteEmail(MouseEvent event) {
		JRegisPlatform.getInstance(EmailRepository.class).delete(item);
		Notifications.create().darkStyle().title("Email delete!").text("Deleted "+textEmail.getText()+"!").show();
		onButtonCancel(null);
	}

	@Override
	protected void onImageViewEditEmail(MouseEvent event) {
		panelEdit.toFront();
	}
}
