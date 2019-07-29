package de.dc.fx.ui.jregis.metro.ui.model;

import java.time.LocalDateTime;

public class Reference extends IdElement {

	private long referenceTypeId;
	private long firstId;
	private long secondId;

	public Reference(LocalDateTime createdOn, LocalDateTime updatedOn, long referenceTypeId, long firstId,
			long secondId) {
		super("", createdOn, updatedOn);
		this.referenceTypeId = referenceTypeId;
		this.firstId = firstId;
		this.secondId = secondId;
	}

	public long getReferenceTypeId() {
		return referenceTypeId;
	}

	public void setReferenceTypeId(long referenceTypeId) {
		this.referenceTypeId = referenceTypeId;
	}

	public long getFirstId() {
		return firstId;
	}

	public void setFirstId(long firstId) {
		this.firstId = firstId;
	}

	public long getSecondId() {
		return secondId;
	}

	public void setSecondId(long secondId) {
		this.secondId = secondId;
	}

}