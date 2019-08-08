package de.dc.fx.ui.jregis.metro.ui.gen.contacts.address.model;

import java.util.*;
import java.time.*;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Address{

	private Long id;
	private Long contactId;
	private String street;
	private String country;
	private String state;
	private Integer zipCode;
	
	public Address() {
	}
		
	public Address(Long contactId, String street, String country, String state, Integer zipCode) {
		this.contactId = contactId;
		this.street = street;
		this.country = country;
		this.state = state;
		this.zipCode = zipCode;
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
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	public Integer getZipCode() {
		return zipCode;
	}

	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
