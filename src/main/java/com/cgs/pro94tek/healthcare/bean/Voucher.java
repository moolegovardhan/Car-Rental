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
 * The persistent class for the voucher database table.
 * 
 */
@Entity
@NamedQuery(name="Voucher.findAll", query="SELECT v FROM Voucher v")
public class Voucher implements Serializable {
	private static final long serialVersionUID = 1L;
	private BigInteger id;
	private String cardname;
	private String count;
	private String createdby;
	private Date createddate;
	private Date enddate;
	private String insttype;
	private String percent;
	private Date startdate;
	private String status;
	private String vname;
	private String vtype;

	public Voucher() {
	}


	@Id
	@TableGenerator( name = "appSeqStore", table = "uniqueidtable", pkColumnName = "tablename",
	 pkColumnValue = "USER_VOUCHER", valueColumnName = "latestid",
	 initialValue = 1, allocationSize = 1 )
    @GeneratedValue( strategy = GenerationType.TABLE, generator = "appSeqStore" )
	public BigInteger getId() {
		return this.id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}


	public String getCardname() {
		return this.cardname;
	}

	public void setCardname(String cardname) {
		this.cardname = cardname;
	}


	public String getCount() {
		return this.count;
	}

	public void setCount(String count) {
		this.count = count;
	}


	public String getCreatedby() {
		return this.createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}


	@Temporal(TemporalType.DATE)
	public Date getCreateddate() {
		return this.createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}


	@Temporal(TemporalType.DATE)
	public Date getEnddate() {
		return this.enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}


	public String getInsttype() {
		return this.insttype;
	}

	public void setInsttype(String insttype) {
		this.insttype = insttype;
	}


	public String getPercent() {
		return this.percent;
	}

	public void setPercent(String percent) {
		this.percent = percent;
	}


	@Temporal(TemporalType.DATE)
	public Date getStartdate() {
		return this.startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}


	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	public String getVname() {
		return this.vname;
	}

	public void setVname(String vname) {
		this.vname = vname;
	}


	public String getVtype() {
		return this.vtype;
	}

	public void setVtype(String vtype) {
		this.vtype = vtype;
	}

}