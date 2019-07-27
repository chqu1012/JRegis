package de.dc.fx.ui.jregis.metro.ui.model;

public enum HistoryStatus {
	ADD(0),
	DELETE(1);
	
	private long statusValue;

	private HistoryStatus(long statusValue) {
		this.statusValue = statusValue;
	}

	public long getStatusValue() {
		return statusValue;
	}
}
