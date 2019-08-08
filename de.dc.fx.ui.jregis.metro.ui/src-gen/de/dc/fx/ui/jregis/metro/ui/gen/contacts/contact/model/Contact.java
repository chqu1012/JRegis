package de.dc.fx.ui.jregis.metro.ui.gen.contacts.contact.model;

import java.lang.String;
import java.lang.String;
import java.lang.String;
import java.lang.Long;
import java.util.*;

import org.apache.commons.lang.builder.ToStringBuilder;

public class Contact{

	private Long id;
	private String firstname;
	private String lastname;
	private String account;
	private Long avatarId;
	private java.util.List<de.dc.fx.ui.jregis.metro.ui.gen.contacts.email.model.Email> emailsList = new java.util.ArrayList<>();
	private java.util.List<de.dc.fx.ui.jregis.metro.ui.gen.contacts.address.model.Address> addressListList = new java.util.ArrayList<>();
	private java.util.List<de.dc.fx.ui.jregis.metro.ui.gen.contacts.phone.model.Phonenumber> phoneListList = new java.util.ArrayList<>();
	private java.util.List<de.dc.fx.ui.jregis.metro.ui.gen.contacts.dates.model.Dates> dateListList = new java.util.ArrayList<>();
	
	public Contact() {
	}
		
	public Contact(String firstname, String lastname, String account, Long avatarid) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.account = account;
		this.avatarId = avatarId;
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
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}
	public Long getAvatarId() {
		return avatarId;
	}

	public void setAvatarId(Long avatarId) {
		this.avatarId = avatarId;
	}
	public java.util.List<de.dc.fx.ui.jregis.metro.ui.gen.contacts.email.model.Email> getEmailsList() {
		return emailsList;
	}

	public void setEmails(java.util.List<de.dc.fx.ui.jregis.metro.ui.gen.contacts.email.model.Email> emailsList) {
		this.emailsList=emailsList;
	}
	public java.util.List<de.dc.fx.ui.jregis.metro.ui.gen.contacts.address.model.Address> getAddressListList() {
		return addressListList;
	}

	public void setAddressList(java.util.List<de.dc.fx.ui.jregis.metro.ui.gen.contacts.address.model.Address> addressListList) {
		this.addressListList=addressListList;
	}
	public java.util.List<de.dc.fx.ui.jregis.metro.ui.gen.contacts.phone.model.Phonenumber> getPhoneListList() {
		return phoneListList;
	}

	public void setPhoneList(java.util.List<de.dc.fx.ui.jregis.metro.ui.gen.contacts.phone.model.Phonenumber> phoneListList) {
		this.phoneListList=phoneListList;
	}
	public java.util.List<de.dc.fx.ui.jregis.metro.ui.gen.contacts.dates.model.Dates> getDateListList() {
		return dateListList;
	}

	public void setDateList(java.util.List<de.dc.fx.ui.jregis.metro.ui.gen.contacts.dates.model.Dates> dateListList) {
		this.dateListList=dateListList;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
