package de.dc.fx.ui.jregis.metro.ui.control.contact.feature;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import org.controlsfx.control.Notifications;

import de.dc.fx.ui.jregis.metro.ui.di.JRegisPlatform;
import de.dc.fx.ui.jregis.metro.ui.eventbus.EventContext;
import de.dc.fx.ui.jregis.metro.ui.eventbus.IEventBroker;
import de.dc.fx.ui.jregis.metro.ui.gen.contacts.contact.model.Contact;
import de.dc.fx.ui.jregis.metro.ui.gen.contacts.contact.repository.ContactRepository;
import de.dc.fx.ui.jregis.metro.ui.gen.contacts.group.model.ContactGroup;
import de.dc.fx.ui.jregis.metro.ui.gen.contacts.group.repository.ContactGroupRepository;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.StringConverter;

public class ContactListCell extends ListCell<Contact> {

	@FXML
	protected ComboBox<ContactGroup> comboBoxGroup;
	
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

	private static List<ContactGroup> contactGroups;
	
	@Override
	protected void updateItem(Contact item, boolean empty) {
		super.updateItem(item, empty);
		if (empty || item == null) {
			setText(null);
			setGraphic(null);

		} else {
			if (contactGroups==null) {
				contactGroups = JRegisPlatform.getInstance(ContactGroupRepository.class).findAll();
				
			}
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
				comboBoxGroup.setItems(FXCollections.observableArrayList(contactGroups));
				comboBoxGroup.getSelectionModel().selectFirst();
				comboBoxGroup.setConverter(new StringConverter<ContactGroup>() {
					@Override
					public String toString(ContactGroup group) {
						return group.getName();
					}
					
					@Override
					public ContactGroup fromString(String name) {
						ContactGroup contactGroup = new ContactGroup();
						contactGroup.setName("");
						List<ContactGroup> groups = JRegisPlatform.getInstance(ContactGroupRepository.class).findAllByName(name);
						if (groups.isEmpty()) {
							return contactGroup;
						}else {
							return groups.get(0);
						}
					}
				});
				
				buttonAccept.disableProperty().bind(comboBoxGroup.getSelectionModel().selectedIndexProperty().isEqualTo(-1)
						.or(textFirstname.textProperty().isEmpty())
						.or(textLastname.textProperty().isEmpty())
						.or(textUsername.textProperty().isEmpty()));
				
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
		getItem().setCreatedOn(LocalDateTime.now());
		getItem().setUpdatedOn(LocalDateTime.now());
		getItem().setContactGroupId(comboBoxGroup.getSelectionModel().getSelectedItem().getId());
		getItem().setStatus(0);
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
