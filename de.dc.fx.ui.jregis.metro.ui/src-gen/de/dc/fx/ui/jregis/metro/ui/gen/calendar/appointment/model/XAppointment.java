package de.dc.fx.ui.jregis.metro.ui.gen.calendar.appointment.model;

import java.util.*;
import java.time.*;
import org.apache.commons.lang.builder.ToStringBuilder;

public class XAppointment{

	private Long id;
	private Long contactId;
	private String topic;
	private String summary;
	private LocalDateTime start;
	private LocalDateTime end;
	private Long appointmentGroupId;
	
	public XAppointment() {
	}
		
	public XAppointment(Long contactId, String topic, String summary, LocalDateTime start, LocalDateTime end, Long appointmentGroupId) {
		this.contactId = contactId;
		this.topic = topic;
		this.summary = summary;
		this.start = start;
		this.end = end;
		this.appointmentGroupId = appointmentGroupId;
	}
	
	public Long getId(){
		return id;
	}
	
	public void setId(Long id){
		this.id=id;
	}
	public Long getContactId() {
		return contactId;
	}

	public void setContactId(Long contactId) {
		this.contactId = contactId;
	}
	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}
	public LocalDateTime getStart() {
		return start;
	}

	public void setStart(LocalDateTime start) {
		this.start = start;
	}
	public LocalDateTime getEnd() {
		return end;
	}

	public void setEnd(LocalDateTime end) {
		this.end = end;
	}
	public Long getAppointmentGroupId() {
		return appointmentGroupId;
	}

	public void setAppointmentGroupId(Long appointmentGroupId) {
		this.appointmentGroupId = appointmentGroupId;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
