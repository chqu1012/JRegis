package de.dc.fx.ui.jregis.metro.ui.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class History extends IdElement {

	private Long documentId;

	private String files;

	private List<Attachment> attachments = new ArrayList<>();

	public History(String name, LocalDateTime createdOn, LocalDateTime updatedOn, Long documentId, String files) {
		super(name, createdOn, updatedOn);
		this.documentId = documentId;
		this.files = files;
	}

	public List<Attachment> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<Attachment> attachments) {
		this.attachments = attachments;
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
