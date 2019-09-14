package de.dc.spring.fx.ui.jregis.metro.ui.gen.contacts.contact.filter;

import org.apache.commons.lang.builder.ToStringBuilder;

public class ContactSearchContent {

	private String name;
	private String value;
	private ContactSearchType type;

	public ContactSearchContent(String name, String value, ContactSearchType type) {
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

	public ContactSearchType getType() {
		return type;
	}

	public void setType(ContactSearchType type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
