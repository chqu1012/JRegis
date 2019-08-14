package de.dc.fx.ui.jregis.metro.ui.gen.contacts.phone.model;

import de.dc.fx.ui.jregis.metro.ui.gen.contacts.phone.model.*;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;

import java.lang.Long;
import java.lang.String;
import java.lang.String;
import java.lang.String;
import java.lang.Integer;
import java.time.LocalDateTime;
import java.time.LocalDateTime;

public class PhonenumberFX {
	
  private Phonenumber phonenumber;
  private ObjectProperty<Phonenumber> phonenumberProperty = new SimpleObjectProperty<>();
  private ObservableList<Phonenumber> masterData = FXCollections.observableArrayList();
  private FilteredList<Phonenumber> filteredMasterData = new FilteredList<>(masterData, p-> true);
  
  private LongProperty idProperty = new SimpleLongProperty();
  private BooleanProperty enableSubmitProperty = new SimpleBooleanProperty(false);
  
  private LongProperty contactIdProperty = new SimpleLongProperty();
  private StringProperty nameProperty = new SimpleStringProperty();
  private StringProperty numberProperty = new SimpleStringProperty();
  private StringProperty numberTypeProperty = new SimpleStringProperty();
  private IntegerProperty statusProperty = new SimpleIntegerProperty();
  private ObjectProperty<java.time.LocalDateTime> createdOnProperty = new SimpleObjectProperty<>();
  private ObjectProperty<java.time.LocalDateTime> updatedOnProperty = new SimpleObjectProperty<>();
  
  public PhonenumberFX() {
    this(new Phonenumber());
  }
  
  public PhonenumberFX(Phonenumber phonenumber) {
    this.phonenumber=phonenumber;
    this.phonenumberProperty.set(phonenumber);
    
	this.phonenumberProperty.addListener((observable, oldValue, newValue) -> {
		if (newValue!=null) {
			contactIdProperty.set(newValue.getContactId());
			nameProperty.set(newValue.getName());
			numberProperty.set(newValue.getNumber());
			numberTypeProperty.set(newValue.getNumberType());
			statusProperty.set(newValue.getStatus());
			createdOnProperty.set(newValue.getCreatedOn());
			updatedOnProperty.set(newValue.getUpdatedOn());
		}
	});

    BooleanBinding isEnabled = nameProperty.isNotEmpty().and(numberProperty.isNotEmpty()).and(numberTypeProperty.isNotEmpty());
    this.enableSubmitProperty.bind(isEnabled);
  }

  public ObjectProperty<Phonenumber> getPhonenumberProperty() {
    return phonenumberProperty;
  }

  public BooleanProperty getEnabledSubmitProperty() {
    return enableSubmitProperty;
  }
  
  public ObservableList<Phonenumber>  getMasterData(){
  	return masterData;
  }

  public FilteredList<Phonenumber> getFilteredMasterData(){
  	return filteredMasterData;
  }
  
  public Phonenumber getPhonenumber() {
  	this.phonenumber = new Phonenumber();
  	this.phonenumber.setContactId(contactIdProperty.getValue());
  	this.phonenumber.setName(nameProperty.getValue());
  	this.phonenumber.setNumber(numberProperty.getValue());
  	this.phonenumber.setNumberType(numberTypeProperty.getValue());
  	this.phonenumber.setStatus(statusProperty.getValue());
  	this.phonenumber.setCreatedOn(createdOnProperty.getValue());
  	this.phonenumber.setUpdatedOn(updatedOnProperty.getValue());
    return this.phonenumber;
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
  public StringProperty getNameProperty() {
    return this.nameProperty;
  }
  
  public void setNameProperty(StringProperty nameProperty) {
    this.nameProperty = nameProperty;
  }
  public StringProperty getNumberProperty() {
    return this.numberProperty;
  }
  
  public void setNumberProperty(StringProperty numberProperty) {
    this.numberProperty = numberProperty;
  }
  public StringProperty getNumberTypeProperty() {
    return this.numberTypeProperty;
  }
  
  public void setNumberTypeProperty(StringProperty numberTypeProperty) {
    this.numberTypeProperty = numberTypeProperty;
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
  	  this.nameProperty.set("");
  	  this.numberProperty.set("");
  	  this.numberTypeProperty.set("");
  	  this.statusProperty.set(0);
  	  this.createdOnProperty.set(java.time.LocalDateTime.now());
  	  this.updatedOnProperty.set(java.time.LocalDateTime.now());
  }

  public String toString() {
    return  org.apache.commons.lang.builder.ToStringBuilder.reflectionToString(getPhonenumber());
  }
}
