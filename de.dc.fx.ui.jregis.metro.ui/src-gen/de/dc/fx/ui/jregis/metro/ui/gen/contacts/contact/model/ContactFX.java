package de.dc.fx.ui.jregis.metro.ui.gen.contacts.contact.model;

import de.dc.fx.ui.jregis.metro.ui.gen.contacts.contact.model.*;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;

import java.lang.String;
import java.lang.String;
import java.lang.String;
import java.lang.Long;

public class ContactFX {
	
  private Contact contact;
  private ObjectProperty<Contact> contactProperty = new SimpleObjectProperty<>();
  private ObservableList<Contact> masterData = FXCollections.observableArrayList();
  private FilteredList<Contact> filteredMasterData = new FilteredList<>(masterData, p-> true);
  
  private LongProperty idProperty = new SimpleLongProperty();
  private BooleanProperty enableSubmitProperty = new SimpleBooleanProperty(false);
  
  private StringProperty firstnameProperty = new SimpleStringProperty();
  private StringProperty lastnameProperty = new SimpleStringProperty();
  private StringProperty usernameProperty = new SimpleStringProperty();
  private LongProperty contactImageIdProperty = new SimpleLongProperty();
  private ListProperty<de.dc.fx.ui.jregis.metro.ui.gen.contacts.email.model.Email> emailsProperty = new SimpleListProperty<>();
  private ListProperty<de.dc.fx.ui.jregis.metro.ui.gen.contacts.address.model.Address> addressListProperty = new SimpleListProperty<>();
  private ListProperty<de.dc.fx.ui.jregis.metro.ui.gen.contacts.phone.model.Phonenumber> phoneListProperty = new SimpleListProperty<>();
  private ListProperty<de.dc.fx.ui.jregis.metro.ui.gen.contacts.dates.model.Dates> dateListProperty = new SimpleListProperty<>();
  
  public ContactFX() {
    this(new Contact());
  }
  
  public ContactFX(Contact contact) {
    this.contact=contact;
    this.contactProperty.set(contact);
    
	this.contactProperty.addListener((observable, oldValue, newValue) -> {
		if (newValue!=null) {
			firstnameProperty.set(newValue.getFirstname());
			lastnameProperty.set(newValue.getLastname());
			usernameProperty.set(newValue.getUsername());
			contactImageIdProperty.set(newValue.getContactImageId());
			emailsProperty.set(FXCollections.observableArrayList(newValue.getEmails()));
			addressListProperty.set(FXCollections.observableArrayList(newValue.getAddressList()));
			phoneListProperty.set(FXCollections.observableArrayList(newValue.getPhoneList()));
			dateListProperty.set(FXCollections.observableArrayList(newValue.getDateList()));
		}
	});

    BooleanBinding isEnabled = firstnameProperty.isNotEmpty().and(lastnameProperty.isNotEmpty()).and(usernameProperty.isNotEmpty());
    this.enableSubmitProperty.bind(isEnabled);
  }

  public ObjectProperty<Contact> getContactProperty() {
    return contactProperty;
  }

  public BooleanProperty getEnabledSubmitProperty() {
    return enableSubmitProperty;
  }
  
  public void setMasterData(ObservableList<Contact> masterData) {
	  this.masterData = masterData;
  }
  
  public ObservableList<Contact> getMasterData(){
  	return masterData;
  }

  public FilteredList<Contact> getFilteredMasterData(){
  	return filteredMasterData;
  }
  
  public Contact getContact() {
  	this.contact = new Contact();
  	this.contact.setFirstname(firstnameProperty.getValue());
  	this.contact.setLastname(lastnameProperty.getValue());
  	this.contact.setUsername(usernameProperty.getValue());
  	this.contact.setContactImageId(contactImageIdProperty.getValue());
  	this.contact.setEmails(emailsProperty.getValue());
  	this.contact.setAddressList(addressListProperty.getValue());
  	this.contact.setPhoneList(phoneListProperty.getValue());
  	this.contact.setDateList(dateListProperty.getValue());
    return this.contact;
  }
  
  public LongProperty getIdProperty(){
  	return idProperty;
  }
  
  public void setIdProperty(LongProperty idProperty){
  	this.idProperty = idProperty;
  }
  
  public StringProperty getFirstnameProperty() {
    return this.firstnameProperty;
  }
  
  public void setFirstnameProperty(StringProperty firstnameProperty) {
    this.firstnameProperty = firstnameProperty;
  }
  public StringProperty getLastnameProperty() {
    return this.lastnameProperty;
  }
  
  public void setLastnameProperty(StringProperty lastnameProperty) {
    this.lastnameProperty = lastnameProperty;
  }
  public StringProperty getUsernameProperty() {
    return this.usernameProperty;
  }
  
  public void setUsernameProperty(StringProperty usernameProperty) {
    this.usernameProperty = usernameProperty;
  }
  public LongProperty getContactImageIdProperty() {
    return this.contactImageIdProperty;
  }
  
  public void setContactImageIdProperty(LongProperty contactImageIdProperty) {
    this.contactImageIdProperty = contactImageIdProperty;
  }
  public ListProperty<de.dc.fx.ui.jregis.metro.ui.gen.contacts.email.model.Email> getEmailsProperty() {
    return this.emailsProperty;
  }
  
  public void setEmailsProperty(ListProperty<de.dc.fx.ui.jregis.metro.ui.gen.contacts.email.model.Email> emailsProperty) {
    this.emailsProperty = emailsProperty;
  }
  public ListProperty<de.dc.fx.ui.jregis.metro.ui.gen.contacts.address.model.Address> getAddressListProperty() {
    return this.addressListProperty;
  }
  
  public void setAddressListProperty(ListProperty<de.dc.fx.ui.jregis.metro.ui.gen.contacts.address.model.Address> addressListProperty) {
    this.addressListProperty = addressListProperty;
  }
  public ListProperty<de.dc.fx.ui.jregis.metro.ui.gen.contacts.phone.model.Phonenumber> getPhoneListProperty() {
    return this.phoneListProperty;
  }
  
  public void setPhoneListProperty(ListProperty<de.dc.fx.ui.jregis.metro.ui.gen.contacts.phone.model.Phonenumber> phoneListProperty) {
    this.phoneListProperty = phoneListProperty;
  }
  public ListProperty<de.dc.fx.ui.jregis.metro.ui.gen.contacts.dates.model.Dates> getDateListProperty() {
    return this.dateListProperty;
  }
  
  public void setDateListProperty(ListProperty<de.dc.fx.ui.jregis.metro.ui.gen.contacts.dates.model.Dates> dateListProperty) {
    this.dateListProperty = dateListProperty;
  }

  public void clear() {
  	  this.firstnameProperty.set("");
  	  this.lastnameProperty.set("");
  	  this.usernameProperty.set("");
  	  this.contactImageIdProperty.set(0l);
  }

  public String toString() {
    return  org.apache.commons.lang.builder.ToStringBuilder.reflectionToString(getContact());
  }
}
