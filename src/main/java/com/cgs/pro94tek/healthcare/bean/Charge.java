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
@JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
@Table(name="charges_map", uniqueConstraints = { @UniqueConstraint (columnNames = {"ID","officeid"}) })
public class Charge {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name = "ID", unique = true, nullable = false)
	private Long id;
	private String applyid;
	private String chargeid;
	private String chargename;
	private String status;
	private Date effectivedate;
	private String createdBy;
	private Date createdDate;
	private String officeid;
	private String applyname;
	private String chargetype;
	//private Set<ChargeType> ChargeTypes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	@Column(name="applyid", length=100)
	public String getApplyid() {
		return applyid;
	}
	
	public void setApplyid(String applyid) {
		this.applyid = applyid;
	}
	@Column(name="chargeid", length=100)
	public String getChargeid() {
		return chargeid;
	}

	public void setChargeid(String chargeid) {
		this.chargeid = chargeid;
	}
	@Column(name="chargename", length=100)
	public String getChargename() {
		return chargename;
	}

	public void setChargename(String chargename) {
		this.chargename = chargename;
	}
	@Column(name="status", length=20)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	@Column(name="effectivedate")
	public Date getEffectivedate() {
		return effectivedate;
	}

	public void setEffectivedate(Date effectivedate) {
		this.effectivedate = effectivedate;
	}
	@Column(name="createdBy", length=20)
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	@Temporal(TemporalType.DATE)
	@Column(name="createdDate")
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	@Column(name="officeid", length=20)	
	public String getOfficeid() {
		return officeid;
	}

	public void setOfficeid(String officeid) {
		this.officeid = officeid;
	}
	@Column(name="applyname", length=100)
	public String getApplyname() {
		return applyname;
	}

	public void setApplyname(String applyname) {
		this.applyname = applyname;
	}
	@Column(name="chargetype", length=100)
	public String getChargetype() {
		return chargetype;
	}

	public void setChargetype(String chargetype) {
		this.chargetype = chargetype;
	}
	/* @OneToMany (fetch = FetchType.LAZY, mappedBy = "charge_map")
	public Set<ChargeType> getChargeTypes() {
		return ChargeTypes;
	}

	public void setChargeTypes(Set<ChargeType> chargeTypes) {
		ChargeTypes = chargeTypes;
	}
	*/
	

	
	
}
