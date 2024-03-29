package de.dc.fx.ui.jregis.metro.ui.gen.contacts.address.model;

import java.util.*;
import java.time.*;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Address{

	private Long id;
	private Long contactId;
	private String addressType;
	private String street;
	private String country;
	private String state;
	private Integer zipCode;
	private Integer status;
	private LocalDateTime createdOn;
	private LocalDateTime updatedOn;
	
	public Address() {
	}
		
	public Address(Long contactId, String addressType, String street, String country, String state, Integer zipCode, Integer status, LocalDateTime createdOn, LocalDateTime updatedOn) {
		this.contactId = contactId;
		this.addressType = addressType;
		this.street = street;
		this.country = country;
		this.state = state;
		this.zipCode = zipCode;
		this.status = status;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
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
	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
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
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}
	public LocalDateTime getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(LocalDateTime updatedOn) {
		this.updatedOn = updatedOn;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
