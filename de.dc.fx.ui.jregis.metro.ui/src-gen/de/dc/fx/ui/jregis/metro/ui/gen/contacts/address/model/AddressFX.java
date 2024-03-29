package de.dc.fx.ui.jregis.metro.ui.gen.contacts.address.model;

import de.dc.fx.ui.jregis.metro.ui.gen.contacts.address.model.*;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;

import java.lang.Long;
import java.lang.String;
import java.lang.String;
import java.lang.String;
import java.lang.String;
import java.lang.Integer;
import java.lang.Integer;
import java.time.LocalDateTime;
import java.time.LocalDateTime;

public class AddressFX {
	
  private Address address;
  private ObjectProperty<Address> addressProperty = new SimpleObjectProperty<>();
  private ObservableList<Address> masterData = FXCollections.observableArrayList();
  private FilteredList<Address> filteredMasterData = new FilteredList<>(masterData, p-> true);
  
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
  
  public AddressFX() {
    this(new Address());
  }
  
  public AddressFX(Address address) {
    this.address=address;
    this.addressProperty.set(address);
    
	this.addressProperty.addListener((observable, oldValue, newValue) -> {
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

  public ObjectProperty<Address> getAddressProperty() {
    return addressProperty;
  }

  public BooleanProperty getEnabledSubmitProperty() {
    return enableSubmitProperty;
  }
  
  public ObservableList<Address>  getMasterData(){
  	return masterData;
  }

  public FilteredList<Address> getFilteredMasterData(){
  	return filteredMasterData;
  }
  
  public Address getAddress() {
  	this.address = new Address();
  	this.address.setContactId(contactIdProperty.getValue());
  	this.address.setAddressType(addressTypeProperty.getValue());
  	this.address.setStreet(streetProperty.getValue());
  	this.address.setCountry(countryProperty.getValue());
  	this.address.setState(stateProperty.getValue());
  	this.address.setZipCode(zipCodeProperty.getValue());
  	this.address.setStatus(statusProperty.getValue());
  	this.address.setCreatedOn(createdOnProperty.getValue());
  	this.address.setUpdatedOn(updatedOnProperty.getValue());
    return this.address;
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
    return  org.apache.commons.lang.builder.ToStringBuilder.reflectionToString(getAddress());
  }
}
