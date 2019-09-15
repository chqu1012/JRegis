package de.dc.spring.fx.ui.jregis.metro.ui.gen.calendar.group.model;

import java.util.*;
import java.time.*;
import org.apache.commons.lang.builder.ToStringBuilder;

import javax.persistence.*;

@Entity
public class XAppointmentGroup{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, columnDefinition = "BIGINT")
	private Long id;
	@Column(nullable = true)
	private Long appointmentId;
	@Column(nullable = true)
	private String topic;
	@Column(nullable = true)
	private String summary;
	@Column(nullable = true)
	private LocalDateTime start;
	@Column(nullable = true)
	private LocalDateTime end;
	@Column(nullable = true)
	private Integer appointmentGroupId;
	
	public XAppointmentGroup() {
	}
		
	public XAppointmentGroup(Long appointmentId, String topic, String summary, LocalDateTime start, LocalDateTime end, Integer appointmentGroupId) {
		this.appointmentId = appointmentId;
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
	public Long getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Long appointmentId) {
		this.appointmentId = appointmentId;
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
	public Integer getAppointmentGroupId() {
		return appointmentGroupId;
	}

	public void setAppointmentGroupId(Integer appointmentGroupId) {
		this.appointmentGroupId = appointmentGroupId;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
