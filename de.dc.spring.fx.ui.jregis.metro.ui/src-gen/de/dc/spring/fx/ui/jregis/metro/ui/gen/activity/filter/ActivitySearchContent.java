package de.dc.spring.fx.ui.jregis.metro.ui.gen.activity.filter;

import org.apache.commons.lang.builder.ToStringBuilder;

public class ActivitySearchContent {

	private String name;
	private String value;
	private ActivitySearchType type;

	public ActivitySearchContent(String name, String value, ActivitySearchType type) {
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

	public ActivitySearchType getType() {
		return type;
	}

	public void setType(ActivitySearchType type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
