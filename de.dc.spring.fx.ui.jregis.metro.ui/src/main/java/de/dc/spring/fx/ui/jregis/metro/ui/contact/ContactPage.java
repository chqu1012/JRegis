package de.dc.spring.fx.ui.jregis.metro.ui.contact;

import java.io.File;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.logging.Logger;

import org.controlsfx.control.Notifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.google.common.eventbus.Subscribe;

import de.dc.spring.fx.ui.jregis.metro.ui.contact.feature.ContactListCell;
import de.dc.spring.fx.ui.jregis.metro.ui.events.EventBroker;
import de.dc.spring.fx.ui.jregis.metro.ui.events.EventContext;
import de.dc.spring.fx.ui.jregis.metro.ui.gen.contacts.address.model.Address;
import de.dc.spring.fx.ui.jregis.metro.ui.gen.contacts.address.repository.AddressRepository;
import de.dc.spring.fx.ui.jregis.metro.ui.gen.contacts.contact.model.Contact;
import de.dc.spring.fx.ui.jregis.metro.ui.gen.contacts.contact.model.ContactFX;
import de.dc.spring.fx.ui.jregis.metro.ui.gen.contacts.contact.repository.ContactRepository;
import de.dc.spring.fx.ui.jregis.metro.ui.gen.contacts.dates.model.Dates;
import de.dc.spring.fx.ui.jregis.metro.ui.gen.contacts.dates.repository.DatesRepository;
import de.dc.spring.fx.ui.jregis.metro.ui.gen.contacts.email.model.Email;
import de.dc.spring.fx.ui.jregis.metro.ui.gen.contacts.email.repository.EmailRepository;
import de.dc.spring.fx.ui.jregis.metro.ui.gen.contacts.group.model.ContactGroup;
import de.dc.spring.fx.ui.jregis.metro.ui.gen.contacts.group.repository.ContactGroupRepository;
import de.dc.spring.fx.ui.jregis.metro.ui.gen.contacts.image.model.ContactImage;
import de.dc.spring.fx.ui.jregis.metro.ui.gen.contacts.image.repository.ContactImageRepository;
import de.dc.spring.fx.ui.jregis.metro.ui.gen.contacts.phone.model.Phonenumber;
import de.dc.spring.fx.ui.jregis.metro.ui.gen.contacts.phone.repository.PhonenumberRepository;
import de.dc.spring.fx.ui.jregis.metro.ui.util.DialogUtil;
import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener.Change;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

@Controller
public class ContactPage extends BaseContactPage {

	private Logger log = Logger.getLogger(getClass().getSimpleName());

	public static final String FXML = "/de/dc/spring/fx/ui/jregis/metro/ui/contact/Contacts.fxml";

	@Autowired PhonenumberRepository phoneRepository;
	@Autowired ContactRepository contactRepository;
	@Autowired AddressRepository addressRepository;
	@Autowired EmailRepository emailRepository;
	@Autowired DatesRepository datesRepository;
	@Autowired ContactImageRepository contactImageRepository;
	@Autowired ContactGroupRepository contactGroupRepository;
	@Autowired ContactFX context;

	private ObservableList<Contact> contacts = FXCollections.observableArrayList();
	private FilteredList<Contact> filteredContacts = new FilteredList<>(contacts, p -> true);
	private ObservableList<ContactGroup> contactGruops = FXCollections.observableArrayList();
	private ObservableList<Contact> deletedContacts = FXCollections.observableArrayList();
	
	public void initialize() {
		listViewContacts.setCellFactory(e -> new ContactListCell());
		listViewContacts.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> onContactSelectionChanged(newValue));

		contactGruops.addAll(contactGroupRepository.findAll());
		
		ContactListCell.contactGroups = contactGruops;
		
		listViewContactGroups.setItems(contactGruops);
		listViewContactGroups.setCellFactory(param -> new ListCell<ContactGroup>() {
			protected void updateItem(ContactGroup item, boolean empty) {
				super.updateItem(item, empty);
				if (item==null || empty) {
					setText(null);
				}else {
					setText(item.getName());
				}
			}
		});
		listViewContactGroups.setOnMouseClicked(arg0 -> {
			ContactGroup selection = listViewContactGroups.getSelectionModel().getSelectedItem();
			if (selection!=null) {
				filteredContacts.setPredicate(p->p.getContactGroupId()==selection.getId());
			}
		});
		
		// React on list changes
		context.getAddressListProperty().addListener(this::onAddressListSelectionChanged);
		context.getEmailsProperty().addListener(this::onEmailListSelectionChanged);
		context.getDateListProperty().addListener(this::onDatesListSelectionChanged);
		context.getPhoneListProperty().addListener(this::onPhoneListSelectionChanged);
		context.getContactImageIdProperty().addListener(this::onContactImageIdSelectionChanged);
		
		contacts.addAll(contactRepository.findAll());
//		deletedContacts.addAll(contactRepository.findAllByStatus(-1));
//		filteredContacts.setPredicate(p->pp.getStatus()==0);
		listViewContacts.setItems(filteredContacts);

		textSearchContact.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredContacts.setPredicate(p -> {
				boolean isEmpty = p == null || newValue.isEmpty();
				boolean isFirstnameEquals = p.getFirstname().toLowerCase().contains(newValue.toLowerCase());
				boolean isLastnameEquals = p.getLastname().toLowerCase().contains(newValue.toLowerCase());
				boolean isUsernameEquals = p.getUsername().toLowerCase().contains(newValue.toLowerCase());
				return isEmpty || isFirstnameEquals || isLastnameEquals || isUsernameEquals;
			});
		});

		initBinding(context);
		
		EventBroker.getDefault().register(this);
	}

	@Subscribe
	public void cancelCreateContactViaEventBroker(EventContext<Contact> context) {
		if (context.getEventId().equals("/cancel/contact/create")) {
			contacts.remove(context.getInput());
		}
	}
	
	private void onAddressListSelectionChanged(Change<? extends Address> c) {
		Platform.runLater(()->{
			ObservableList<Address> addressList = context.getAddressListProperty().get();
			vboxAddresses.getChildren().clear();
			addressList.forEach(e -> {
				ContactAddressItem item = new ContactAddressItem(e);
				vboxAddresses.getChildren().add(item);
			});
		});
	}

	private void onEmailListSelectionChanged(Change<? extends Email> c) {
		Platform.runLater(()->{
			ObservableList<Email> emailList = context.getEmailsProperty().get();
			vboxEmail.getChildren().clear();
			emailList.forEach(e -> {
				ContactEmailItem item = new ContactEmailItem(e);
				vboxEmail.getChildren().add(item);
			});
		});
	}

	private void onDatesListSelectionChanged(Change<? extends Dates> c) {
		Platform.runLater(()->{
			ObservableList<Dates> datesList = context.getDateListProperty().get();
			vboxDates.getChildren().clear();
			datesList.forEach(e -> {
				ContactDatesItem item = new ContactDatesItem(e);
				vboxDates.getChildren().add(item);
			});
		});
	}

	private void onContactImageIdSelectionChanged(Observable e) {
		Platform.runLater(()->{
			Contact contact = context.getContactProperty().get();
			Optional<ContactImage> optionalImage = contactImageRepository.findById(contact.getContactImageId());
			if (optionalImage.isPresent()) {
//				File image = JRegisPlatform.getInstance(ContactFolderService.class).getImage(contact, optionalImage.get().getName());
//				imageViewUser.setImage(new Image(image.toURI().toString()));
			}else {
				imageViewUser.setImage(new Image(getClass().getResourceAsStream("/de/dc/fx/ui/jregis/metro/ui/images/icons8-name-100.png")));
			}
		});
	}

	private void onPhoneListSelectionChanged(Change<? extends Phonenumber> c) {
		ObservableList<Phonenumber> phoneList = context.getPhoneListProperty().get();
		vboxPhoneNumbers.getChildren().clear();
		phoneList.forEach(e -> {
			ContactPhonenumberItem item = new ContactPhonenumberItem(e);
			vboxPhoneNumbers.getChildren().add(item);
		});
	}

	private void onContactSelectionChanged(Contact newValue) {
		if (newValue != null) {
			panePreview.setVisible(true);
						
			newValue.getAddressList().clear();
			newValue.getEmails().clear();
			newValue.getDateList().clear();
			newValue.getPhoneList().clear();

			Long id = newValue.getId();
			if (id!=null) {
//				List<Address> addressList = addressRepository.findAllByContactId(id);
//				newValue.getAddressList().addAll(addressList);
//				
//				List<Email> emails = emailRepository.findAllByContactId(newValue.getId());
//				newValue.getEmails().addAll(emails);
//				
//				List<Dates> dates = datesRepository.findAllByContactId(newValue.getId());
//				newValue.getDateList().addAll(dates);
//				
//				List<Phonenumber> phones = phoneRepository.findAllByContactId(newValue.getId());
//				newValue.getPhoneList().addAll(phones);
//				
//				context.getContactProperty().set(newValue);
			}
		}
	}

	private void initBinding(ContactFX context) {
		labelName.textProperty()
				.bind(Bindings.format("%s %s", context.getFirstnameProperty(), context.getLastnameProperty()));
		labelNickname.textProperty().bind(context.getUsernameProperty());
		labelContactsSize.textProperty().bind(Bindings.size(contacts).asString());
		labelDeletedContactSize.textProperty().bind(Bindings.size(deletedContacts).asString());
	}

	public void addContactItem(Contact contact) {
		vboxContactList.getChildren().add(new Button(contact.getUsername()));
	}

	@Override
	protected void onImageViewNewUser(MouseEvent event) {
		contacts.add(0, new Contact());
		listViewContacts.refresh();
	}

	@Override
	protected void onImageViewPreferences(MouseEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void onImageViewAddClicked(MouseEvent event) {
		Contact contact = listViewContacts.getSelectionModel().getSelectedItem();
		if (contact!=null) {
			Long contactId = contact.getId();
			if (event.getSource() == imageViewAddEmail) {
				Email newEmail = new Email();
				newEmail.setContactId(contactId);
				ContactEmailItem item = new ContactEmailItem(newEmail);
				item.setEditMode(true);
				vboxEmail.getChildren().add(item);
			}else if (event.getSource()==imageViewAddPhonenumbers) {
				Phonenumber phonenumber = new Phonenumber();
				phonenumber.setContactId(contactId);
				ContactPhonenumberItem item = new ContactPhonenumberItem(phonenumber);
				item.setEditMode(true);
				vboxPhoneNumbers.getChildren().add(item);
			}else if (event.getSource()==imageViewAddDates) {
				Dates dates = new Dates();
				dates.setContactId(contactId);
				ContactDatesItem item = new ContactDatesItem(dates);
				item.setEditMode(true);
				vboxDates.getChildren().add(item);
			}else if (event.getSource()==imageViewAddAddress) {
				Address address = new Address();
				address.setContactId(contactId);
				ContactAddressItem item = new ContactAddressItem(address);
				item.setEditMode(true);
				vboxAddresses.getChildren().add(item);
			}
		}
	}

	@Override
	protected void onImageViewUserClicked(MouseEvent event) {
		if (event.getClickCount()==2) {
			FileChooser chooser = new FileChooser();
			File file = chooser.showOpenDialog(new Stage());
			if (file!=null) {
				Contact selection = listViewContacts.getSelectionModel().getSelectedItem();
//				
//				JRegisPlatform.getInstance(ContactFolderService.class).copyFile(selection, file);
//				
//				ContactImage image = new ContactImage();
//				image.setCreatedOn(LocalDateTime.now());
//				image.setName(file.getName());
//				long imageId = JRegisPlatform.getInstance(ContactImageRepository.class).save(image);
//				image.setId(imageId);
//				
//				selection.setContactImageId(imageId);
//				JRegisPlatform.getInstance(ContactRepository.class).update(selection);
				
				imageViewUser.setImage(new Image(file.toURI().toString()));
			}
		}
	}

	@Override
	protected void onMenuItemDeleteContact(ActionEvent event) {
		Contact selection = listViewContacts.getSelectionModel().getSelectedItem();
		if (selection==null) {
			return;
		}
		DialogUtil.openQuestion("Delete Contact Dialog", "Delete Contact Operation", "Do you really want to delete this contact "+selection.getUsername()).ifPresent(e->{
			if(e.getButtonData().equals(ButtonData.OK_DONE)) {
//				contactRepository.updateStatus(selection.getId(), -1);
//				
//				// TODO: Handle emails, address, phonenumbers and dates?
//				Platform.runLater(()->{
//					contacts.remove(selection);
//					deletedContacts.add(selection);
//					Notifications.create().darkStyle().text("Contact "+selection.getUsername()+" deleted!").title("Deleted contact").show();
//				});
			}
		});
	}

	@Override
	protected void onButtonClicked(MouseEvent event) {
		if (event.getSource()==imageViewDeleteContacts) {
			DialogUtil.openQuestion("Clear Dialog", "Clear Operations", "Clear trashcan with "+labelDeletedContactSize.getText()+" contact(s)?").ifPresent(e->{
				if (e.getButtonData().equals(ButtonData.OK_DONE)) {
					filteredContacts.setPredicate(p->false);
				}
			});
		}else if (event.getSource()==labelDeletedContactName) {
			filteredContacts.setPredicate(p->p.getStatus()==-1);
		}else if (event.getSource()==labelAllContactsName) {
			filteredContacts.setPredicate(p->true);
		}
	}

	@Override
	protected void onMenuItemAction(ActionEvent event) {
		Object source = event.getSource();
		if (source == menuItemNewGroup) {
			DialogUtil.openInput("New Group", "New Group*", "Create new group", "Do you want to create a new group?", e->{
				ContactGroup group = new ContactGroup(e, 0, LocalDateTime.now(), LocalDateTime.now());
				group.setColor("blue");
				group.setHoverColor("blue");
				contactGroupRepository.save(group);
				contactGruops.add(group);
				
				Notifications.create().darkStyle().title("New Group").text("Created new group "+e).show();
			});
		}
	}

}
