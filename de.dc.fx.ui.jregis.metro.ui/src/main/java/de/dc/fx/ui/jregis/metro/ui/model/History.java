package de.dc.fx.ui.jregis.metro.ui.model;

import java.time.LocalDateTime;

public class History extends IdElement{

	private String name;

	private Long documentId;

	private LocalDateTime timestamp;

	private String files;
	
	private Document document;

	public History() {
	}
	
	public History(String name, Long documentId, LocalDateTime timeestamp) {
		this.name = name;
		this.documentId = documentId;
		this.timestamp = timeestamp;
	}

	public History(String name, Long documentId, LocalDateTime timeestamp, String files) {
		this.name = name;
		this.documentId = documentId;
		this.timestamp = timeestamp;
		this.files = files;
	}

	public Document getDocument() {
		return document;
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

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
