package de.dc.fx.ui.jregis.metro.ui.model;

import java.sql.Timestamp;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.google.common.base.MoreObjects.ToStringHelper;

public class Document {

	private long id;
	private long categoryId;
	private String name;
	private Timestamp timestamp;
	
	public Document() {
	}
	
	public Document(int id, int categoryId, String name, Timestamp timestamp) {
		this.id = id;
		this.categoryId = categoryId;
		this.name = name;
		this.timestamp = timestamp;
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
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
