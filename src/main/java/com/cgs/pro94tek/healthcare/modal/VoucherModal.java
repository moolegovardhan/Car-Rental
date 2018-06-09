package com.cgs.pro94tek.healthcare.modal;

import java.io.Serializable;
import java.util.Date;

public class VoucherModal implements Serializable{
	
	
	
	private static final long serialVersionUID = 7405501246740669340L;
	private String id;
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCardname() {
		return cardname;
	}
	public void setCardname(String cardname) {
		this.cardname = cardname;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getCreatedby() {
		return createdby;
	}
	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}
	public Date getCreateddate() {
		return createddate;
	}
	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}
	public Date getEnddate() {
		return enddate;
	}
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	public String getInsttype() {
		return insttype;
	}
	public void setInsttype(String insttype) {
		this.insttype = insttype;
	}
	public String getPercent() {
		return percent;
	}
	public void setPercent(String percent) {
		this.percent = percent;
	}
	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getVname() {
		return vname;
	}
	public void setVname(String vname) {
		this.vname = vname;
	}
	public String getVtype() {
		return vtype;
	}
	public void setVtype(String vtype) {
		this.vtype = vtype;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}
