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
@Table(name="vehicle_type", uniqueConstraints = { @UniqueConstraint (columnNames = {"ID","officeid"})})
@JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
public class VehicleType {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name = "ID", unique = true, nullable = false)
	private int id;

	@Column(length=20, nullable = false)
	private String type;

	@Column(length=20, nullable = false)
	private String description;

	@Column(length=100, nullable = false)
	private String createdby;

	@Column(length=100, nullable = false)
	@Temporal(TemporalType.DATE)
	private Date createddate;
	
	@Column(length=2, nullable = false)
	private String status;
	
	
	@Column(length=2, nullable = false)
	private String officeid;


//	@OneToOne(fetch = FetchType.LAZY, mappedBy = "vehicles")
//	private Vehicle vehicles;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getCreatedby() {
		return createdby;
	}


	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}


	public Date getCreateddate() {
		return createddate;
	}


	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
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
