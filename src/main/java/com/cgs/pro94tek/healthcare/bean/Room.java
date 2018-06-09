package com.cgs.pro94tek.healthcare.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Room {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "room_id", unique = true, nullable = false)
	private Long id;
	
	@Column (name = "roomtype", nullable = true)
	private String roomtype;
	
	@Column(name="roomname", length=100)
	private String roomname;
	
	@Column(name = "officeid", length=10)
	private String officeid;
	
	@Column(name = "totalrooms",length=10, nullable = true)
	private String totalrooms;
	
	@Column(name = "roomcost",length=10, nullable = true)
	private String roomcost;
	
	@Column (name = "status", nullable = false)
	private String status;
	
	@Column (name = "createdDate", nullable = false)
	private Date createdDate;
	
	@Column (name = "created_by", nullable = false)
	private String createdBy;
	
	@Column (name = "discount", nullable = false)
	private String discount;
	
	@Column (name = "bedcost", nullable = false)
	private String bedcost;
	
	@Column (name = "finalprice", nullable = false)
	private String finalprice;
	
	@Column (name = "charges", nullable = false)
	private String charges;
	
	@Column(name = "totaloccupied",length=10, nullable = true)
	private String totaloccupied;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRoomtype() {
		return roomtype;
	}
	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}
	public String getRoomname() {
		return roomname;
	}
	public void setRoomname(String roomname) {
		this.roomname = roomname;
	}
	public String getOfficeid() {
		return officeid;
	}
	public void setOfficeid(String officeid) {
		this.officeid = officeid;
	}
	public String getTotalrooms() {
		return totalrooms;
	}
	public void setTotalrooms(String totalrooms) {
		this.totalrooms = totalrooms;
	}
	public String getRoomcost() {
		return roomcost;
	}
	public void setRoomcost(String roomcost) {
		this.roomcost = roomcost;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
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
	public String getFinalprice() {
		return finalprice;
	}
	public void setFinalprice(String finalprice) {
		this.finalprice = finalprice;
	}
	public String getCharges() {
		return charges;
	}
	public void setCharges(String charges) {
		this.charges = charges;
	}
	public String getTotaloccupied() {
		return totaloccupied;
	}
	public void setTotaloccupied(String totaloccupied) {
		this.totaloccupied = totaloccupied;
	}
	
	

}
