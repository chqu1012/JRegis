package de.dc.fx.ui.jregis.metro.ui.control.contact.feature;

import java.io.IOException;

import org.controlsfx.control.Notifications;

import de.dc.fx.ui.jregis.metro.ui.di.JRegisPlatform;
import de.dc.fx.ui.jregis.metro.ui.eventbus.EventContext;
import de.dc.fx.ui.jregis.metro.ui.eventbus.IEventBroker;
import de.dc.fx.ui.jregis.metro.ui.gen.contacts.contact.model.Contact;
import de.dc.fx.ui.jregis.metro.ui.gen.contacts.contact.repository.ContactRepository;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class ContactListCell extends ListCell<Contact> {

	@FXML
	protected AnchorPane root;

	@FXML
	protected ImageView imageViewUser;

	@FXML
	protected Label labelName;

	@FXML
	protected Label labelUsername;

	@FXML
	protected AnchorPane paneEdit;

	@FXML
	protected TextField textUsername;

	@FXML
	protected TextField textFirstname;

	@FXML
	protected TextField textLastname;

	@FXML
	protected Button buttonAccept;

	private FXMLLoader mLLoader;

	@Override
	protected void updateItem(Contact item, boolean empty) {
		super.updateItem(item, empty);
		if (empty || item == null) {
			setText(null);
			setGraphic(null);

		} else {
			if (mLLoader == null) {
				mLLoader = new FXMLLoader(getClass()
						.getResource("/de/dc/fx/ui/jregis/metro/ui/control/contact/feature/ContactListCell.fxml"));
				mLLoader.setController(this);
				try {
					mLLoader.load();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if (item.getId()==null) {
				paneEdit.toFront();
			}else {
				labelName.setText(item.getFirstname() + " " + item.getLastname());
				labelUsername.setText(item.getUsername());
				root.getChildren().remove(paneEdit);
			}
			setGraphic(root);
		}
	}

	@FXML
	protected void onButtonAccept(ActionEvent event) {
		getItem().setFirstname(textFirstname.getText());
		getItem().setLastname(textLastname.getText());
		getItem().setUsername(textUsername.getText());
		getItem().setContactImageId(0L);
		long contactId = JRegisPlatform.getInstance(ContactRepository.class).save(getItem());
		getItem().setId(contactId);
		
		labelName.setText(getItem().getFirstname() + " " + getItem().getLastname());
		labelUsername.setText(getItem().getUsername());
		root.getChildren().remove(paneEdit);
		
		Platform.runLater(()-> Notifications.create().darkStyle().title("Created new contact").text(textUsername.getText()+" was created!").show());
	}

	@FXML
	protected void onButtonCancel(ActionEvent event) {
		JRegisPlatform.getInstance(IEventBroker.class).post(new EventContext<>("/cancel/contact/create", getItem()));
	}
}
