package de.dc.spring.fx.ui.jregis.metro.ui.gen.contacts.email.model;

import de.dc.spring.fx.ui.jregis.metro.ui.gen.contacts.email.model.*;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import org.springframework.stereotype.Component;

import java.lang.Long;
import java.lang.String;
import java.lang.String;
import java.lang.Integer;
import java.time.LocalDateTime;
import java.time.LocalDateTime;

@Component
public class ContactEmailFX {
	
  private ContactEmail contactEmail;
  private ObjectProperty<ContactEmail> contactEmailProperty = new SimpleObjectProperty<>();
  private ObservableList<ContactEmail> masterData = FXCollections.observableArrayList();
  private FilteredList<ContactEmail> filteredMasterData = new FilteredList<>(masterData, p-> true);
  
  private LongProperty idProperty = new SimpleLongProperty();
  private BooleanProperty enableSubmitProperty = new SimpleBooleanProperty(false);
  
  private LongProperty contactIdProperty = new SimpleLongProperty();
  private StringProperty nameProperty = new SimpleStringProperty();
  private StringProperty addressProperty = new SimpleStringProperty();
  private IntegerProperty statusProperty = new SimpleIntegerProperty();
  private ObjectProperty<java.time.LocalDateTime> createdOnProperty = new SimpleObjectProperty<>();
  private ObjectProperty<java.time.LocalDateTime> updatedOnProperty = new SimpleObjectProperty<>();
  
  public ContactEmailFX() {
    this(new ContactEmail());
  }
  
  public ContactEmailFX(ContactEmail contactEmail) {
    this.contactEmail=contactEmail;
    this.contactEmailProperty.set(contactEmail);
    
	this.contactEmailProperty.addListener((observable, oldValue, newValue) -> {
		if (newValue!=null) {
			contactIdProperty.set(newValue.getContactId());
			nameProperty.set(newValue.getName());
			addressProperty.set(newValue.getAddress());
			statusProperty.set(newValue.getStatus());
			createdOnProperty.set(newValue.getCreatedOn());
			updatedOnProperty.set(newValue.getUpdatedOn());
		}
	});

    BooleanBinding isEnabled = nameProperty.isNotEmpty().and(addressProperty.isNotEmpty());
    this.enableSubmitProperty.bind(isEnabled);
  }

  public ObjectProperty<ContactEmail> getContactEmailProperty() {
    return contactEmailProperty;
  }

  public BooleanProperty getEnabledSubmitProperty() {
    return enableSubmitProperty;
  }
  
  public ObservableList<ContactEmail>  getMasterData(){
  	return masterData;
  }

  public FilteredList<ContactEmail> getFilteredMasterData(){
  	return filteredMasterData;
  }
  
  public ContactEmail getContactEmail() {
  	this.contactEmail = new ContactEmail();
  	this.contactEmail.setContactId(contactIdProperty.getValue());
  	this.contactEmail.setName(nameProperty.getValue());
  	this.contactEmail.setAddress(addressProperty.getValue());
  	this.contactEmail.setStatus(statusProperty.getValue());
  	this.contactEmail.setCreatedOn(createdOnProperty.getValue());
  	this.contactEmail.setUpdatedOn(updatedOnProperty.getValue());
    return this.contactEmail;
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
  public StringProperty getAddressProperty() {
    return this.addressProperty;
  }
  
  public void setAddressProperty(StringProperty addressProperty) {
    this.addressProperty = addressProperty;
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
  	  this.addressProperty.set("");
  	  this.statusProperty.set(0);
  	  this.createdOnProperty.set(java.time.LocalDateTime.now());
  	  this.updatedOnProperty.set(java.time.LocalDateTime.now());
  }

  public String toString() {
    return  org.apache.commons.lang.builder.ToStringBuilder.reflectionToString(getContactEmail());
  }
}
