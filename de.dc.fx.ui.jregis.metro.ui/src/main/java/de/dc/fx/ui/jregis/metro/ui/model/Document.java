package de.dc.fx.ui.jregis.metro.ui.model;

import java.sql.Timestamp;

import org.apache.commons.lang.builder.ToStringBuilder;

public class Document {

	private long id;
	private long categoryId;
	private String name;
	private String description;
	private String url;
	private Timestamp createdOn;
	private Timestamp updatedOn;
	
	public Document() {
	}
	
	public Document(int id, int categoryId, String name, String description, Timestamp createdOn, Timestamp updatedOn) {
		this.id = id;
		this.categoryId = categoryId;
		this.name = name;
		this.description = description;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Timestamp getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	public Timestamp getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Timestamp updatedOn) {
		this.updatedOn = updatedOn;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
