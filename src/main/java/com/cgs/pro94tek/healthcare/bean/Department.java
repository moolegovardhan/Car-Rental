package com.cgs.pro94tek.healthcare.bean;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.codehaus.jackson.map.annotate.JsonSerialize;

@Entity
@Table(name="departments", uniqueConstraints = { @UniqueConstraint (columnNames = {"ID","officeid"})}) 
@JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
public class Department {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID",nullable=false,unique=true)

	private Integer id;
	@Column(name="departmentname", length=20)
	private String departmentname;

	@Column(name="description", length=20)
	private String description;
	
	@Column(name="createdBy", length=20)
	private String createdBy;

	@Temporal(TemporalType.DATE)
	@Column(name="createdDate")
	private Date createdDate;

	@Column(name="status", length=20)
	private String status;
	
	@Column(name="officeid", length=20)
	private String officeid;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDepartmentname() {
		return departmentname;
	}

	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOfficeid() {
		return officeid;
	}

	public void setOfficeid(String officeid) {
		this.officeid = officeid;
	}
	

}
