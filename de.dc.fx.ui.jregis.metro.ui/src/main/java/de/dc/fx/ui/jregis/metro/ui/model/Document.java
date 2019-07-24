package de.dc.fx.ui.jregis.metro.ui.model;

import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;

import org.apache.commons.lang.builder.ToStringBuilder;

public class Document extends IdElement{

	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	
	private long categoryId;
	private String name;
	private String description;
	private String url;
	private Timestamp createdOn;
	private Timestamp updatedOn;
	
	public Document() {
	}
	
	public Document(int categoryId, String name, String description, Timestamp createdOn, Timestamp updatedOn) {
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
	
	public String getCreatedOnString() {
		return createdOn.toLocalDateTime().format(formatter);
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	public String getUpdatedOnString() {
		return updatedOn.toLocalDateTime().format(formatter);
	}
	
	public Timestamp getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Timestamp updatedOn) {
		this.updatedOn = updatedOn;
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
