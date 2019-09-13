package de.dc.spring.fx.ui.jregis.metro.ui.user.model;

import java.time.LocalDateTime;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class UserContext {

	public Property<String> username = new SimpleStringProperty("");
	public Property<String> password = new SimpleStringProperty("");
	public Property<String> firstname = new SimpleStringProperty("");
	public Property<String> lastname = new SimpleStringProperty("");
	public Property<String> email = new SimpleStringProperty("");
	public Property<String> address = new SimpleStringProperty("");
	public Property<String> city = new SimpleStringProperty("");
	public Property<String> state = new SimpleStringProperty("");
	public Property<String> country = new SimpleStringProperty("");
	public Property<String> mobile = new SimpleStringProperty("");
	public ObjectProperty<LocalDateTime> birthday = new SimpleObjectProperty<>();

}
