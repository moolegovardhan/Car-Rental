package com.cgs.pro94tek.healthcare.bean;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the user_token database table.
 * 
 */
@Entity
@Table(name="user_token")
public class UserToken implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column (name = "ID", unique = true, nullable = false)
	@TableGenerator( name = "appSeqStore", table = "uniqueidtable", pkColumnName = "tablename",
					 pkColumnValue = "USER_TOKEN", valueColumnName = "latestid",
					 initialValue = 1, allocationSize = 1 )
	@GeneratedValue( strategy = GenerationType.TABLE, generator = "appSeqStore" )
	private BigInteger id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=true)
	private Date dateoflogin;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=true)
	private Date lasttransaction;

	@Column(nullable=true, length=1000)
	private String token;

	@Column(nullable=true)
	private Long userid;
	
	public UserToken() {
	}

	public BigInteger getId() {
		return this.id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public Date getDateoflogin() {
		return this.dateoflogin;
	}

	public void setDateoflogin(Date dateoflogin) {
		this.dateoflogin = dateoflogin;
	}

	public Date getLasttransaction() {
		return this.lasttransaction;
	}

	public void setLasttransaction(Date lasttransaction) {
		this.lasttransaction = lasttransaction;
	}

	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Long getUserid() {
		return this.userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

}