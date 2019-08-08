package de.dc.fx.ui.jregis.metro.ui.control.contact;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.inject.Inject;

import de.dc.fx.ui.jregis.metro.ui.control.contact.feature.ContactListCell;
import de.dc.fx.ui.jregis.metro.ui.gen.contacts.address.model.Address;
import de.dc.fx.ui.jregis.metro.ui.gen.contacts.address.repository.AddressRepository;
import de.dc.fx.ui.jregis.metro.ui.gen.contacts.contact.model.Contact;
import de.dc.fx.ui.jregis.metro.ui.gen.contacts.contact.model.ContactFX;
import de.dc.fx.ui.jregis.metro.ui.gen.contacts.contact.repository.ContactRepository;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener.Change;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class ContactPage extends BaseContactPage {

	private Logger log = Logger.getLogger(ContactPage.class.getSimpleName());

	public static final String FXML = "/de/dc/fx/ui/jregis/metro/ui/control/contact/Contacts.fxml";

	@Inject ContactRepository contactRepository;
	@Inject AddressRepository addressRepository;
	@Inject ContactFX context;

	private ObservableList<Contact> contacts = FXCollections.observableArrayList();
	private FilteredList<Contact> filteredContacts = new FilteredList<>(contacts, p-> true); 
	
	@Inject
	public ContactPage(ContactRepository contactRepository, ContactFX context) {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(FXML));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);

		try {
			fxmlLoader.load();
		} catch (IOException exception) {
			log.log(Level.SEVERE, "Failed to load fxml " + FXML, exception);
		}

		listViewContacts.setCellFactory(e -> new ContactListCell());
		listViewContacts.getSelectionModel().selectedItemProperty()
		.addListener((observable, oldValue, newValue) -> onContactSelectionChanged(newValue));
		context.getAddressListProperty().addListener(this::onAddressListSelectionChanged);
		
		contacts.addAll(contactRepository.findAll());
		listViewContacts.setItems(filteredContacts);
		 
		textSearchContact.textProperty().addListener((observable, oldValue, newValue) -> {
			context.getFilteredMasterData().setPredicate(p -> {
				boolean isEmpty = p == null || newValue.isEmpty();
				boolean isFirstnameEquals = p.getFirstname().toLowerCase().contains(newValue.toLowerCase());
				boolean isLastnameEquals = p.getLastname().toLowerCase().contains(newValue.toLowerCase());
				boolean isUsernameEquals = p.getUsername().toLowerCase().contains(newValue.toLowerCase());
				return isEmpty || isFirstnameEquals || isLastnameEquals || isUsernameEquals;
			});
		});

		initBinding(context);
	}

	private void onAddressListSelectionChanged(Change<? extends Address> c) {
		ObservableList<Address> addressList = context.getAddressListProperty().get();
		vboxAddresses.getChildren().clear();
		addressList.forEach(e->{
			vboxAddresses.getChildren().add(new ContactAddressItem(e));
		});
	}

	private void onContactSelectionChanged(Contact newValue) {
		if (newValue!=null) {
			newValue.getAddressList().clear();
			List<Address> addressList = addressRepository.findAllByContactId(newValue.getId());
			newValue.getAddressList().addAll(addressList);
			context.getContactProperty().set(newValue);
		}
	}

	private void initBinding(ContactFX context) {
		labelName.textProperty()
				.bind(Bindings.format("%s %s", context.getFirstnameProperty(), context.getLastnameProperty()));
		labelNickname.textProperty().bind(context.getUsernameProperty());
	}

	public void addContactItem(Contact contact) {
		vboxContactList.getChildren().add(new Button(contact.getUsername()));
	}

	@Override
	protected void onImageViewNewUser(MouseEvent event) {

	}

	@Override
	protected void onImageViewPreferences(MouseEvent event) {
		// TODO Auto-generated method stub

	}

}
