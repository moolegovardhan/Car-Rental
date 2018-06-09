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
@JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
@Table(name="drivermapping", uniqueConstraints = { @UniqueConstraint (columnNames = {"ID","officeid"}) }) 
public class DriverMapping {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private int id;

	//@OneToMany(cascade=CascadeType.ALL)
	@Column(name="driverid")
	private int driverid;

	@Column(name="vehicletypeid")
	private int vehicletypeid;

	@Column(name = "vehiclenumber")
	private String vehiclenumber;
	
	@Column(name="createdby")
	private String createdby;
	
	@Column(name="status")
	private String status;
	
	@Column(name="officeid")
	private String officeid;
	
	@Column(name="createddate")
	private Date createddate;
	
	/*@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="driverid")
	private Set<Driver> driver;*/
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDriverid() {
		return driverid;
	}

	public void setDriverid(int driverid) {
		this.driverid = driverid;
	}

	public int getVehicletypeid() {
		return vehicletypeid;
	}

	public void setVehicletypeid(int vehicletypeid) {
		this.vehicletypeid = vehicletypeid;
	}

	public String getVehiclenumber() {
		return vehiclenumber;
	}

	public void setVehiclenumber(String vehiclenumber) {
		this.vehiclenumber = vehiclenumber;
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

	public String getOfficeid() {
		return officeid;
	}

	public void setOfficeid(String officeid) {
		this.officeid = officeid;
	}

	public Date getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}


	



}
