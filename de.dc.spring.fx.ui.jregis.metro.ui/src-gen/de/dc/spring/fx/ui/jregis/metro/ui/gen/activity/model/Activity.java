package de.dc.spring.fx.ui.jregis.metro.ui.gen.activity.model;

import java.util.*;
import java.time.*;
import org.apache.commons.lang.builder.ToStringBuilder;

import javax.persistence.*;

@Entity
public class Activity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, columnDefinition = "BIGINT")
	private Long id;
	@Column(nullable = true)
	private String title;
	@Column(nullable = true)
	private Integer status;
	@Column(nullable = true)
	private Long userId;
	@Column(nullable = true)
	private String description;
	@Column(nullable = true)
	private LocalDateTime createdOn;
	@Column(nullable = true)
	private LocalDateTime updatedOn;
	@Transient
	private String author;
	
	public Activity() {
	}
		
	public Activity(String title, Integer status, Long userId, String description, LocalDateTime createdOn, LocalDateTime updatedOn) {
		this.title = title;
		this.status = status;
		this.userId = userId;
		this.description = description;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
	}
	
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Long getId(){
		return id;
	}
	
	public void setId(Long id){
		this.id=id;
	}
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}
	public LocalDateTime getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(LocalDateTime updatedOn) {
		this.updatedOn = updatedOn;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
