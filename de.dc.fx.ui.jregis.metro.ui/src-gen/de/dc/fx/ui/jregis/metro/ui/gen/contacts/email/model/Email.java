package de.dc.fx.ui.jregis.metro.ui.gen.contacts.email.model;

import java.lang.Long;
import java.lang.String;
import java.lang.String;
import java.util.*;

import org.apache.commons.lang.builder.ToStringBuilder;

public class Email{

	private Long id;
	private Long contactId;
	private String name;
	private String email;
	
	public Email() {
	}
		
	public Email(Long contactid, String name, String email) {
		this.contactId = contactId;
		this.name = name;
		this.email = email;
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
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
