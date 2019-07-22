package de.dc.fx.ui.jregis.metro.ui.model;

public class Attachment {

	private String name;

	public Attachment() {
	}

	public Attachment(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
