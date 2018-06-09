package com.cgs.pro94tek.healthcare.modal;



public class TaxModal {

	private Long id;
	private String taxname;
	private String taxdesc;
	private String taxrate;
	private String createdDate;
	private String createdby;
	private String status;
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
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
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
	public Long getOfficeid() {
		return officeid;
	}
	public void setOfficeid(Long officeid) {
		this.officeid = officeid;
	}
	

}
