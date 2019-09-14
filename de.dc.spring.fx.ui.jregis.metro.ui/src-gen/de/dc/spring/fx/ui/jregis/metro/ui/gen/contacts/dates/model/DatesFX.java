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
public class DatesFX {
	
  private Dates dates;
  private ObjectProperty<Dates> datesProperty = new SimpleObjectProperty<>();
  private ObservableList<Dates> masterData = FXCollections.observableArrayList();
  private FilteredList<Dates> filteredMasterData = new FilteredList<>(masterData, p-> true);
  
  private LongProperty idProperty = new SimpleLongProperty();
  private BooleanProperty enableSubmitProperty = new SimpleBooleanProperty(false);
  
  private LongProperty contactIdProperty = new SimpleLongProperty();
  private StringProperty nameProperty = new SimpleStringProperty();
  private ObjectProperty<java.time.LocalDateTime> dateProperty = new SimpleObjectProperty<>();
  private IntegerProperty statusProperty = new SimpleIntegerProperty();
  private ObjectProperty<java.time.LocalDateTime> createdOnProperty = new SimpleObjectProperty<>();
  private ObjectProperty<java.time.LocalDateTime> updatedOnProperty = new SimpleObjectProperty<>();
  
  public DatesFX() {
    this(new Dates());
  }
  
  public DatesFX(Dates dates) {
    this.dates=dates;
    this.datesProperty.set(dates);
    
	this.datesProperty.addListener((observable, oldValue, newValue) -> {
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

  public ObjectProperty<Dates> getDatesProperty() {
    return datesProperty;
  }

  public BooleanProperty getEnabledSubmitProperty() {
    return enableSubmitProperty;
  }
  
  public ObservableList<Dates>  getMasterData(){
  	return masterData;
  }

  public FilteredList<Dates> getFilteredMasterData(){
  	return filteredMasterData;
  }
  
  public Dates getDates() {
  	this.dates = new Dates();
  	this.dates.setContactId(contactIdProperty.getValue());
  	this.dates.setName(nameProperty.getValue());
  	this.dates.setDate(dateProperty.getValue());
  	this.dates.setStatus(statusProperty.getValue());
  	this.dates.setCreatedOn(createdOnProperty.getValue());
  	this.dates.setUpdatedOn(updatedOnProperty.getValue());
    return this.dates;
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
    return  org.apache.commons.lang.builder.ToStringBuilder.reflectionToString(getDates());
  }
}
