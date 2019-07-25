package de.dc.fx.ui.jregis.metro.ui.model;

import java.time.LocalDateTime;

public class History extends IdElement {

	private Long documentId;

	private String files;

	public History(String name, LocalDateTime createdOn, LocalDateTime updatedOn, Long documentId, String files) {
		super(name, createdOn, updatedOn);
		this.documentId = documentId;
		this.files = files;
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
}
