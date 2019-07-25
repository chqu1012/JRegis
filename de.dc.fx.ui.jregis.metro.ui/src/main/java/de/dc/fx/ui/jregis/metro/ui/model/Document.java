package de.dc.fx.ui.jregis.metro.ui.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.lang.builder.ToStringBuilder;

public class Document extends IdElement{

	private long categoryId;
	private String description;
	private String url;
	
	public Document(String name, LocalDateTime createdOn, LocalDateTime updatedOn, long categoryId, String description,
			String url) {
		super(name, createdOn, updatedOn);
		this.categoryId = categoryId;
		this.description = description;
		this.url = url;
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

	public long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
