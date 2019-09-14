package de.dc.spring.fx.ui.jregis.metro.ui.gen.contacts.group.filter;

import org.apache.commons.lang.builder.ToStringBuilder;

public class ContactGroupSearchContent {

	private String name;
	private String value;
	private ContactGroupSearchType type;

	public ContactGroupSearchContent(String name, String value, ContactGroupSearchType type) {
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

	public ContactGroupSearchType getType() {
		return type;
	}

	public void setType(ContactGroupSearchType type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
