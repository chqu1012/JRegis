package de.dc.spring.fx.ui.jregis.metro.ui.gen.contacts.email.filter;

import org.apache.commons.lang.builder.ToStringBuilder;

public class ContactEmailSearchContent {

	private String name;
	private String value;
	private ContactEmailSearchType type;

	public ContactEmailSearchContent(String name, String value, ContactEmailSearchType type) {
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

	public ContactEmailSearchType getType() {
		return type;
	}

	public void setType(ContactEmailSearchType type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
