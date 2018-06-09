package com.cgs.pro94tek.healthcare.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.codehaus.jackson.map.annotate.JsonSerialize;

@Entity
@JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
@Table(name="driverregistration", uniqueConstraints = { @UniqueConstraint (columnNames = {"ID","officeid"}) })

public class Driver {
	
	
	@Id
	@Column (name = "ID", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "driverid", length=100, nullable = false)
	private String driverid;
	
	@Column(name = "bloodgroup", length=100)
	private String bloodgroup;
	
	@Column(name = "licencenumber", length=100)
	private String licencenumber;
	
	@Column(name = "createdby", length=100)
	private String createdby;
	
	@Column(name = "status", length=100)
	private String status;
	
	@Column(name = "createddate", length=100)
	private String createddate;
	
	@Column(name = "officeid", length=20)
	private String officeid;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDriverid() {
		return driverid;
	}

	public void setDriverid(String driverid) {
		this.driverid = driverid;
	}

	public String getBloodgroup() {
		return bloodgroup;
	}

	public void setBloodgroup(String bloodgroup) {
		this.bloodgroup = bloodgroup;
	}

	public String getLicencenumber() {
		return licencenumber;
	}

	public void setLicencenumber(String licencenumber) {
		this.licencenumber = licencenumber;
	}

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreateddate() {
		return createddate;
	}

	public void setCreateddate(String createddate) {
		this.createddate = createddate;
	}

	public String getOfficeid() {
		return officeid;
	}

	public void setOfficeid(String officeid) {
		this.officeid = officeid;
	}

	/*@OneToMany (fetch = FetchType.LAZY, mappedBy = "Driver")
	private Set<User> user;
	

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="driverid")
	private DriverMapping drivermapping;
	*/
	
	
}
