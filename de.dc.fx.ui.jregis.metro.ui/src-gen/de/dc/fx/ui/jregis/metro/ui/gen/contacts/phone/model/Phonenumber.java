package de.dc.fx.ui.jregis.metro.ui.gen.contacts.phone.model;

import java.util.*;
import java.time.*;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Phonenumber{

	private Long id;
	private Long contactId;
	private String name;
	private String number;
	private String numberType;
	
	public Phonenumber() {
	}
		
	public Phonenumber(Long contactId, String name, String number, String numberType) {
		this.contactId = contactId;
		this.name = name;
		this.number = number;
		this.numberType = numberType;
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
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	public String getNumberType() {
		return numberType;
	}

	public void setNumberType(String numberType) {
		this.numberType = numberType;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
