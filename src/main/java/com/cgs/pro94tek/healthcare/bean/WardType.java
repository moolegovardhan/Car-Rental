package com.cgs.pro94tek.healthcare.bean;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table (name = "wardtype", uniqueConstraints = { @UniqueConstraint (columnNames = "ID"),
		@UniqueConstraint (columnNames = "wardtype") })
public class WardType {

	private Long     id;
	@ManyToOne
	private String   wardtype;
	private String   status;
	private String officeid;
	private String   description;
	private String   createdBy;
	private Date     createdDate;
	private Set<Ward> ward;

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO, generator = "ID_seq")
	@SequenceGenerator (sequenceName = "ward_id_seq", name = "ID_seq")
	@Column (name = "id", unique = true, nullable = false)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column (name = "wardtype", unique = true, nullable = false)
	public String getWardtype() {
		return wardtype;
	}
	
	public void setWardtype(String wardtype) {
		this.wardtype = wardtype;
	}

	@Column (name = "status", nullable = true)
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	@Column (name = "description", nullable = true)
	public String getDescription() {
		return description;
	}
	

	@Column(name = "officeid", length=10)
	public String getOfficeid() {
		return officeid;
	}
	public void setOfficeid(String officeid) {
		this.officeid = officeid;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Column (name = "created_by", nullable = false)
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	@Column (name = "created_date", nullable = false)
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn (name = "wardtype")
	public Set<Ward> getWard() {
		return ward;
	}
	public void setWard(Set<Ward> ward) {
		this.ward = ward;
	}


	
	



}
