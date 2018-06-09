package com.cgs.pro94tek.healthcare.bean;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the patientvoucher database table.
 * 
 */
@Entity
@NamedQuery(name="Patientvoucher.findAll", query="SELECT p FROM Patientvoucher p")
public class Patientvoucher implements Serializable {
	private static final long serialVersionUID = 1L;
	private BigInteger id;
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

	public Patientvoucher() {
	}


	@Id
	@TableGenerator( name = "appSeqStore", table = "uniqueidtable", pkColumnName = "tablename",
	 pkColumnValue = "USER_PATIENT_VOUCHER", valueColumnName = "latestid",
	 initialValue = 1, allocationSize = 1 )
    @GeneratedValue( strategy = GenerationType.TABLE, generator = "appSeqStore" )
	public BigInteger getId() {
		return this.id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}


	public String getCardtype() {
		return this.cardtype;
	}

	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}


	@Temporal(TemporalType.DATE)
	public Date getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}


	public String getCreatedby() {
		return this.createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}


	@Temporal(TemporalType.DATE)
	public Date getExpirydate() {
		return this.expirydate;
	}

	public void setExpirydate(Date expirydate) {
		this.expirydate = expirydate;
	}


	public String getInsttype() {
		return this.insttype;
	}

	public void setInsttype(String insttype) {
		this.insttype = insttype;
	}


	public BigInteger getPatientid() {
		return this.patientid;
	}

	public void setPatientid(BigInteger patientid) {
		this.patientid = patientid;
	}


	public String getPercent() {
		return this.percent;
	}

	public void setPercent(String percent) {
		this.percent = percent;
	}


	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	public String getVouchercount() {
		return this.vouchercount;
	}

	public void setVouchercount(String vouchercount) {
		this.vouchercount = vouchercount;
	}


	public String getVouchername() {
		return this.vouchername;
	}

	public void setVouchername(String vouchername) {
		this.vouchername = vouchername;
	}

}