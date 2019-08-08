package de.dc.fx.ui.jregis.metro.ui.gen.contacts.dates.model;

import de.dc.fx.ui.jregis.metro.ui.gen.contacts.dates.model.*;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.beans.binding.BooleanBinding;

import java.lang.Long;
import java.lang.String;
import java.time.LocalDateTime;

public class DatesFX {
	
  private Dates dates;

  private ObservableList<Dates> masterData = FXCollections.observableArrayList();
  private FilteredList<Dates> filteredMasterData = new FilteredList<>(masterData, p-> true);
  
  private LongProperty idProperty = new SimpleLongProperty();
  private BooleanProperty enableSubmitProperty = new SimpleBooleanProperty(false);
  
  private LongProperty contactIdProperty = new SimpleLongProperty();
  private StringProperty nameProperty = new SimpleStringProperty();
  private ObjectProperty<java.time.LocalDateTime> dateProperty = new SimpleObjectProperty<>();
  
  public DatesFX() {
    this(new Dates());
  }
  
  public DatesFX(Dates dates) {
    this.dates=dates;
    BooleanBinding isEnabled = nameProperty.isNotEmpty();
    this.enableSubmitProperty.bind(isEnabled);
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

  public void clear() {
  	  this.contactIdProperty.set(0l);
  	  this.nameProperty.set("");
  	  this.dateProperty.set(java.time.LocalDateTime.now());
  }

  public String toString() {
    return  org.apache.commons.lang.builder.ToStringBuilder.reflectionToString(getDates());
  }
}
