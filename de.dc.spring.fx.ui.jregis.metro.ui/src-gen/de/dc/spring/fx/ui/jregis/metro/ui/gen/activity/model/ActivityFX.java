package de.dc.spring.fx.ui.jregis.metro.ui.gen.activity.model;

import de.dc.spring.fx.ui.jregis.metro.ui.gen.activity.model.*;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import org.springframework.stereotype.Component;

import java.lang.String;
import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import java.time.LocalDateTime;
import java.time.LocalDateTime;

@Component
public class ActivityFX {
	
  private Activity activity;
  private ObjectProperty<Activity> activityProperty = new SimpleObjectProperty<>();
  private ObservableList<Activity> masterData = FXCollections.observableArrayList();
  private FilteredList<Activity> filteredMasterData = new FilteredList<>(masterData, p-> true);
  
  private LongProperty idProperty = new SimpleLongProperty();
  private BooleanProperty enableSubmitProperty = new SimpleBooleanProperty(false);
  
  private StringProperty titleProperty = new SimpleStringProperty();
  private IntegerProperty statusProperty = new SimpleIntegerProperty();
  private LongProperty userIdProperty = new SimpleLongProperty();
  private StringProperty descriptionProperty = new SimpleStringProperty();
  private ObjectProperty<java.time.LocalDateTime> createdOnProperty = new SimpleObjectProperty<>();
  private ObjectProperty<java.time.LocalDateTime> updatedOnProperty = new SimpleObjectProperty<>();
  
  public ActivityFX() {
    this(new Activity());
  }
  
  public ActivityFX(Activity activity) {
    this.activity=activity;
    this.activityProperty.set(activity);
    
	this.activityProperty.addListener((observable, oldValue, newValue) -> {
		if (newValue!=null) {
			titleProperty.set(newValue.getTitle());
			statusProperty.set(newValue.getStatus());
			userIdProperty.set(newValue.getUserId());
			descriptionProperty.set(newValue.getDescription());
			createdOnProperty.set(newValue.getCreatedOn());
			updatedOnProperty.set(newValue.getUpdatedOn());
		}
	});

    BooleanBinding isEnabled = titleProperty.isNotEmpty().and(descriptionProperty.isNotEmpty());
    this.enableSubmitProperty.bind(isEnabled);
  }

  public ObjectProperty<Activity> getActivityProperty() {
    return activityProperty;
  }

  public BooleanProperty getEnabledSubmitProperty() {
    return enableSubmitProperty;
  }
  
  public ObservableList<Activity>  getMasterData(){
  	return masterData;
  }

  public FilteredList<Activity> getFilteredMasterData(){
  	return filteredMasterData;
  }
  
  public Activity getActivity() {
  	this.activity = new Activity();
  	this.activity.setTitle(titleProperty.getValue());
  	this.activity.setStatus(statusProperty.getValue());
  	this.activity.setUserId(userIdProperty.getValue());
  	this.activity.setDescription(descriptionProperty.getValue());
  	this.activity.setCreatedOn(createdOnProperty.getValue());
  	this.activity.setUpdatedOn(updatedOnProperty.getValue());
    return this.activity;
  }
  
  public LongProperty getIdProperty(){
  	return idProperty;
  }
  
  public void setIdProperty(LongProperty idProperty){
  	this.idProperty = idProperty;
  }
  
  public StringProperty getTitleProperty() {
    return this.titleProperty;
  }
  
  public void setTitleProperty(StringProperty titleProperty) {
    this.titleProperty = titleProperty;
  }
  public IntegerProperty getStatusProperty() {
    return this.statusProperty;
  }
  
  public void setStatusProperty(IntegerProperty statusProperty) {
    this.statusProperty = statusProperty;
  }
  public LongProperty getUserIdProperty() {
    return this.userIdProperty;
  }
  
  public void setUserIdProperty(LongProperty userIdProperty) {
    this.userIdProperty = userIdProperty;
  }
  public StringProperty getDescriptionProperty() {
    return this.descriptionProperty;
  }
  
  public void setDescriptionProperty(StringProperty descriptionProperty) {
    this.descriptionProperty = descriptionProperty;
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
  	  this.titleProperty.set("");
  	  this.statusProperty.set(0);
  	  this.userIdProperty.set(0l);
  	  this.descriptionProperty.set("");
  	  this.createdOnProperty.set(java.time.LocalDateTime.now());
  	  this.updatedOnProperty.set(java.time.LocalDateTime.now());
  }

  public String toString() {
    return  org.apache.commons.lang.builder.ToStringBuilder.reflectionToString(getActivity());
  }
}
