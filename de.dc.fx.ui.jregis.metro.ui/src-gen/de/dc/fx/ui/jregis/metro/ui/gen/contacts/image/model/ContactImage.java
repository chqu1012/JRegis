package de.dc.fx.ui.jregis.metro.ui.gen.contacts.image.model;

import java.util.*;
import java.time.*;
import org.apache.commons.lang.builder.ToStringBuilder;

public class ContactImage{

	private Long id;
	private String name;
	private LocalDateTime createdOn;
	
	public ContactImage() {
	}
		
	public ContactImage(String name, LocalDateTime createdOn) {
		this.name = name;
		this.createdOn = createdOn;
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
	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
