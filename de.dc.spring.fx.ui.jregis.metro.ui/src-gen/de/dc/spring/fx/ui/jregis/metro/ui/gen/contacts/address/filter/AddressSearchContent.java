package de.dc.spring.fx.ui.jregis.metro.ui.gen.contacts.address.filter;

import org.apache.commons.lang.builder.ToStringBuilder;

public class AddressSearchContent {

	private String name;
	private String value;
	private AddressSearchType type;

	public AddressSearchContent(String name, String value, AddressSearchType type) {
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

	public AddressSearchType getType() {
		return type;
	}

	public void setType(AddressSearchType type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
