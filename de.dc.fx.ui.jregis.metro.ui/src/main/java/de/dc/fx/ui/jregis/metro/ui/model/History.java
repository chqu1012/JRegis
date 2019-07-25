package de.dc.fx.ui.jregis.metro.ui.model;

import java.time.LocalDateTime;

public class History extends IdElement {

	private String name;

	private Long documentId;

	private LocalDateTime createdOn;
	
	private LocalDateTime updatedOn;

	private String files;

	private Document document;

	public History() {
	}

	public History(String name, Long documentId, LocalDateTime createdOn, LocalDateTime updatedOn, String files) {
		this.name = name;
		this.documentId = documentId;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
		this.files = files;
	}

	public Document getDocument() {
		return document;
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

	public void setDocument(Document document) {
		this.document = document;
	}

	public Long getDocumentId() {
		return documentId;
	}

	public void setDocumentId(Long documentId) {
		this.documentId = documentId;
	}

	public String getFiles() {
		return files;
	}

	public void setFiles(String files) {
		this.files = files;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
