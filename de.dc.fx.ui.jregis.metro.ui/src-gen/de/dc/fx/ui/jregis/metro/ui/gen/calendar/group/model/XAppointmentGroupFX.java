package de.dc.fx.ui.jregis.metro.ui.gen.calendar.group.model;

import de.dc.fx.ui.jregis.metro.ui.gen.calendar.group.model.*;
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
import java.lang.Integer;

public class XAppointmentGroupFX {
	
  private XAppointmentGroup xAppointmentGroup;
  private ObjectProperty<XAppointmentGroup> xAppointmentGroupProperty = new SimpleObjectProperty<>();
  private ObservableList<XAppointmentGroup> masterData = FXCollections.observableArrayList();
  private FilteredList<XAppointmentGroup> filteredMasterData = new FilteredList<>(masterData, p-> true);
  
  private LongProperty idProperty = new SimpleLongProperty();
  private BooleanProperty enableSubmitProperty = new SimpleBooleanProperty(false);
  
  private LongProperty appointmentIdProperty = new SimpleLongProperty();
  private StringProperty topicProperty = new SimpleStringProperty();
  private StringProperty summaryProperty = new SimpleStringProperty();
  private ObjectProperty<java.time.LocalDateTime> startProperty = new SimpleObjectProperty<>();
  private ObjectProperty<java.time.LocalDateTime> endProperty = new SimpleObjectProperty<>();
  private IntegerProperty appointmentGroupIdProperty = new SimpleIntegerProperty();
  
  public XAppointmentGroupFX() {
    this(new XAppointmentGroup());
  }
  
  public XAppointmentGroupFX(XAppointmentGroup xAppointmentGroup) {
    this.xAppointmentGroup=xAppointmentGroup;
    this.xAppointmentGroupProperty.set(xAppointmentGroup);
    
	this.xAppointmentGroupProperty.addListener((observable, oldValue, newValue) -> {
		if (newValue!=null) {
			appointmentIdProperty.set(newValue.getAppointmentId());
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

  public ObjectProperty<XAppointmentGroup> getXAppointmentGroupProperty() {
    return xAppointmentGroupProperty;
  }

  public BooleanProperty getEnabledSubmitProperty() {
    return enableSubmitProperty;
  }
  
  public ObservableList<XAppointmentGroup>  getMasterData(){
  	return masterData;
  }

  public FilteredList<XAppointmentGroup> getFilteredMasterData(){
  	return filteredMasterData;
  }
  
  public XAppointmentGroup getXAppointmentGroup() {
  	this.xAppointmentGroup = new XAppointmentGroup();
  	this.xAppointmentGroup.setAppointmentId(appointmentIdProperty.getValue());
  	this.xAppointmentGroup.setTopic(topicProperty.getValue());
  	this.xAppointmentGroup.setSummary(summaryProperty.getValue());
  	this.xAppointmentGroup.setStart(startProperty.getValue());
  	this.xAppointmentGroup.setEnd(endProperty.getValue());
  	this.xAppointmentGroup.setAppointmentGroupId(appointmentGroupIdProperty.getValue());
    return this.xAppointmentGroup;
  }
  
  public LongProperty getIdProperty(){
  	return idProperty;
  }
  
  public void setIdProperty(LongProperty idProperty){
  	this.idProperty = idProperty;
  }
  
  public LongProperty getAppointmentIdProperty() {
    return this.appointmentIdProperty;
  }
  
  public void setAppointmentIdProperty(LongProperty appointmentIdProperty) {
    this.appointmentIdProperty = appointmentIdProperty;
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
  public IntegerProperty getAppointmentGroupIdProperty() {
    return this.appointmentGroupIdProperty;
  }
  
  public void setAppointmentGroupIdProperty(IntegerProperty appointmentGroupIdProperty) {
    this.appointmentGroupIdProperty = appointmentGroupIdProperty;
  }

  public void clear() {
  	  this.appointmentIdProperty.set(0l);
  	  this.topicProperty.set("");
  	  this.summaryProperty.set("");
  	  this.startProperty.set(java.time.LocalDateTime.now());
  	  this.endProperty.set(java.time.LocalDateTime.now());
  	  this.appointmentGroupIdProperty.set(0);
  }

  public String toString() {
    return  org.apache.commons.lang.builder.ToStringBuilder.reflectionToString(getXAppointmentGroup());
  }
}
