package de.dc.fx.ui.jregis.metro.ui.gen.contacts.address.model;

import de.dc.fx.ui.jregis.metro.ui.gen.contacts.address.model.*;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.beans.binding.BooleanBinding;

import java.lang.Long;
import java.lang.String;
import java.lang.String;
import java.lang.String;
import java.lang.Integer;

public class AddressFX {
	
  private Address address;

  private ObservableList<Address> masterData = FXCollections.observableArrayList();
  private FilteredList<Address> filteredMasterData = new FilteredList<>(masterData, p-> true);
  
  private LongProperty idProperty = new SimpleLongProperty();
  private BooleanProperty enableSubmitProperty = new SimpleBooleanProperty(false);
  
  private LongProperty contactIdProperty = new SimpleLongProperty();
  private StringProperty streetProperty = new SimpleStringProperty();
  private StringProperty countryProperty = new SimpleStringProperty();
  private StringProperty stateProperty = new SimpleStringProperty();
  private IntegerProperty zipCodeProperty = new SimpleIntegerProperty();
  
  public AddressFX() {
    this(new Address());
  }
  
  public AddressFX(Address address) {
    this.address=address;
    BooleanBinding isEnabled = streetProperty.isNotEmpty().and(countryProperty.isNotEmpty()).and(stateProperty.isNotEmpty());
    this.enableSubmitProperty.bind(isEnabled);
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
  	this.address.setStreet(streetProperty.getValue());
  	this.address.setCountry(countryProperty.getValue());
  	this.address.setState(stateProperty.getValue());
  	this.address.setZipCode(zipCodeProperty.getValue());
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

  public void clear() {
  	  this.contactIdProperty.set(0l);
  	  this.streetProperty.set("");
  	  this.countryProperty.set("");
  	  this.stateProperty.set("");
  	  this.zipCodeProperty.set(0);
  }

  public String toString() {
    return  org.apache.commons.lang.builder.ToStringBuilder.reflectionToString(getAddress());
  }
}
