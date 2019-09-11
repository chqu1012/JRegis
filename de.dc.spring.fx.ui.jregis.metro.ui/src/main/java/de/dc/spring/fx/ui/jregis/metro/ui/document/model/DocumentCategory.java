package de.dc.spring.fx.ui.jregis.metro.ui.document.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
public class DocumentCategory{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, columnDefinition = "BIGINT")
	private Long id;

	@Column(nullable = true)
	private String name;
	
	private long parentId;
	
	@Column(nullable = false)
	private LocalDateTime createdOn;

	@Column(nullable = true)
	private LocalDateTime updatedOn;

	@Transient
	private DocumentCategory parent;
	
	@Transient
	private List<DocumentCategory> children = new ArrayList<>();

	public DocumentCategory() {
	}
	
	public DocumentCategory(String name, LocalDateTime createdOn, LocalDateTime updatedOn, long parentId) {
		this.name = name;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
		this.parentId = parentId;
	}

	public DocumentCategory getParent() {
		return parent;
	}

	public void setParent(DocumentCategory parent) {
		this.parent = parent;
	}

	public List<DocumentCategory> getChildren() {
		return children;
	}

	public void setChildren(List<DocumentCategory> children) {
		this.children = children;
	}

	public long getParentId() {
		return parentId;
	}
	public void setParentId(long parentId) {
		this.parentId = parentId;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	
	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}
	
	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}
}
