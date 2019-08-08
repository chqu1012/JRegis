package de.dc.fx.ui.jregis.metro.ui.gen.contacts.contact.model;

import de.dc.fx.ui.jregis.metro.ui.gen.contacts.contact.model.*;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.beans.binding.BooleanBinding;

import java.lang.String;
import java.lang.String;
import java.lang.String;
import java.lang.Long;

public class ContactFX {
	
  private Contact contact;

  private ObservableList<Contact> masterData = FXCollections.observableArrayList();
  private FilteredList<Contact> filteredMasterData = new FilteredList<>(masterData, p-> true);
  
  private LongProperty idProperty = new SimpleLongProperty();
  private BooleanProperty enableSubmitProperty = new SimpleBooleanProperty(false);
  
  private StringProperty firstnameProperty = new SimpleStringProperty();
  private StringProperty lastnameProperty = new SimpleStringProperty();
  private StringProperty usernameProperty = new SimpleStringProperty();
  private LongProperty contactImageIdProperty = new SimpleLongProperty();
  
  public ContactFX() {
    this(new Contact());
  }
  
  public ContactFX(Contact contact) {
    this.contact=contact;
    BooleanBinding isEnabled = firstnameProperty.isNotEmpty().and(lastnameProperty.isNotEmpty()).and(usernameProperty.isNotEmpty());
    this.enableSubmitProperty.bind(isEnabled);
  }

  public BooleanProperty getEnabledSubmitProperty() {
    return enableSubmitProperty;
  }
  
  public ObservableList<Contact>  getMasterData(){
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
