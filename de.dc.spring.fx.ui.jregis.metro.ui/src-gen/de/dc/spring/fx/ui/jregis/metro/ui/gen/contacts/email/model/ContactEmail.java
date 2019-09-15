package de.dc.spring.fx.ui.jregis.metro.ui.gen.contacts.email.model;

import java.util.*;
import java.time.*;
import org.apache.commons.lang.builder.ToStringBuilder;

import javax.persistence.*;

@Entity
public class ContactEmail{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, columnDefinition = "BIGINT")
	private Long id;
	@Column(nullable = true)
	private Long contactId;
	@Column(nullable = true)
	private String name;
	@Column(nullable = true)
	private String address;
	@Column(nullable = true)
	private Integer status;
	@Column(nullable = true)
	private LocalDateTime createdOn;
	@Column(nullable = true)
	private LocalDateTime updatedOn;
	
	public ContactEmail() {
	}
		
	public ContactEmail(Long contactId, String name, String address, Integer status, LocalDateTime createdOn, LocalDateTime updatedOn) {
		this.contactId = contactId;
		this.name = name;
		this.address = address;
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
