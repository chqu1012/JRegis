package de.dc.fx.ui.jregis.metro.ui.gen.contacts.email.model;

import java.util.*;
import java.time.*;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Email{

	private Long id;
	private Long contactId;
	private String name;
	private String address;
	
	public Email() {
	}
		
	public Email(Long contactId, String name, String address) {
		this.contactId = contactId;
		this.name = name;
		this.address = address;
	}
	
	public Long getId(){
		return id;
	}
	
	public void setId(Long id){
		this.id=id;
	}
	public Long getContactId() {
		return contactId;
	}

	public void setContactId(Long contactId) {
		this.contactId = contactId;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
