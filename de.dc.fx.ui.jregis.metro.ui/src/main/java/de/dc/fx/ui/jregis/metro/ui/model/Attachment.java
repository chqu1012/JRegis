package de.dc.fx.ui.jregis.metro.ui.model;

import java.time.LocalDateTime;

public class Attachment extends IdElement {

	private long historyId;

	public Attachment(String name, LocalDateTime createdOn, LocalDateTime updatedOn, long historyId) {
		super(name, createdOn, updatedOn);
		this.historyId = historyId;
	}

	public long getHistoryId() {
		return historyId;
	}

	public void setHistoryId(long historyId) {
		this.historyId = historyId;
	}
}
