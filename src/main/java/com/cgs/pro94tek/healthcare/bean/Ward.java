package com.cgs.pro94tek.healthcare.bean;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.codehaus.jackson.map.annotate.JsonSerialize;

@Entity
@JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
@Table(name="ward", uniqueConstraints = { @UniqueConstraint (columnNames = {"ID", "officeid"}) }) 
public class Ward {


	private Long id;
	private String wardname;
	private String wardtype;
	private String officeid;
	private String totaloccupied;
	private String bedscount;
	private String status;
	private Date createdDate;
	private String createdBy;
	private String discount;
	private String bedcost;
	private String finalcost;
	private String chargescost;
	private Set<WardType> wardtypes ;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "ID", unique = true, nullable = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	@Column (name = "wardname", nullable = false)
	public String getWardname() {
		return wardname;
	}

	public void setWardname(String wardname) {
		this.wardname = wardname;
	}

	@Column (name = "wardtype", nullable = true)
	public String getWardtype() {
		return wardtype;
	}

	public void setWardtype(String wardtype) {
		this.wardtype = wardtype;
	}
	
	@Column(name = "officeid", length=10)
	public String getOfficeid() {
		return officeid;
	}

	public void setOfficeid(String officeid) {
		this.officeid = officeid;
	}
	
	@Column(name = "totaloccupied",length=10, nullable = true)
	public String getTotaloccupied() {
		return totaloccupied;
	}

	public void setTotaloccupied(String totaloccupied) {
		this.totaloccupied = totaloccupied;
	}
	@Column(name = "bedscount",length=10, nullable = true)
	public String getBedscount() {
		return bedscount;
	}

	public void setBedscount(String bedscount) {
		this.bedscount = bedscount;
	}
	@Column (name = "status", nullable = false)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	@Column (name = "createdDate", nullable = false)
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	@Column (name = "created_by", nullable = false)
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	@Column (name = "discount", nullable = false)
	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}
	@Column (name = "bedcost", nullable = false)
	public String getBedcost() {
		return bedcost;
	}

	public void setBedcost(String bedcost) {
		this.bedcost = bedcost;
	}
	@Column (name = "finalcost", nullable = false)
	public String getFinalcost() {
		return finalcost;
	}

	public void setFinalcost(String finalcost) {
		this.finalcost = finalcost;
	}
	@Column (name = "chargescost", nullable = false)
	public String getChargescost() {
		return chargescost;
	}

	public void setChargescost(String chargescost) {
		this.chargescost = chargescost;
	}
	@OneToMany (fetch = FetchType.LAZY, mappedBy = "wardtype")
	public Set<WardType> getWardtypes() {
		return wardtypes;
	}

	public void setWardtypes(Set<WardType> wardtypes) {
		this.wardtypes = wardtypes;
	}




}
