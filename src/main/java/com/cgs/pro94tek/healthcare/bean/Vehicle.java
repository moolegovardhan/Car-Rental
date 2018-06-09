package com.cgs.pro94tek.healthcare.bean;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.codehaus.jackson.map.annotate.JsonSerialize;

@SuppressWarnings("serial")
@Entity
@Table(name="vehicleregistration", uniqueConstraints = { @UniqueConstraint (columnNames = {"ID","officeid"})}) 
@JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
public class Vehicle implements Serializable{


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name = "ID", unique = true, nullable = false)
	private Long id;

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO, generator = "ID_seq")
	@SequenceGenerator (sequenceName = "vehicle_id_seq", name = "ID_seq")
	@Column(name="vehicletypeid", unique = true, nullable = false, length=100)
	private Integer vehicletypeid;

	@Column(name="ownername", length=100)
	private String ownername;

	@Column(name="chessisnumber", length=100)
	private String chessisnumber;

	@Column(name="vehiclenumber", length=100)
	private String vehiclenumber;

	@Column(name="ownermobile", length=100)
	private String ownermobile;

	@Temporal(TemporalType.DATE)
	@Column(name="dateofpurchase", length=100)
	private Date dateofpurchase;

	@Temporal(TemporalType.DATE)
	@Column(name="pollutionexpdate", length=100)
	private Date pollutionexpdate;

	@Temporal(TemporalType.DATE)
	@Column(name="fitnessexpdate", length=100)
	private Date fitnessexpdate;

	@Column(name="roadtax", length=100)
	private String roadtax;

	@Column(name="createdby", length=100)
	private String createdby;

	@Column(name="status", length=100)
	private String status;

	@Column(name="officeid", length=10)
	private int officeid;

	@Temporal(TemporalType.DATE)
	@Column(name="createddate", length=100)
	private Date createddate;

/*	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn (name="vehicletypeid", referencedColumnName="id", nullable=false, unique=true)
*/

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getVehicletypeid() {
		return vehicletypeid;
	}

	public void setVehicletypeid(Integer vehicletypeid) {
		this.vehicletypeid = vehicletypeid;
	}

	public String getOwnername() {
		return ownername;
	}

	public void setOwnername(String ownername) {
		this.ownername = ownername;
	}

	public String getChessisnumber() {
		return chessisnumber;
	}

	public void setChessisnumber(String chessisnumber) {
		this.chessisnumber = chessisnumber;
	}

	public String getVehiclenumber() {
		return vehiclenumber;
	}

	public void setVehiclenumber(String vehiclenumber) {
		this.vehiclenumber = vehiclenumber;
	}

	public String getOwnermobile() {
		return ownermobile;
	}

	public void setOwnermobile(String ownermobile) {
		this.ownermobile = ownermobile;
	}

	public Date getDateofpurchase() {
		return dateofpurchase;
	}

	public void setDateofpurchase(Date dateofpurchase) {
		this.dateofpurchase = dateofpurchase;
	}

	public Date getPollutionexpdate() {
		return pollutionexpdate;
	}

	public void setPollutionexpdate(Date pollutionexpdate) {
		this.pollutionexpdate = pollutionexpdate;
	}

	public Date getFitnessexpdate() {
		return fitnessexpdate;
	}

	public void setFitnessexpdate(Date fitnessexpdate) {
		this.fitnessexpdate = fitnessexpdate;
	}

	public String getRoadtax() {
		return roadtax;
	}

	public void setRoadtax(String roadtax) {
		this.roadtax = roadtax;
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

	public int getOfficeid() {
		return officeid;
	}

	public void setOfficeid(int officeid) {
		this.officeid = officeid;
	}

	public Date getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}
	



}
