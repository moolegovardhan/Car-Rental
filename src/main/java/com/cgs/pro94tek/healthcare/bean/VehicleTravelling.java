package com.cgs.pro94tek.healthcare.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.codehaus.jackson.map.annotate.JsonSerialize;

@Entity
@Table(name="vehicle_travelling", uniqueConstraints = { @UniqueConstraint (columnNames = {"ID","officeid"})})
@JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
public class VehicleTravelling {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name = "ID", unique = true, nullable = false)
	private int id;
	
	@Column(length=20, nullable = false)
	private int vehicleid;
	
	@Column(length=20, nullable = false)
	private int driverid;
	
	@Column(length=100, nullable = false)
	private String startpoint;
	
	@Column(length=100, nullable = false)
	private String endpoint;
	
	@Column(length=100, nullable = false)
	private String journeytype;
	
	@Column(length=20, nullable = false)
	private String otp;
	
	@Column(length=200, nullable = false)
	private String totaldistencetraveled;
	
	@Column(length=100, nullable = false)
	private String totalfare;
	
	@Column(length=20, nullable = false)
	private String createdby;
	
	@Column(length=2, nullable = false)
	private String status;
	
	@Column(length=20, nullable = false)
	private Date createddate;
	
	@Column(length=20, nullable = false)
	private String officeid;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getVehicleid() {
		return vehicleid;
	}

	public void setVehicleid(int vehicleid) {
		this.vehicleid = vehicleid;
	}

	public int getDriverid() {
		return driverid;
	}

	public void setDriverid(int driverid) {
		this.driverid = driverid;
	}

	public String getStartpoint() {
		return startpoint;
	}

	public void setStartpoint(String startpoint) {
		this.startpoint = startpoint;
	}

	public String getEndpoint() {
		return endpoint;
	}

	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}

	public String getJourneytype() {
		return journeytype;
	}

	public void setJourneytype(String journeytype) {
		this.journeytype = journeytype;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public String getTotaldistencetraveled() {
		return totaldistencetraveled;
	}

	public void setTotaldistencetraveled(String totaldistencetraveled) {
		this.totaldistencetraveled = totaldistencetraveled;
	}

	public String getTotalfare() {
		return totalfare;
	}

	public void setTotalfare(String totalfare) {
		this.totalfare = totalfare;
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

	public Date getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}

	public String getOfficeid() {
		return officeid;
	}

	public void setOfficeid(String officeid) {
		this.officeid = officeid;
	}
	
	
}
