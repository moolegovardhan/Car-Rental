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
@Table(name="company", uniqueConstraints = { @UniqueConstraint (columnNames = {"ID","officeId"}) }) 
public class Company {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name = "ID", unique = true, nullable = false)
	private Long id;

	@Column(name="displayName", length=100)
	private String displayName;

	@Column(name="signatureInNameOf", length=20)
	private String signatureInNameOf;

	@Column(name="mailingaddress", length=50)
	private String mailingaddress;

	@Column(name="billingaddress", length=20)
	private String billingaddress;

	@Column(name="corporateaddress", length=20)
	private String corporateaddress;

	@Column(name="dateOfIncorporation")
	private Date dateOfIncorporation ;

	@Column(name="logo", length=100)
	private String logo;
	
	@Column(name="mobileNo", length=20)
	private String mobileNo;
	
	@Column(name="landlineNo", length=20)
	private String landlineNo;
	
	@Column(name="email", length=20)
	private String email;

	@Column(name="createdBy", length=20)
	private String createdBy;

	@Temporal(TemporalType.DATE)
	@Column(name="createdDate")
	private Date createdDate;

	@Column(name="isDealer", length=20)
	private String isDealer;

	@Column(name="isRetailer", length=20)
	private String isRetailer;

	@Column(name="setupdate")
	private Date setupdate;

	@Column(name="status", length=20)
	private String status;
	
	@Column(name="officeId", length=20)
	private String officeId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getSignatureInNameOf() {
		return signatureInNameOf;
	}

	public void setSignatureInNameOf(String signatureInNameOf) {
		this.signatureInNameOf = signatureInNameOf;
	}

	public String getMailingaddress() {
		return mailingaddress;
	}

	public void setMailingaddress(String mailingaddress) {
		this.mailingaddress = mailingaddress;
	}

	public String getBillingaddress() {
		return billingaddress;
	}

	public void setBillingaddress(String billingaddress) {
		this.billingaddress = billingaddress;
	}

	public String getCorporateaddress() {
		return corporateaddress;
	}

	public void setCorporateaddress(String corporateaddress) {
		this.corporateaddress = corporateaddress;
	}

	public Date getDateOfIncorporation() {
		return dateOfIncorporation;
	}

	public void setDateOfIncorporation(Date dateOfIncorporation) {
		this.dateOfIncorporation = dateOfIncorporation;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getLandlineNo() {
		return landlineNo;
	}

	public void setLandlineNo(String landlineNo) {
		this.landlineNo = landlineNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getIsDealer() {
		return isDealer;
	}

	public void setIsDealer(String isDealer) {
		this.isDealer = isDealer;
	}

	public String getIsRetailer() {
		return isRetailer;
	}

	public void setIsRetailer(String isRetailer) {
		this.isRetailer = isRetailer;
	}

	public Date getSetupdate() {
		return setupdate;
	}

	public void setSetupdate(Date setupdate) {
		this.setupdate = setupdate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOfficeId() {
		return officeId;
	}

	public void setOfficeId(String officeId) {
		this.officeId = officeId;
	}

	
	
}
