package com.cgs.pro94tek.healthcare.modal;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;


public class PatientVoucherModal implements Serializable{

	
	private static final long serialVersionUID = 2315555577290373660L;
	
	private String id;
	private String cardtype;
	private Date createdate;
	private String createdby;
	private Date expirydate;
	private String insttype;
	private BigInteger patientid;
	private String percent;
	private String status;
	private String vouchercount;
	private String vouchername;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCardtype() {
		return cardtype;
	}
	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public String getCreatedby() {
		return createdby;
	}
	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}
	public Date getExpirydate() {
		return expirydate;
	}
	public void setExpirydate(Date expirydate) {
		this.expirydate = expirydate;
	}
	public String getInsttype() {
		return insttype;
	}
	public void setInsttype(String insttype) {
		this.insttype = insttype;
	}
	public BigInteger getPatientid() {
		return patientid;
	}
	public void setPatientid(BigInteger patientid) {
		this.patientid = patientid;
	}
	public String getPercent() {
		return percent;
	}
	public void setPercent(String percent) {
		this.percent = percent;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getVouchercount() {
		return vouchercount;
	}
	public void setVouchercount(String vouchercount) {
		this.vouchercount = vouchercount;
	}
	public String getVouchername() {
		return vouchername;
	}
	public void setVouchername(String vouchername) {
		this.vouchername = vouchername;
	}
	
	
     
}
