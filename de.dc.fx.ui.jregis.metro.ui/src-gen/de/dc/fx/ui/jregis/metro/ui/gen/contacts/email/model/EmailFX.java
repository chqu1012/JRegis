package de.dc.fx.ui.jregis.metro.ui.gen.contacts.email.model;

import de.dc.fx.ui.jregis.metro.ui.gen.contacts.email.model.*;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.beans.binding.BooleanBinding;

import java.lang.Long;
import java.lang.String;
import java.lang.String;

public class EmailFX {
	
  private Email email;

  private ObservableList<Email> masterData = FXCollections.observableArrayList();
  private FilteredList<Email> filteredMasterData = new FilteredList<>(masterData, p-> true);
  
  private LongProperty idProperty = new SimpleLongProperty();
  private BooleanProperty enableSubmitProperty = new SimpleBooleanProperty(false);
  
  private LongProperty contactIdProperty = new SimpleLongProperty();
  private StringProperty nameProperty = new SimpleStringProperty();
  private StringProperty emailProperty = new SimpleStringProperty();
  
  public EmailFX() {
    this(new Email());
  }
  
  public EmailFX(Email email) {
    this.email=email;
    BooleanBinding isEnabled = nameProperty.isNotEmpty().and(emailProperty.isNotEmpty());
    this.enableSubmitProperty.bind(isEnabled);
  }

  public BooleanProperty getEnabledSubmitProperty() {
    return enableSubmitProperty;
  }
  
  public ObservableList<Email>  getMasterData(){
  	return masterData;
  }

  public FilteredList<Email> getFilteredMasterData(){
  	return filteredMasterData;
  }
  
  public Email getEmail() {
  	this.email = new Email();
  	this.email.setContactId(contactIdProperty.getValue());
  	this.email.setName(nameProperty.getValue());
  	this.email.setEmail(emailProperty.getValue());
    return this.email;
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
  public StringProperty getEmailProperty() {
    return this.emailProperty;
  }
  
  public void setEmailProperty(StringProperty emailProperty) {
    this.emailProperty = emailProperty;
  }

  public void clear() {
  	  this.contactIdProperty.set(0l);
  	  this.nameProperty.set("");
  	  this.emailProperty.set("");
  }

  public String toString() {
    return  org.apache.commons.lang.builder.ToStringBuilder.reflectionToString(getEmail());
  }
}
