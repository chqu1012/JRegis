package de.dc.spring.fx.ui.jregis.metro.ui.gen.todo.model;

import de.dc.spring.fx.ui.jregis.metro.ui.gen.todo.model.*;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import org.springframework.stereotype.Component;

import java.lang.String;
import java.lang.Integer;
import java.time.LocalDateTime;
import java.time.LocalDateTime;

@Component
public class TodoFX {
	
  private Todo todo;
  private ObjectProperty<Todo> todoProperty = new SimpleObjectProperty<>();
  private ObservableList<Todo> masterData = FXCollections.observableArrayList();
  private FilteredList<Todo> filteredMasterData = new FilteredList<>(masterData, p-> true);
  
  private LongProperty idProperty = new SimpleLongProperty();
  private BooleanProperty enableSubmitProperty = new SimpleBooleanProperty(false);
  
  private StringProperty nameProperty = new SimpleStringProperty();
  private IntegerProperty statusProperty = new SimpleIntegerProperty();
  private ObjectProperty<java.time.LocalDateTime> createdOnProperty = new SimpleObjectProperty<>();
  private ObjectProperty<java.time.LocalDateTime> updatedOnProperty = new SimpleObjectProperty<>();
  
  public TodoFX() {
    this(new Todo());
  }
  
  public TodoFX(Todo todo) {
    this.todo=todo;
    this.todoProperty.set(todo);
    
	this.todoProperty.addListener((observable, oldValue, newValue) -> {
		if (newValue!=null) {
			nameProperty.set(newValue.getName());
			statusProperty.set(newValue.getStatus());
			createdOnProperty.set(newValue.getCreatedOn());
			updatedOnProperty.set(newValue.getUpdatedOn());
		}
	});

    BooleanBinding isEnabled = nameProperty.isNotEmpty();
    this.enableSubmitProperty.bind(isEnabled);
  }

  public ObjectProperty<Todo> getTodoProperty() {
    return todoProperty;
  }

  public BooleanProperty getEnabledSubmitProperty() {
    return enableSubmitProperty;
  }
  
  public ObservableList<Todo>  getMasterData(){
  	return masterData;
  }

  public FilteredList<Todo> getFilteredMasterData(){
  	return filteredMasterData;
  }
  
  public Todo getTodo() {
  	this.todo = new Todo();
  	this.todo.setName(nameProperty.getValue());
  	this.todo.setStatus(statusProperty.getValue());
  	this.todo.setCreatedOn(createdOnProperty.getValue());
  	this.todo.setUpdatedOn(updatedOnProperty.getValue());
    return this.todo;
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
  	  this.nameProperty.set("");
  	  this.statusProperty.set(0);
  	  this.createdOnProperty.set(java.time.LocalDateTime.now());
  	  this.updatedOnProperty.set(java.time.LocalDateTime.now());
  }

  public String toString() {
    return  org.apache.commons.lang.builder.ToStringBuilder.reflectionToString(getTodo());
  }
}
