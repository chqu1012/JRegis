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
  private StringProperty accountProperty = new SimpleStringProperty();
  private LongProperty avatarIdProperty = new SimpleLongProperty();
  
  public ContactFX() {
    this(new Contact());
  }
  
  public ContactFX(Contact contact) {
    this.contact=contact;
    BooleanBinding isEnabled = firstnameProperty.isNotEmpty().and(lastnameProperty.isNotEmpty()).and(accountProperty.isNotEmpty());
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
  	this.contact.setAccount(accountProperty.getValue());
  	this.contact.setAvatarId(avatarIdProperty.getValue());
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
  public StringProperty getAccountProperty() {
    return this.accountProperty;
  }
  
  public void setAccountProperty(StringProperty accountProperty) {
    this.accountProperty = accountProperty;
  }
  public LongProperty getAvatarIdProperty() {
    return this.avatarIdProperty;
  }
  
  public void setAvatarIdProperty(LongProperty avatarIdProperty) {
    this.avatarIdProperty = avatarIdProperty;
  }

  public void clear() {
  	  this.firstnameProperty.set("");
  	  this.lastnameProperty.set("");
  	  this.accountProperty.set("");
  	  this.avatarIdProperty.set(0l);
  }

  public String toString() {
    return  org.apache.commons.lang.builder.ToStringBuilder.reflectionToString(getContact());
  }
}
