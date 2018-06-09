package com.cgs.pro94tek.healthcare.modal;

import java.util.Date;

public class WardTypeModal {
	
	private Long     id;
	private String   wardtype;
	private String   status;
	private Integer officeid = 0;
	private String   description;
	private String   createdBy;
	private Date     createdDate;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getWardtype() {
		return wardtype;
	}
	public void setWardtype(String wardtype) {
		this.wardtype = wardtype;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getOfficeid() {
		return officeid;
	}
	public void setOfficeid(Integer officeid) {
		this.officeid = officeid;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	
	
	

}
