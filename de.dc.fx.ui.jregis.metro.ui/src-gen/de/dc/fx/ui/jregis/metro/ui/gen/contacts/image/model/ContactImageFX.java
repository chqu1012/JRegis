package de.dc.fx.ui.jregis.metro.ui.gen.contacts.image.model;

import de.dc.fx.ui.jregis.metro.ui.gen.contacts.image.model.*;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;

import java.lang.String;
import java.time.LocalDateTime;

public class ContactImageFX {
	
  private ContactImage contactImage;
  private ObjectProperty<ContactImage> contactImageProperty = new SimpleObjectProperty<>();
  private ObservableList<ContactImage> masterData = FXCollections.observableArrayList();
  private FilteredList<ContactImage> filteredMasterData = new FilteredList<>(masterData, p-> true);
  
  private LongProperty idProperty = new SimpleLongProperty();
  private BooleanProperty enableSubmitProperty = new SimpleBooleanProperty(false);
  
  private StringProperty nameProperty = new SimpleStringProperty();
  private ObjectProperty<java.time.LocalDateTime> createdOnProperty = new SimpleObjectProperty<>();
  
  public ContactImageFX() {
    this(new ContactImage());
  }
  
  public ContactImageFX(ContactImage contactImage) {
    this.contactImage=contactImage;
    this.contactImageProperty.set(contactImage);
    
	this.contactImageProperty.addListener((observable, oldValue, newValue) -> {
		if (newValue!=null) {
			nameProperty.set(newValue.getName());
			createdOnProperty.set(newValue.getCreatedOn());
		}
	});

    BooleanBinding isEnabled = nameProperty.isNotEmpty();
    this.enableSubmitProperty.bind(isEnabled);
  }

  public ObjectProperty<ContactImage> getContactImageProperty() {
    return contactImageProperty;
  }

  public BooleanProperty getEnabledSubmitProperty() {
    return enableSubmitProperty;
  }
  
  public ObservableList<ContactImage>  getMasterData(){
  	return masterData;
  }

  public FilteredList<ContactImage> getFilteredMasterData(){
  	return filteredMasterData;
  }
  
  public ContactImage getContactImage() {
  	this.contactImage = new ContactImage();
  	this.contactImage.setName(nameProperty.getValue());
  	this.contactImage.setCreatedOn(createdOnProperty.getValue());
    return this.contactImage;
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
  public ObjectProperty<java.time.LocalDateTime> getCreatedOnProperty() {
    return this.createdOnProperty;
  }
  
  public void setCreatedOnProperty(ObjectProperty<java.time.LocalDateTime> createdOnProperty) {
    this.createdOnProperty = createdOnProperty;
  }

  public void clear() {
  	  this.nameProperty.set("");
  	  this.createdOnProperty.set(java.time.LocalDateTime.now());
  }

  public String toString() {
    return  org.apache.commons.lang.builder.ToStringBuilder.reflectionToString(getContactImage());
  }
}
