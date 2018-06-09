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
@Table(name="school_details", uniqueConstraints = { @UniqueConstraint (columnNames = "ID"),
		   @UniqueConstraint (columnNames = "schoolid")})
							  
public class SchoolDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name = "ID", unique = true, nullable = false)
	private Long id;
	
	@Column(name="schoolid", length=20)
	private String schoolid;
	
	@Column(name="classname", length=20)
	private String classname;
	
	@Column(name="strength", length=20)
	private String strength;
	
	@Column(name="status", length=20)
	private String status;
	
	@Temporal(TemporalType.DATE)
	@Column(name="createddate")
	private Date createddate;

	@Column(name="createdby", length=20)
	private String createdby;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="school_start_time")
	private String schoolStartTime;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="school_end_time")
	private String schoolEndTime;
	
	@Column(name="teachername", length=20)
	private String teacherName;
	
	@Column(name="classteacherid", length=20)
	private String classTeacherId;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="starttime")
	private String starttime;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="starttime")
	private String endtime;
	
	public SchoolDetails() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSchoolid() {
		return schoolid;
	}

	public void setSchoolid(String schoolid) {
		this.schoolid = schoolid;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public String getStrength() {
		return strength;
	}

	public void setStrength(String strength) {
		this.strength = strength;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public String getSchoolStartTime() {
		return schoolStartTime;
	}

	public void setSchoolStartTime(String schoolStartTime) {
		this.schoolStartTime = schoolStartTime;
	}

	public String getSchoolEndTime() {
		return schoolEndTime;
	}

	public void setSchoolEndTime(String schoolEndTime) {
		this.schoolEndTime = schoolEndTime;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getClassTeacherId() {
		return classTeacherId;
	}

	public void setClassTeacherId(String classTeacherId) {
		this.classTeacherId = classTeacherId;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	
}
