package de.dc.fx.ui.jregis.metro.ui.gen.contacts.contact.model;

import de.dc.fx.ui.jregis.metro.ui.gen.contacts.contact.model.*;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;

import java.lang.String;
import java.lang.String;
import java.lang.String;
import java.lang.Long;

public class ContactFX {

	private Contact contact;
	private ObjectProperty<Contact> contactProperty = new SimpleObjectProperty<>();
	private ObservableList<Contact> masterData = FXCollections.observableArrayList();
	private FilteredList<Contact> filteredMasterData = new FilteredList<>(masterData, p -> true);

	private LongProperty idProperty = new SimpleLongProperty();
	private BooleanProperty enableSubmitProperty = new SimpleBooleanProperty(false);

	private StringProperty firstnameProperty = new SimpleStringProperty();
	private StringProperty lastnameProperty = new SimpleStringProperty();
	private StringProperty usernameProperty = new SimpleStringProperty();
	private LongProperty contactImageIdProperty = new SimpleLongProperty();

	public ContactFX() {
		this(new Contact());
	}

	public ContactFX(Contact contact) {
		this.contact = contact;
		this.contactProperty.set(contact);

		this.contactProperty.addListener((observable, oldValue, newValue) -> {
			if (newValue != null) {
				firstnameProperty.set(newValue.getFirstname());
				lastnameProperty.set(newValue.getLastname());
				usernameProperty.set(newValue.getUsername());
				contactImageIdProperty.set(newValue.getContactImageId());
//			emailsProperty.set(newValue.getEmails());
//			addressListProperty.set(newValue.getAddressList());
//			phoneListProperty.set(newValue.getPhoneList());
//			dateListProperty.set(newValue.getDateList());
			}
		});

		BooleanBinding isEnabled = firstnameProperty.isNotEmpty().and(lastnameProperty.isNotEmpty())
				.and(usernameProperty.isNotEmpty());
		this.enableSubmitProperty.bind(isEnabled);
	}

	public ObjectProperty<Contact> getContactProperty() {
	    return contactProperty;
	  }

	public BooleanProperty getEnabledSubmitProperty() {
		return enableSubmitProperty;
	}

	public ObservableList<Contact> getMasterData() {
		return masterData;
	}

	public FilteredList<Contact> getFilteredMasterData() {
		return filteredMasterData;
	}

	public Contact getContact() {
		this.contact = new Contact();
		this.contact.setFirstname(firstnameProperty.getValue());
		this.contact.setLastname(lastnameProperty.getValue());
		this.contact.setUsername(usernameProperty.getValue());
		this.contact.setContactImageId(contactImageIdProperty.getValue());
		return this.contact;
	}

	public LongProperty getIdProperty() {
		return idProperty;
	}

	public void setIdProperty(LongProperty idProperty) {
		this.idProperty = idProperty;
	}

	public StringProperty getFirstnameProperty() {
		return this.firstnameProperty;
	}

	public void setFirstnameProperty(StringProperty firstnameProperty) {
		this.firstnameProperty = firstnameProperty;
	}

	public StringProperty getLastnameProperty() {
		return this.lastnameProperty;
	}

	public void setLastnameProperty(StringProperty lastnameProperty) {
		this.lastnameProperty = lastnameProperty;
	}

	public StringProperty getUsernameProperty() {
		return this.usernameProperty;
	}

	public void setUsernameProperty(StringProperty usernameProperty) {
		this.usernameProperty = usernameProperty;
	}

	public LongProperty getContactImageIdProperty() {
		return this.contactImageIdProperty;
	}

	public void setContactImageIdProperty(LongProperty contactImageIdProperty) {
		this.contactImageIdProperty = contactImageIdProperty;
	}

	public void clear() {
		this.firstnameProperty.set("");
		this.lastnameProperty.set("");
		this.usernameProperty.set("");
		this.contactImageIdProperty.set(0l);
	}

	public String toString() {
		return org.apache.commons.lang.builder.ToStringBuilder.reflectionToString(getContact());
	}
}
