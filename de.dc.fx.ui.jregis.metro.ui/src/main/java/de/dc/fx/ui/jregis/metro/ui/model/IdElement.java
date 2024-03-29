package de.dc.fx.ui.jregis.metro.ui.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class IdElement {

	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	
	protected long id;

	protected String name;

	protected LocalDateTime createdOn;

	protected LocalDateTime updatedOn;
	
	protected long status = 0;
	
	public IdElement(String name, LocalDateTime createdOn, LocalDateTime updatedOn) {
		this.name = name;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
	}

	public long getStatus() {
		return status;
	}

	public void setStatus(long status) {
		this.status = status;
	}

	public String getUpdatedOnAsString() {
		return updatedOn.format(formatter);
	}
	
	public String getCreatedOnAsString() {
		return createdOn.format(formatter);
	}
	
	public LocalDateTime getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(LocalDateTime updatedOn) {
		this.updatedOn = updatedOn;
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
