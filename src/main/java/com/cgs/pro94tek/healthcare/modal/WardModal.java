package com.cgs.pro94tek.healthcare.modal;

import java.util.Set;

import com.cgs.pro94tek.healthcare.bean.WardType;

public class WardModal {
	
	private Long id;
	private String wardname;
	private String wardtype;
	private String officeid;
	private String totaloccupied;
	private String bedscount;
	private String status;
	private String createdDate;
	private String createdBy;
	private String discount;
	private String bedcost;
	private String finalcost;
	private String chargescost;
	private Set<WardType> wardtypes ;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getWardname() {
		return wardname;
	}
	public void setWardname(String wardname) {
		this.wardname = wardname;
	}
	public String getWardtype() {
		return wardtype;
	}
	public void setWardtype(String wardtype) {
		this.wardtype = wardtype;
	}
	public String getOfficeid() {
		return officeid;
	}
	public void setOfficeid(String officeid) {
		this.officeid = officeid;
	}
	public String getTotaloccupied() {
		return totaloccupied;
	}
	public void setTotaloccupied(String totaloccupied) {
		this.totaloccupied = totaloccupied;
	}
	public String getBedscount() {
		return bedscount;
	}
	public void setBedscount(String bedscount) {
		this.bedscount = bedscount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	public String getBedcost() {
		return bedcost;
	}
	public void setBedcost(String bedcost) {
		this.bedcost = bedcost;
	}
	public String getFinalcost() {
		return finalcost;
	}
	public void setFinalcost(String finalcost) {
		this.finalcost = finalcost;
	}
	public String getChargescost() {
		return chargescost;
	}
	public void setChargescost(String chargescost) {
		this.chargescost = chargescost;
	}
	public Set<WardType> getWardtypes() {
		return wardtypes;
	}
	public void setWardtypes(Set<WardType> wardtypes) {
		this.wardtypes = wardtypes;
	}
	
	
	

}
