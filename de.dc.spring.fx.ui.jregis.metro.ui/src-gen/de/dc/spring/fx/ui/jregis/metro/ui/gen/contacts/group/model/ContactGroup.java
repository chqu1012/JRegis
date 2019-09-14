package de.dc.spring.fx.ui.jregis.metro.ui.gen.contacts.group.model;

import java.util.*;
import java.time.*;
import org.apache.commons.lang.builder.ToStringBuilder;

import javax.persistence.*;

@Entity
public class ContactGroup{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, columnDefinition = "BIGINT")
	private Long id;
	@Column(nullable = true)
	private String name;
	@Column(nullable = true)
	private Integer status;
	@Column(nullable = false)
	private String color;
	@Column(nullable = false)
	private String hoverColor;
	@Column(nullable = true)
	private LocalDateTime createdOn;
	@Column(nullable = true)
	private LocalDateTime updatedOn;
	@Transient
	private java.util.List<de.dc.spring.fx.ui.jregis.metro.ui.gen.contacts.contact.model.Contact> contactList = new java.util.ArrayList<>();
	
	public ContactGroup() {
	}
		
	public ContactGroup(String name, Integer status, LocalDateTime createdOn, LocalDateTime updatedOn) {
		this.name = name;
		this.status = status;
		this.color = color;
		this.hoverColor = hoverColor;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
	}
	
	public Long getId(){
		return id;
	}
	
	public void setId(Long id){
		this.id=id;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	public String getHoverColor() {
		return hoverColor;
	}

	public void setHoverColor(String hoverColor) {
		this.hoverColor = hoverColor;
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
	public java.util.List<de.dc.spring.fx.ui.jregis.metro.ui.gen.contacts.contact.model.Contact> getContactList() {
		return contactList;
	}

	public void setContactList(java.util.List<de.dc.spring.fx.ui.jregis.metro.ui.gen.contacts.contact.model.Contact> contactList) {
		this.contactList=contactList;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
