package de.dc.spring.fx.ui.jregis.metro.ui.gen.contacts.dates.model;

import de.dc.spring.fx.ui.jregis.metro.ui.gen.contacts.dates.model.*;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import org.springframework.stereotype.Component;

import java.lang.Long;
import java.lang.String;
import java.time.LocalDateTime;
import java.lang.Integer;
import java.time.LocalDateTime;
import java.time.LocalDateTime;

@Component
public class ContactDatesFX {
	
  private ContactDates contactDates;
  private ObjectProperty<ContactDates> contactDatesProperty = new SimpleObjectProperty<>();
  private ObservableList<ContactDates> masterData = FXCollections.observableArrayList();
  private FilteredList<ContactDates> filteredMasterData = new FilteredList<>(masterData, p-> true);
  
  private LongProperty idProperty = new SimpleLongProperty();
  private BooleanProperty enableSubmitProperty = new SimpleBooleanProperty(false);
  
  private LongProperty contactIdProperty = new SimpleLongProperty();
  private StringProperty nameProperty = new SimpleStringProperty();
  private ObjectProperty<java.time.LocalDateTime> dateProperty = new SimpleObjectProperty<>();
  private IntegerProperty statusProperty = new SimpleIntegerProperty();
  private ObjectProperty<java.time.LocalDateTime> createdOnProperty = new SimpleObjectProperty<>();
  private ObjectProperty<java.time.LocalDateTime> updatedOnProperty = new SimpleObjectProperty<>();
  
  public ContactDatesFX() {
    this(new ContactDates());
  }
  
  public ContactDatesFX(ContactDates contactDates) {
    this.contactDates=contactDates;
    this.contactDatesProperty.set(contactDates);
    
	this.contactDatesProperty.addListener((observable, oldValue, newValue) -> {
		if (newValue!=null) {
			contactIdProperty.set(newValue.getContactId());
			nameProperty.set(newValue.getName());
			dateProperty.set(newValue.getDate());
			statusProperty.set(newValue.getStatus());
			createdOnProperty.set(newValue.getCreatedOn());
			updatedOnProperty.set(newValue.getUpdatedOn());
		}
	});

    BooleanBinding isEnabled = nameProperty.isNotEmpty();
    this.enableSubmitProperty.bind(isEnabled);
  }

  public ObjectProperty<ContactDates> getContactDatesProperty() {
    return contactDatesProperty;
  }

  public BooleanProperty getEnabledSubmitProperty() {
    return enableSubmitProperty;
  }
  
  public ObservableList<ContactDates>  getMasterData(){
  	return masterData;
  }

  public FilteredList<ContactDates> getFilteredMasterData(){
  	return filteredMasterData;
  }
  
  public ContactDates getContactDates() {
  	this.contactDates = new ContactDates();
  	this.contactDates.setContactId(contactIdProperty.getValue());
  	this.contactDates.setName(nameProperty.getValue());
  	this.contactDates.setDate(dateProperty.getValue());
  	this.contactDates.setStatus(statusProperty.getValue());
  	this.contactDates.setCreatedOn(createdOnProperty.getValue());
  	this.contactDates.setUpdatedOn(updatedOnProperty.getValue());
    return this.contactDates;
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
  public ObjectProperty<java.time.LocalDateTime> getDateProperty() {
    return this.dateProperty;
  }
  
  public void setDateProperty(ObjectProperty<java.time.LocalDateTime> dateProperty) {
    this.dateProperty = dateProperty;
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
  	  this.dateProperty.set(java.time.LocalDateTime.now());
  	  this.statusProperty.set(0);
  	  this.createdOnProperty.set(java.time.LocalDateTime.now());
  	  this.updatedOnProperty.set(java.time.LocalDateTime.now());
  }

  public String toString() {
    return  org.apache.commons.lang.builder.ToStringBuilder.reflectionToString(getContactDates());
  }
}
