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
	@JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
	@Table(name="tax", uniqueConstraints = { @UniqueConstraint (columnNames = {"ID","officeId"}) }) 
	public class Tax implements Serializable{

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column (name = "ID", unique = true, nullable = false)
		private Long id;

		@Column(name="taxname", length=100)
		private String taxname;

		@Column(name="taxdesc", length=50)
		private String taxdesc;

		@Column(name="taxrate", length=20)
		private String taxrate;

		@Column(name="createdBy", length=20)
		private String createdBy;

		@Temporal(TemporalType.DATE)
		@Column(name="createdDate")
		private Date createdDate;

		@Column(name="status", length=20)
		private String status;

		@Column(name="officeId", length=20)
		private Long officeid;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getTaxname() {
			return taxname;
		}

		public void setTaxname(String taxname) {
			this.taxname = taxname;
		}

		public String getTaxdesc() {
			return taxdesc;
		}

		public void setTaxdesc(String taxdesc) {
			this.taxdesc = taxdesc;
		}

		public String getTaxrate() {
			return taxrate;
		}

		public void setTaxrate(String taxrate) {
			this.taxrate = taxrate;
		}

		public String getCreatedBy() {
			return createdBy;
		}

		public void setCreatedBy(String createdBy) {
			this.createdBy = createdBy;
		}

		public Date getCreatedDate() {
			return createdDate;
		}

		public void setCreatedDate(Date createdDate) {
			this.createdDate = createdDate;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public Long getOfficeid() {
			return officeid;
		}

		public void setOfficeid(Long officeid) {
			this.officeid = officeid;
		}
		
		

	}


