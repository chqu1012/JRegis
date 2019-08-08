package de.dc.fx.ui.jregis.metro.ui.gen.contacts.dates.model;

import java.lang.Long;
import java.lang.String;
import java.time.LocalDateTime;
import java.util.*;

import org.apache.commons.lang.builder.ToStringBuilder;

public class Dates{

	private Long id;
	private Long contactId;
	private String name;
	private LocalDateTime date;
	
	public Dates() {
	}
		
	public Dates(Long contactid, String name, LocalDateTime date) {
		this.contactId = contactId;
		this.name = name;
		this.date = date;
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
	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
