package de.dc.fx.ui.jregis.metro.ui.gen.calendar.group.filter;

import org.apache.commons.lang.builder.ToStringBuilder;

public class XAppointmentGroupSearchContent {

	private String name;
	private String value;
	private XAppointmentGroupSearchType type;

	public XAppointmentGroupSearchContent(String name, String value, XAppointmentGroupSearchType type) {
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

	public XAppointmentGroupSearchType getType() {
		return type;
	}

	public void setType(XAppointmentGroupSearchType type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
