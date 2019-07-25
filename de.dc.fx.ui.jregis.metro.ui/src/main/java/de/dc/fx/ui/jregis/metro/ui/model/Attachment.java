package de.dc.fx.ui.jregis.metro.ui.model;

import java.time.LocalDateTime;

public class Attachment extends IdElement {

	private long documentId;

	public Attachment(String name, LocalDateTime createdOn, LocalDateTime updatedOn, String name2, long documentId) {
		super(name, createdOn, updatedOn);
		this.documentId = documentId;
	}

	public long getDocumentId() {
		return documentId;
	}

	public void setDocumentId(long documentId) {
		this.documentId = documentId;
	}
}
