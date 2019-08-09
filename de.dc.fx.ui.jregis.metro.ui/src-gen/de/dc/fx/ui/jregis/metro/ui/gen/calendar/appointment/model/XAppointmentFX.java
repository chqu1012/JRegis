package de.dc.fx.ui.jregis.metro.ui.gen.calendar.appointment.model;

import de.dc.fx.ui.jregis.metro.ui.gen.calendar.appointment.model.*;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;

import java.lang.Long;
import java.lang.String;
import java.lang.String;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.lang.Long;

public class XAppointmentFX {
	
  private XAppointment xAppointment;
  private ObjectProperty<XAppointment> xAppointmentProperty = new SimpleObjectProperty<>();
  private ObservableList<XAppointment> masterData = FXCollections.observableArrayList();
  private FilteredList<XAppointment> filteredMasterData = new FilteredList<>(masterData, p-> true);
  
  private LongProperty idProperty = new SimpleLongProperty();
  private BooleanProperty enableSubmitProperty = new SimpleBooleanProperty(false);
  
  private LongProperty contactIdProperty = new SimpleLongProperty();
  private StringProperty topicProperty = new SimpleStringProperty();
  private StringProperty summaryProperty = new SimpleStringProperty();
  private ObjectProperty<java.time.LocalDateTime> startProperty = new SimpleObjectProperty<>();
  private ObjectProperty<java.time.LocalDateTime> endProperty = new SimpleObjectProperty<>();
  private LongProperty appointmentGroupIdProperty = new SimpleLongProperty();
  
  public XAppointmentFX() {
    this(new XAppointment());
  }
  
  public XAppointmentFX(XAppointment xAppointment) {
    this.xAppointment=xAppointment;
    this.xAppointmentProperty.set(xAppointment);
    
	this.xAppointmentProperty.addListener((observable, oldValue, newValue) -> {
		if (newValue!=null) {
			contactIdProperty.set(newValue.getContactId());
			topicProperty.set(newValue.getTopic());
			summaryProperty.set(newValue.getSummary());
			startProperty.set(newValue.getStart());
			endProperty.set(newValue.getEnd());
			appointmentGroupIdProperty.set(newValue.getAppointmentGroupId());
		}
	});

    BooleanBinding isEnabled = topicProperty.isNotEmpty().and(summaryProperty.isNotEmpty());
    this.enableSubmitProperty.bind(isEnabled);
  }

  public ObjectProperty<XAppointment> getXAppointmentProperty() {
    return xAppointmentProperty;
  }

  public BooleanProperty getEnabledSubmitProperty() {
    return enableSubmitProperty;
  }
  
  public ObservableList<XAppointment>  getMasterData(){
  	return masterData;
  }

  public FilteredList<XAppointment> getFilteredMasterData(){
  	return filteredMasterData;
  }
  
  public XAppointment getXAppointment() {
  	this.xAppointment = new XAppointment();
  	this.xAppointment.setContactId(contactIdProperty.getValue());
  	this.xAppointment.setTopic(topicProperty.getValue());
  	this.xAppointment.setSummary(summaryProperty.getValue());
  	this.xAppointment.setStart(startProperty.getValue());
  	this.xAppointment.setEnd(endProperty.getValue());
  	this.xAppointment.setAppointmentGroupId(appointmentGroupIdProperty.getValue());
    return this.xAppointment;
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
  public StringProperty getTopicProperty() {
    return this.topicProperty;
  }
  
  public void setTopicProperty(StringProperty topicProperty) {
    this.topicProperty = topicProperty;
  }
  public StringProperty getSummaryProperty() {
    return this.summaryProperty;
  }
  
  public void setSummaryProperty(StringProperty summaryProperty) {
    this.summaryProperty = summaryProperty;
  }
  public ObjectProperty<java.time.LocalDateTime> getStartProperty() {
    return this.startProperty;
  }
  
  public void setStartProperty(ObjectProperty<java.time.LocalDateTime> startProperty) {
    this.startProperty = startProperty;
  }
  public ObjectProperty<java.time.LocalDateTime> getEndProperty() {
    return this.endProperty;
  }
  
  public void setEndProperty(ObjectProperty<java.time.LocalDateTime> endProperty) {
    this.endProperty = endProperty;
  }
  public LongProperty getAppointmentGroupIdProperty() {
    return this.appointmentGroupIdProperty;
  }
  
  public void setAppointmentGroupIdProperty(LongProperty appointmentGroupIdProperty) {
    this.appointmentGroupIdProperty = appointmentGroupIdProperty;
  }

  public void clear() {
  	  this.contactIdProperty.set(0l);
  	  this.topicProperty.set("");
  	  this.summaryProperty.set("");
  	  this.startProperty.set(java.time.LocalDateTime.now());
  	  this.endProperty.set(java.time.LocalDateTime.now());
  	  this.appointmentGroupIdProperty.set(0l);
  }

  public String toString() {
    return  org.apache.commons.lang.builder.ToStringBuilder.reflectionToString(getXAppointment());
  }
}
