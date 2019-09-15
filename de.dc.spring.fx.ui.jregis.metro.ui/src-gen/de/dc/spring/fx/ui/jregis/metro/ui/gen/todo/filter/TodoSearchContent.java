package de.dc.spring.fx.ui.jregis.metro.ui.gen.todo.filter;

import org.apache.commons.lang.builder.ToStringBuilder;

public class TodoSearchContent {

	private String name;
	private String value;
	private TodoSearchType type;

	public TodoSearchContent(String name, String value, TodoSearchType type) {
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

	public TodoSearchType getType() {
		return type;
	}

	public void setType(TodoSearchType type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
