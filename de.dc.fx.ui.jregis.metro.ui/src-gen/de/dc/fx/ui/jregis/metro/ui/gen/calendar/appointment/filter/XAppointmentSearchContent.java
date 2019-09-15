package de.dc.fx.ui.jregis.metro.ui.gen.calendar.appointment.filter;

import org.apache.commons.lang.builder.ToStringBuilder;

public class XAppointmentSearchContent {

	private String name;
	private String value;
	private XAppointmentSearchType type;

	public XAppointmentSearchContent(String name, String value, XAppointmentSearchType type) {
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

	public XAppointmentSearchType getType() {
		return type;
	}

	public void setType(XAppointmentSearchType type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
