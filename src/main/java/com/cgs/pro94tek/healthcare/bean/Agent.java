package com.cgs.pro94tek.healthcare.bean;

import java.io.Serializable;
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
@Table(name="agent", uniqueConstraints = { @UniqueConstraint (columnNames = {"ID","officeid"})})
@JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
public class Agent implements Serializable {
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name = "ID", unique = true, nullable = false)
	private int id;

	@Column(length=20, nullable = false)
	private String fname;

	@Column(length=20)
	private String mname;

	@Column(length=100, nullable = false)
	private String lname;

	@Column(length=100, nullable = false)
	private String name;

	@Column(length=100, nullable = false)
	private String corporateaddress;
	
	@Column(length=100, nullable = false)
	private String mailingaddress;
	
	@Column(length=15, nullable = false)
	private String mobile;
	
	@Column(length=50, nullable = false)
	private String state;
	
	@Column(length=100, nullable = false)
	private String district;
	
	@Column(length=50, nullable = false)
	private String city;
	
	@Column(length=10, nullable = false)
	private String createdby;

	@Temporal(TemporalType.DATE)
	private Date createddate;
	
	@Column(name="officeid", length=10)
	private int officeid;

	@Column(length=2, nullable = false)
	private String status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCorporateaddress() {
		return corporateaddress;
	}

	public void setCorporateaddress(String corporateaddress) {
		this.corporateaddress = corporateaddress;
	}

	public String getMailingaddress() {
		return mailingaddress;
	}

	public void setMailingaddress(String mailingaddress) {
		this.mailingaddress = mailingaddress;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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

	public int getOfficeid() {
		return officeid;
	}

	public void setOfficeid(int officeid) {
		this.officeid = officeid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
	