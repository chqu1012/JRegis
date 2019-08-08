package de.dc.fx.ui.jregis.metro.ui.gen.contacts.email.model;

import de.dc.fx.ui.jregis.metro.ui.gen.contacts.email.model.*;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;

import java.lang.Long;
import java.lang.String;
import java.lang.String;

public class EmailFX {
	
  private Email email;
  private ObjectProperty<Email> emailProperty = new SimpleObjectProperty<>();
  private ObservableList<Email> masterData = FXCollections.observableArrayList();
  private FilteredList<Email> filteredMasterData = new FilteredList<>(masterData, p-> true);
  
  private LongProperty idProperty = new SimpleLongProperty();
  private BooleanProperty enableSubmitProperty = new SimpleBooleanProperty(false);
  
  private LongProperty contactIdProperty = new SimpleLongProperty();
  private StringProperty nameProperty = new SimpleStringProperty();
  private StringProperty addressProperty = new SimpleStringProperty();
  
  public EmailFX() {
    this(new Email());
  }
  
  public EmailFX(Email email) {
    this.email=email;
    this.emailProperty.set(email);
    
	this.emailProperty.addListener((observable, oldValue, newValue) -> {
		if (newValue!=null) {
			contactIdProperty.set(newValue.getContactId());
			nameProperty.set(newValue.getName());
			addressProperty.set(newValue.getAddress());
		}
	});

    BooleanBinding isEnabled = nameProperty.isNotEmpty().and(addressProperty.isNotEmpty());
    this.enableSubmitProperty.bind(isEnabled);
  }

  public ObjectProperty<Email> getEmailProperty() {
    return emailProperty;
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
  	this.email.setAddress(addressProperty.getValue());
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
  public StringProperty getAddressProperty() {
    return this.addressProperty;
  }
  
  public void setAddressProperty(StringProperty addressProperty) {
    this.addressProperty = addressProperty;
  }

  public void clear() {
  	  this.contactIdProperty.set(0l);
  	  this.nameProperty.set("");
  	  this.addressProperty.set("");
  }

  public String toString() {
    return  org.apache.commons.lang.builder.ToStringBuilder.reflectionToString(getEmail());
  }
}
