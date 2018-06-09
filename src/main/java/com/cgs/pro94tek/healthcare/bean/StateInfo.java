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
@Table(name="state_info", uniqueConstraints = { @UniqueConstraint (columnNames = {"ID","state"}) })
@JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
public class StateInfo implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name = "ID", unique = true, nullable = false)
	private Long id;
	
	@Column(name="state", length=100, nullable = false)	
	private String state;
	@Column(name="district", length=100, nullable = false)
	private String district;
	@Column(name="village", length=100, nullable = false)
	private String	village;
	@Column(name="mandal", length=100, nullable = false)
	private String	mandal;
	@Column(name="status", length=100, nullable = false)
	private String	status;
	@Temporal(TemporalType.DATE)
	@Column(name="createddate")
	private Date	createddate;
	@Column(name="createdby", length=100, nullable = false)
	private String	createdby;
	@Column(name="officeid", length=100, nullable = false)
	private String	officeid;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getVillage() {
		return village;
	}
	public void setVillage(String village) {
		this.village = village;
	}
	public String getMandal() {
		return mandal;
	}
	public void setMandal(String mandal) {
		this.mandal = mandal;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCreateddate() {
		return createddate;
	}
	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}
	public String getCreatedby() {
		return createdby;
	}
	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}
	public String getOfficeid() {
		return officeid;
	}
	public void setOfficeid(String officeid) {
		this.officeid = officeid;
	}
	
	
}
