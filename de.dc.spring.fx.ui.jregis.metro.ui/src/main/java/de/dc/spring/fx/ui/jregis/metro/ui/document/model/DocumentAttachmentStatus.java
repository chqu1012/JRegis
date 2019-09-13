package de.dc.spring.fx.ui.jregis.metro.ui.document.model;

public enum DocumentAttachmentStatus {
	ADD(0),
	DELETE(1);
	
	private long statusValue;

	private DocumentAttachmentStatus(long statusValue) {
		this.statusValue = statusValue;
	}

	public long getStatusValue() {
		return statusValue;
	}
}
