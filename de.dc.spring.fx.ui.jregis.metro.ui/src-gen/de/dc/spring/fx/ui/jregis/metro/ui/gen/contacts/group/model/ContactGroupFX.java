package de.dc.spring.fx.ui.jregis.metro.ui.gen.contacts.group.model;

import de.dc.spring.fx.ui.jregis.metro.ui.gen.contacts.group.model.*;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import org.springframework.stereotype.Component;

import java.lang.String;
import java.lang.Integer;
import java.lang.String;
import java.lang.String;
import java.time.LocalDateTime;
import java.time.LocalDateTime;

@Component
public class ContactGroupFX {
	
  private ContactGroup contactGroup;
  private ObjectProperty<ContactGroup> contactGroupProperty = new SimpleObjectProperty<>();
  private ObservableList<ContactGroup> masterData = FXCollections.observableArrayList();
  private FilteredList<ContactGroup> filteredMasterData = new FilteredList<>(masterData, p-> true);
  
  private LongProperty idProperty = new SimpleLongProperty();
  private BooleanProperty enableSubmitProperty = new SimpleBooleanProperty(false);
  
  private StringProperty nameProperty = new SimpleStringProperty();
  private IntegerProperty statusProperty = new SimpleIntegerProperty();
  private StringProperty colorProperty = new SimpleStringProperty();
  private StringProperty hoverColorProperty = new SimpleStringProperty();
  private ObjectProperty<java.time.LocalDateTime> createdOnProperty = new SimpleObjectProperty<>();
  private ObjectProperty<java.time.LocalDateTime> updatedOnProperty = new SimpleObjectProperty<>();
  private ListProperty<de.dc.spring.fx.ui.jregis.metro.ui.gen.contacts.contact.model.Contact> contactListProperty = new SimpleListProperty<>();
  
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
			colorProperty.set(newValue.getColor());
			hoverColorProperty.set(newValue.getHoverColor());
			createdOnProperty.set(newValue.getCreatedOn());
			updatedOnProperty.set(newValue.getUpdatedOn());
			contactListProperty.set(FXCollections.observableArrayList(newValue.getContactList()));
		}
	});

    BooleanBinding isEnabled = nameProperty.isNotEmpty().and(colorProperty.isNotEmpty()).and(hoverColorProperty.isNotEmpty());
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
  	this.contactGroup.setColor(colorProperty.getValue());
  	this.contactGroup.setHoverColor(hoverColorProperty.getValue());
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
  public StringProperty getColorProperty() {
    return this.colorProperty;
  }
  
  public void setColorProperty(StringProperty colorProperty) {
    this.colorProperty = colorProperty;
  }
  public StringProperty getHoverColorProperty() {
    return this.hoverColorProperty;
  }
  
  public void setHoverColorProperty(StringProperty hoverColorProperty) {
    this.hoverColorProperty = hoverColorProperty;
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
  public ListProperty<de.dc.spring.fx.ui.jregis.metro.ui.gen.contacts.contact.model.Contact> getContactListProperty() {
    return this.contactListProperty;
  }
  
  public void setContactListProperty(ListProperty<de.dc.spring.fx.ui.jregis.metro.ui.gen.contacts.contact.model.Contact> contactListProperty) {
    this.contactListProperty = contactListProperty;
  }

  public void clear() {
  	  this.nameProperty.set("");
  	  this.statusProperty.set(0);
  	  this.colorProperty.set("");
  	  this.hoverColorProperty.set("");
  	  this.createdOnProperty.set(java.time.LocalDateTime.now());
  	  this.updatedOnProperty.set(java.time.LocalDateTime.now());
  }

  public String toString() {
    return  org.apache.commons.lang.builder.ToStringBuilder.reflectionToString(getContactGroup());
  }
}
