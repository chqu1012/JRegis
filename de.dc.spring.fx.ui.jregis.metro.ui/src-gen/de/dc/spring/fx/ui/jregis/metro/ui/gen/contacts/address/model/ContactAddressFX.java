package de.dc.spring.fx.ui.jregis.metro.ui.gen.contacts.address.model;

import de.dc.spring.fx.ui.jregis.metro.ui.gen.contacts.address.model.*;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import org.springframework.stereotype.Component;

import java.lang.Long;
import java.lang.String;
import java.lang.String;
import java.lang.String;
import java.lang.String;
import java.lang.Integer;
import java.lang.Integer;
import java.time.LocalDateTime;
import java.time.LocalDateTime;

@Component
public class ContactAddressFX {
	
  private ContactAddress contactAddress;
  private ObjectProperty<ContactAddress> contactAddressProperty = new SimpleObjectProperty<>();
  private ObservableList<ContactAddress> masterData = FXCollections.observableArrayList();
  private FilteredList<ContactAddress> filteredMasterData = new FilteredList<>(masterData, p-> true);
  
  private LongProperty idProperty = new SimpleLongProperty();
  private BooleanProperty enableSubmitProperty = new SimpleBooleanProperty(false);
  
  private LongProperty contactIdProperty = new SimpleLongProperty();
  private StringProperty addressTypeProperty = new SimpleStringProperty();
  private StringProperty streetProperty = new SimpleStringProperty();
  private StringProperty countryProperty = new SimpleStringProperty();
  private StringProperty stateProperty = new SimpleStringProperty();
  private IntegerProperty zipCodeProperty = new SimpleIntegerProperty();
  private IntegerProperty statusProperty = new SimpleIntegerProperty();
  private ObjectProperty<java.time.LocalDateTime> createdOnProperty = new SimpleObjectProperty<>();
  private ObjectProperty<java.time.LocalDateTime> updatedOnProperty = new SimpleObjectProperty<>();
  
  public ContactAddressFX() {
    this(new ContactAddress());
  }
  
  public ContactAddressFX(ContactAddress contactAddress) {
    this.contactAddress=contactAddress;
    this.contactAddressProperty.set(contactAddress);
    
	this.contactAddressProperty.addListener((observable, oldValue, newValue) -> {
		if (newValue!=null) {
			contactIdProperty.set(newValue.getContactId());
			addressTypeProperty.set(newValue.getAddressType());
			streetProperty.set(newValue.getStreet());
			countryProperty.set(newValue.getCountry());
			stateProperty.set(newValue.getState());
			zipCodeProperty.set(newValue.getZipCode());
			statusProperty.set(newValue.getStatus());
			createdOnProperty.set(newValue.getCreatedOn());
			updatedOnProperty.set(newValue.getUpdatedOn());
		}
	});

    BooleanBinding isEnabled = addressTypeProperty.isNotEmpty().and(streetProperty.isNotEmpty()).and(countryProperty.isNotEmpty()).and(stateProperty.isNotEmpty());
    this.enableSubmitProperty.bind(isEnabled);
  }

  public ObjectProperty<ContactAddress> getContactAddressProperty() {
    return contactAddressProperty;
  }

  public BooleanProperty getEnabledSubmitProperty() {
    return enableSubmitProperty;
  }
  
  public ObservableList<ContactAddress>  getMasterData(){
  	return masterData;
  }

  public FilteredList<ContactAddress> getFilteredMasterData(){
  	return filteredMasterData;
  }
  
  public ContactAddress getContactAddress() {
  	this.contactAddress = new ContactAddress();
  	this.contactAddress.setContactId(contactIdProperty.getValue());
  	this.contactAddress.setAddressType(addressTypeProperty.getValue());
  	this.contactAddress.setStreet(streetProperty.getValue());
  	this.contactAddress.setCountry(countryProperty.getValue());
  	this.contactAddress.setState(stateProperty.getValue());
  	this.contactAddress.setZipCode(zipCodeProperty.getValue());
  	this.contactAddress.setStatus(statusProperty.getValue());
  	this.contactAddress.setCreatedOn(createdOnProperty.getValue());
  	this.contactAddress.setUpdatedOn(updatedOnProperty.getValue());
    return this.contactAddress;
  }
  
  public LongProperty getIdProperty(){
  	return idProperty;
  }
  
  public void setIdProperty(LongProperty idProperty){
  	this.idProperty = idProperty;
  }
  
  public LongProperty getContactIdProperty() {
    return this.contactIdProperty;
  }
  
  public void setContactIdProperty(LongProperty contactIdProperty) {
    this.contactIdProperty = contactIdProperty;
  }
  public StringProperty getAddressTypeProperty() {
    return this.addressTypeProperty;
  }
  
  public void setAddressTypeProperty(StringProperty addressTypeProperty) {
    this.addressTypeProperty = addressTypeProperty;
  }
  public StringProperty getStreetProperty() {
    return this.streetProperty;
  }
  
  public void setStreetProperty(StringProperty streetProperty) {
    this.streetProperty = streetProperty;
  }
  public StringProperty getCountryProperty() {
    return this.countryProperty;
  }
  
  public void setCountryProperty(StringProperty countryProperty) {
    this.countryProperty = countryProperty;
  }
  public StringProperty getStateProperty() {
    return this.stateProperty;
  }
  
  public void setStateProperty(StringProperty stateProperty) {
    this.stateProperty = stateProperty;
  }
  public IntegerProperty getZipCodeProperty() {
    return this.zipCodeProperty;
  }
  
  public void setZipCodeProperty(IntegerProperty zipCodeProperty) {
    this.zipCodeProperty = zipCodeProperty;
  }
  public IntegerProperty getStatusProperty() {
    return this.statusProperty;
  }
  
  public void setStatusProperty(IntegerProperty statusProperty) {
    this.statusProperty = statusProperty;
  }
  public ObjectProperty<java.time.LocalDateTime> getCreatedOnProperty() {
    return this.createdOnProperty;
  }
  
  public void setCreatedOnProperty(ObjectProperty<java.time.LocalDateTime> createdOnProperty) {
    this.createdOnProperty = createdOnProperty;
  }
  public ObjectProperty<java.time.LocalDateTime> getUpdatedOnProperty() {
    return this.updatedOnProperty;
  }
  
  public void setUpdatedOnProperty(ObjectProperty<java.time.LocalDateTime> updatedOnProperty) {
    this.updatedOnProperty = updatedOnProperty;
  }

  public void clear() {
  	  this.contactIdProperty.set(0l);
  	  this.addressTypeProperty.set("");
  	  this.streetProperty.set("");
  	  this.countryProperty.set("");
  	  this.stateProperty.set("");
  	  this.zipCodeProperty.set(0);
  	  this.statusProperty.set(0);
  	  this.createdOnProperty.set(java.time.LocalDateTime.now());
  	  this.updatedOnProperty.set(java.time.LocalDateTime.now());
  }

  public String toString() {
    return  org.apache.commons.lang.builder.ToStringBuilder.reflectionToString(getContactAddress());
  }
}
