package de.dc.fx.ui.jregis.metro.ui.gen.contacts.group.model;

import de.dc.fx.ui.jregis.metro.ui.gen.contacts.group.model.*;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;

import java.lang.String;
import java.lang.Integer;
import java.time.LocalDateTime;
import java.time.LocalDateTime;

public class ContactGroupFX {
	
  private ContactGroup contactGroup;
  private ObjectProperty<ContactGroup> contactGroupProperty = new SimpleObjectProperty<>();
  private ObservableList<ContactGroup> masterData = FXCollections.observableArrayList();
  private FilteredList<ContactGroup> filteredMasterData = new FilteredList<>(masterData, p-> true);
  
  private LongProperty idProperty = new SimpleLongProperty();
  private BooleanProperty enableSubmitProperty = new SimpleBooleanProperty(false);
  
  private StringProperty nameProperty = new SimpleStringProperty();
  private IntegerProperty statusProperty = new SimpleIntegerProperty();
  private ObjectProperty<java.time.LocalDateTime> createdOnProperty = new SimpleObjectProperty<>();
  private ObjectProperty<java.time.LocalDateTime> updatedOnProperty = new SimpleObjectProperty<>();
  private ListProperty<de.dc.fx.ui.jregis.metro.ui.gen.contacts.contact.model.Contact> contactListProperty = new SimpleListProperty<>();
  
  public ContactGroupFX() {
    this(new ContactGroup());
  }
  
  public ContactGroupFX(ContactGroup contactGroup) {
    this.contactGroup=contactGroup;
    this.contactGroupProperty.set(contactGroup);
    
	this.contactGroupProperty.addListener((observable, oldValue, newValue) -> {
		if (newValue!=null) {
			nameProperty.set(newValue.getName());
			statusProperty.set(newValue.getStatus());
			createdOnProperty.set(newValue.getCreatedOn());
			updatedOnProperty.set(newValue.getUpdatedOn());
			contactListProperty.set(FXCollections.observableArrayList(newValue.getContactList()));
		}
	});

    BooleanBinding isEnabled = nameProperty.isNotEmpty();
    this.enableSubmitProperty.bind(isEnabled);
  }

  public ObjectProperty<ContactGroup> getContactGroupProperty() {
    return contactGroupProperty;
  }

  public BooleanProperty getEnabledSubmitProperty() {
    return enableSubmitProperty;
  }
  
  public ObservableList<ContactGroup>  getMasterData(){
  	return masterData;
  }

  public FilteredList<ContactGroup> getFilteredMasterData(){
  	return filteredMasterData;
  }
  
  public ContactGroup getContactGroup() {
  	this.contactGroup = new ContactGroup();
  	this.contactGroup.setName(nameProperty.getValue());
  	this.contactGroup.setStatus(statusProperty.getValue());
  	this.contactGroup.setCreatedOn(createdOnProperty.getValue());
  	this.contactGroup.setUpdatedOn(updatedOnProperty.getValue());
  	this.contactGroup.setContactList(contactListProperty.getValue());
    return this.contactGroup;
  }
  
  public LongProperty getIdProperty(){
  	return idProperty;
  }
  
  public void setIdProperty(LongProperty idProperty){
  	this.idProperty = idProperty;
  }
  
  public StringProperty getNameProperty() {
    return this.nameProperty;
  }
  
  public void setNameProperty(StringProperty nameProperty) {
    this.nameProperty = nameProperty;
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
  public ListProperty<de.dc.fx.ui.jregis.metro.ui.gen.contacts.contact.model.Contact> getContactListProperty() {
    return this.contactListProperty;
  }
  
  public void setContactListProperty(ListProperty<de.dc.fx.ui.jregis.metro.ui.gen.contacts.contact.model.Contact> contactListProperty) {
    this.contactListProperty = contactListProperty;
  }

  public void clear() {
  	  this.nameProperty.set("");
  	  this.statusProperty.set(0);
  	  this.createdOnProperty.set(java.time.LocalDateTime.now());
  	  this.updatedOnProperty.set(java.time.LocalDateTime.now());
  }

  public String toString() {
    return  org.apache.commons.lang.builder.ToStringBuilder.reflectionToString(getContactGroup());
  }
}
