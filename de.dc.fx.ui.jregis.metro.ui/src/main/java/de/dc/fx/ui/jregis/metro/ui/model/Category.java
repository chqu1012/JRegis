package de.dc.fx.ui.jregis.metro.ui.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;

public class Category {

	private long id;
	private String name;
	private long parentId;
	private LocalDateTime createdOn;
	private LocalDateTime updatedOn;
	
	private Category parent;
	private List<Category> children = new ArrayList<>();
	
	public Category() {
	}
	
	public Category(int id, String name, int parentId) {
		this.id = id;
		this.name = name;
		this.parentId = parentId;
	}

	public Category(String name, long parentId, LocalDateTime createdOn, LocalDateTime updatedOn) {
		this.name = name;
		this.parentId = parentId;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
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

	public Category getParent() {
		return parent;
	}

	public void setParent(Category parent) {
		this.parent = parent;
	}

	public List<Category> getChildren() {
		return children;
	}

	public void setChildren(List<Category> children) {
		this.children = children;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getParentId() {
		return parentId;
	}
	public void setParentId(long parentId) {
		this.parentId = parentId;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
