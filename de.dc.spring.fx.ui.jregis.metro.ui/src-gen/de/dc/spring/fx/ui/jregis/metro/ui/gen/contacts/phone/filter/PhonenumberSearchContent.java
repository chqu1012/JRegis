package de.dc.spring.fx.ui.jregis.metro.ui.gen.contacts.phone.filter;

import org.apache.commons.lang.builder.ToStringBuilder;

public class PhonenumberSearchContent {

	private String name;
	private String value;
	private PhonenumberSearchType type;

	public PhonenumberSearchContent(String name, String value, PhonenumberSearchType type) {
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

	public PhonenumberSearchType getType() {
		return type;
	}

	public void setType(PhonenumberSearchType type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
