package de.dc.fx.ui.jregis.metro.ui.gen.contacts.contact.model;

import java.util.*;
import java.time.*;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Contact{

	private Long id;
	private String firstname;
	private String lastname;
	private String username;
	private Long contactImageId;
	private Long contactGroupId;
	private Integer status;
	private LocalDateTime createdOn;
	private LocalDateTime updatedOn;
	private java.util.List<de.dc.fx.ui.jregis.metro.ui.gen.contacts.email.model.Email> emails = new java.util.ArrayList<>();
	private java.util.List<de.dc.fx.ui.jregis.metro.ui.gen.contacts.address.model.Address> addressList = new java.util.ArrayList<>();
	private java.util.List<de.dc.fx.ui.jregis.metro.ui.gen.contacts.phone.model.Phonenumber> phoneList = new java.util.ArrayList<>();
	private java.util.List<de.dc.fx.ui.jregis.metro.ui.gen.contacts.dates.model.Dates> dateList = new java.util.ArrayList<>();
	
	public Contact() {
	}
		
	public Contact(String firstname, String lastname, String username, Long contactImageId, Long contactGroupId, Integer status, LocalDateTime createdOn, LocalDateTime updatedOn) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.contactImageId = contactImageId;
		this.contactGroupId = contactGroupId;
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
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	public Long getContactImageId() {
		return contactImageId;
	}

	public void setContactImageId(Long contactImageId) {
		this.contactImageId = contactImageId;
	}
	public Long getContactGroupId() {
		return contactGroupId;
	}

	public void setContactGroupId(Long contactGroupId) {
		this.contactGroupId = contactGroupId;
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
	public java.util.List<de.dc.fx.ui.jregis.metro.ui.gen.contacts.email.model.Email> getEmails() {
		return emails;
	}

	public void setEmails(java.util.List<de.dc.fx.ui.jregis.metro.ui.gen.contacts.email.model.Email> emails) {
		this.emails=emails;
	}
	public java.util.List<de.dc.fx.ui.jregis.metro.ui.gen.contacts.address.model.Address> getAddressList() {
		return addressList;
	}

	public void setAddressList(java.util.List<de.dc.fx.ui.jregis.metro.ui.gen.contacts.address.model.Address> addressList) {
		this.addressList=addressList;
	}
	public java.util.List<de.dc.fx.ui.jregis.metro.ui.gen.contacts.phone.model.Phonenumber> getPhoneList() {
		return phoneList;
	}

	public void setPhoneList(java.util.List<de.dc.fx.ui.jregis.metro.ui.gen.contacts.phone.model.Phonenumber> phoneList) {
		this.phoneList=phoneList;
	}
	public java.util.List<de.dc.fx.ui.jregis.metro.ui.gen.contacts.dates.model.Dates> getDateList() {
		return dateList;
	}

	public void setDateList(java.util.List<de.dc.fx.ui.jregis.metro.ui.gen.contacts.dates.model.Dates> dateList) {
		this.dateList=dateList;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
