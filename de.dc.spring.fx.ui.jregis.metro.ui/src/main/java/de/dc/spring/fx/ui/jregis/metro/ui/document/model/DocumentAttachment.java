package de.dc.spring.fx.ui.jregis.metro.ui.document.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DocumentAttachment{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, columnDefinition = "BIGINT")
	private Long id;

	@Column(nullable = true)
	private String name;
	
	@Column(nullable = false)
	private Long historyId;

	@Column(nullable = false)
	private Long status;
	
	@Column(nullable = false)
	private LocalDateTime createdOn;

	@Column(nullable = true)
	private LocalDateTime updatedOn;

	public DocumentAttachment() {
	}
	
	public DocumentAttachment(String name, LocalDateTime createdOn, LocalDateTime updatedOn, long historyId) {
		this.name = name;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
		this.historyId = historyId;
	}
	
	public Long getHistoryId() {
		return historyId;
	}

	public void setHistoryId(Long historyId) {
		this.historyId = historyId;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
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
}
