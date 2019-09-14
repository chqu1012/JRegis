package de.dc.spring.fx.ui.jregis.metro.ui.gen.contacts.image.filter;

import org.apache.commons.lang.builder.ToStringBuilder;

public class ContactImageSearchContent {

	private String name;
	private String value;
	private ContactImageSearchType type;

	public ContactImageSearchContent(String name, String value, ContactImageSearchType type) {
		this.name = name;
		this.value = value;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public ContactImageSearchType getType() {
		return type;
	}

	public void setType(ContactImageSearchType type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
