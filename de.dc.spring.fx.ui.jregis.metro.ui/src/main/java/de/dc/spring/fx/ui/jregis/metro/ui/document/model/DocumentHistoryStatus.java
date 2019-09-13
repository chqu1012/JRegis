package de.dc.spring.fx.ui.jregis.metro.ui.document.model;

public enum DocumentHistoryStatus {
	ADD(0),
	DELETE(1);
	
	private long statusValue;

	private DocumentHistoryStatus(long statusValue) {
		this.statusValue = statusValue;
	}

	public long getStatusValue() {
		return statusValue;
	}
}
