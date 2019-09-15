package de.dc.spring.fx.ui.jregis.metro.ui.contact.feature;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;

import de.dc.spring.fx.ui.jregis.metro.ui.events.EventBroker;
import de.dc.spring.fx.ui.jregis.metro.ui.events.EventContext;
import de.dc.spring.fx.ui.jregis.metro.ui.gen.contacts.contact.model.Contact;
import de.dc.spring.fx.ui.jregis.metro.ui.gen.contacts.group.model.ContactGroup;
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

	private Logger log = Logger.getLogger(getClass().getSimpleName());
	
	@FXML
	protected Label labelGroupname;
	
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

	public static List<ContactGroup> contactGroups;
	
	@Override
	protected void updateItem(Contact item, boolean empty) {
		super.updateItem(item, empty);
		if (empty || item == null) {
			setText(null);
			setGraphic(null);

		} else {
			if (mLLoader == null) {
				mLLoader = new FXMLLoader(getClass()
						.getResource("/de/dc/spring/fx/ui/jregis/metro/ui/contact/feature/ContactListCell.fxml"));
				mLLoader.setController(this);
				try {
					mLLoader.load();
				} catch (IOException e) {
					log.error("Failed to load fxml", e);
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
						if (contactGroups.isEmpty()) {
							return contactGroup;
						}else {
							return contactGroups.get(0);
						}
					}
				});
				
				buttonAccept.disableProperty().bind(comboBoxGroup.getSelectionModel().selectedIndexProperty().isEqualTo(-1)
						.or(textFirstname.textProperty().isEmpty())
						.or(textLastname.textProperty().isEmpty())
						.or(textUsername.textProperty().isEmpty()));
				
				paneEdit.toFront();
			}else {
				Optional<ContactGroup> optionalGroup = contactGroups.stream().filter(e->e.getId().equals(item.getContactGroupId())).findFirst();
				if(optionalGroup.isPresent()){
					ContactGroup group = optionalGroup.get();
					labelGroupname.setText(group.getName());
					
					String color = group.getColor()==null? "gray" : "#"+group.getColor();
					labelGroupname.setStyle(String.format("-fx-background-color: %s; -fx-background-radius: 5; -fx-text-fill: white;", color));
				}
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
		
		labelName.setText(getItem().getFirstname() + " " + getItem().getLastname());
		labelUsername.setText(getItem().getUsername());
		root.getChildren().remove(paneEdit);

		EventBroker.getDefault().post(new EventContext<>("/new/contact/create", getItem()));
	}

	@FXML
	protected void onButtonCancel(ActionEvent event) {
		EventBroker.getDefault().post(new EventContext<>("/cancel/contact/create", getItem()));
	}
}
