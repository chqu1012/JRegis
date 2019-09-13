package de.dc.spring.fx.ui.jregis.metro.ui.document.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DocumentReference {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, columnDefinition = "BIGINT")
	private Long id;

	@Column(nullable = true)
	private String name;

	@Column(nullable = false)
	private Long referenceTypeId;

	@Column(nullable = false)
	private Long firstId;

	@Column(nullable = false)
	private Long secondId;

	@Column(nullable = false)
	private LocalDateTime createdOn;

	@Column(nullable = true)
	private LocalDateTime updatedOn;

	public DocumentReference(LocalDateTime createdOn, LocalDateTime updatedOn, Long referenceTypeId, Long firstId,
			Long secondId) {
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
		this.referenceTypeId = referenceTypeId;
		this.firstId = firstId;
		this.secondId = secondId;
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

	public void setReferenceTypeId(Long referenceTypeId) {
		this.referenceTypeId = referenceTypeId;
	}

	public void setFirstId(Long firstId) {
		this.firstId = firstId;
	}

	public void setSecondId(Long secondId) {
		this.secondId = secondId;
	}

	public long getReferenceTypeId() {
		return referenceTypeId;
	}

	public void setReferenceTypeId(long referenceTypeId) {
		this.referenceTypeId = referenceTypeId;
	}

	public long getFirstId() {
		return firstId;
	}

	public void setFirstId(long firstId) {
		this.firstId = firstId;
	}

	public long getSecondId() {
		return secondId;
	}

	public void setSecondId(long secondId) {
		this.secondId = secondId;
	}

}