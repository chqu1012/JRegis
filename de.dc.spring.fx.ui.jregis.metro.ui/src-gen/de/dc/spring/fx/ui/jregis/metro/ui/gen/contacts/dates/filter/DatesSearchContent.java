package de.dc.spring.fx.ui.jregis.metro.ui.gen.contacts.dates.filter;

import org.apache.commons.lang.builder.ToStringBuilder;

public class DatesSearchContent {

	private String name;
	private String value;
	private DatesSearchType type;

	public DatesSearchContent(String name, String value, DatesSearchType type) {
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

	public DatesSearchType getType() {
		return type;
	}

	public void setType(DatesSearchType type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
