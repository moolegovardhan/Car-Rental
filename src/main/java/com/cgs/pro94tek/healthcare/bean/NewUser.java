package com.cgs.pro94tek.healthcare.bean;

import java.io.Serializable;
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
@Table(name="user", uniqueConstraints = { @UniqueConstraint (columnNames = "ID") })
public class NewUser implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name = "ID", unique = true, nullable = false)	
	private Long	id ;
	
	@Column (name = "username",length = 100 )
	private String 	 username ;
	@Column (name = "password",length=100)
	private String	  password;
	@Column (name = "email", length=100)
	private String	email;
	@Column (name = "mobile", length=100)
	private String	  mobile;
	@Column (name = "altmobile",length=100)
	private String	 altmobile; 
	@Column (name = "landline",length=100)
	private String	  landline ;	  
	@Column (name = "userrole", length=100)
	private String	  userrole ;
	@Column (name = "address", length=100)
	private String	  address;
	@Column (name = "name", length=100)
	private String	  name;
	@Column (name = "middlename", length=100)
	private String	  middlename;
	@Column (name = "lastname", length=100)
	private String	  lastname;
	@Column (name = "firstname", length=100)
	private String	  firstname;
	@Temporal(TemporalType.DATE)
	@Column(name="dob")
	private Date	  dob ;
	@Column (name = "gender", length=100)
	private String	  gender;
	@Column (name = "city", length=100)
	private String	  city;
	@Column (name = "state", length=100)
	private String	  state;
	@Column (name = "zipcode", length=100)
	private String	  zipcode;
	@Column (name = "aadharcard", length=100)
	private String	  aadharcard;
	@Column (name = "addressline1", length=100)
	private String	  addressline1;
	@Column (name = "addressline2", length=100)
	private String	 addressline2;
	@Column (name = "district", length=100)
	private String	district;
	@Column (name = "officeid", length=100)
	private Long	 officeid;
	@Column (name = "department", length=100)
	private String	 department;
	@Column (name = "createdby", length=100)
	private String	 createdby;
	@Temporal(TemporalType.DATE)
	@Column(name="createddate")
	private Date	 createddate;
	@Column (name = "status", length=100)
	private String	status;
	@Column (name = "age", length=100)
	private int	 age;
	@Column (name = "doctorid", length=100)
	private String	doctorid;
	@Column (name = "credits", length=100)
	private int	 credits;
	@Column (name = "policyid", length=100)
	private String	 policyid;
	@Column (name = "policytype", length=100)
	private String	 policytype;
	@Column (name = "otp", length=100)
	private int	  otp  ;
	@Column (name = "udid", length=100)	
	private String	 udid;
	@Column (name = "cardtype", length=100)
	private String	 cardtype;
	@Column (name = "cardamount", length=100)
	private String	 cardamount;
	@Column (name = "salesperson", length=100)
	private String	  salesperson;
	@Column (name = "totalamount", length=100)
	private int	  totalamount;
	@Column (name = "wallet", length=100)
	private String	  wallet;
	@Column (name = "registeredfrom", length=100)
	private String	 registeredfrom;
	@Column (name = "insttype", length=100)
	private String	insttype;
	@Column (name = "cardexpiry", length=100)
	private String	 cardexpiry;
	@Column (name = "patientuniqueid", length=100)
	private String	  patientuniqueid;
	@Column (name = "quickregister", length=100)
	private String	quickregister;
	@Column (name = "primarymemberid", length=100)
	private String	 primarymemberid;
	@Column (name = "cardpayment", length=100)
	private Date	 cardpayment;
	@Column (name = "doctorfee", length=100)
	private String	 doctorfee;
	@Column (name = "imagepath", length=100)
	private String	  imagepath;
	@Column (name = "doctordesignation", length=100)
	private String	  doctordesignation;
	@Column (name = "profession", length=100)
	private String profession;
	
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAltmobile() {
		return altmobile;
	}
	public void setAltmobile(String altmobile) {
		this.altmobile = altmobile;
	}
	public String getLandline() {
		return landline;
	}
	public void setLandline(String landline) {
		this.landline = landline;
	}
	public String getUserrole() {
		return userrole;
	}
	public void setUserrole(String userrole) {
		this.userrole = userrole;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMiddlename() {
		return middlename;
	}
	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getAadharcard() {
		return aadharcard;
	}
	public void setAadharcard(String aadharcard) {
		this.aadharcard = aadharcard;
	}
	public String getAddressline1() {
		return addressline1;
	}
	public void setAddressline1(String addressline1) {
		this.addressline1 = addressline1;
	}
	public String getAddressline2() {
		return addressline2;
	}
	public void setAddressline2(String addressline2) {
		this.addressline2 = addressline2;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public Long getOfficeid() {
		return officeid;
	}
	public void setOfficeid(Long officeid) {
		this.officeid = officeid;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDoctorid() {
		return doctorid;
	}
	public void setDoctorid(String doctorid) {
		this.doctorid = doctorid;
	}
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
	public String getPolicyid() {
		return policyid;
	}
	public void setPolicyid(String policyid) {
		this.policyid = policyid;
	}
	public String getPolicytype() {
		return policytype;
	}
	public void setPolicytype(String policytype) {
		this.policytype = policytype;
	}
	public int getOtp() {
		return otp;
	}
	public void setOtp(int otp) {
		this.otp = otp;
	}
	public String getUdid() {
		return udid;
	}
	public void setUdid(String udid) {
		this.udid = udid;
	}
	public String getCardtype() {
		return cardtype;
	}
	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}
	public String getCardamount() {
		return cardamount;
	}
	public void setCardamount(String cardamount) {
		this.cardamount = cardamount;
	}
	public String getSalesperson() {
		return salesperson;
	}
	public void setSalesperson(String salesperson) {
		this.salesperson = salesperson;
	}
	public int getTotalamount() {
		return totalamount;
	}
	public void setTotalamount(int totalamount) {
		this.totalamount = totalamount;
	}
	public String getWallet() {
		return wallet;
	}
	public void setWallet(String wallet) {
		this.wallet = wallet;
	}
	public String getRegisteredfrom() {
		return registeredfrom;
	}
	public void setRegisteredfrom(String registeredfrom) {
		this.registeredfrom = registeredfrom;
	}
	public String getInsttype() {
		return insttype;
	}
	public void setInsttype(String insttype) {
		this.insttype = insttype;
	}
	public String getCardexpiry() {
		return cardexpiry;
	}
	public void setCardexpiry(String cardexpiry) {
		this.cardexpiry = cardexpiry;
	}
	public String getPatientuniqueid() {
		return patientuniqueid;
	}
	public void setPatientuniqueid(String patientuniqueid) {
		this.patientuniqueid = patientuniqueid;
	}
	public String getQuickregister() {
		return quickregister;
	}
	public void setQuickregister(String quickregister) {
		this.quickregister = quickregister;
	}
	public String getPrimarymemberid() {
		return primarymemberid;
	}
	public void setPrimarymemberid(String primarymemberid) {
		this.primarymemberid = primarymemberid;
	}
	public Date getCardpayment() {
		return cardpayment;
	}
	public void setCardpayment(Date cardpayment) {
		this.cardpayment = cardpayment;
	}
	public String getDoctorfee() {
		return doctorfee;
	}
	public void setDoctorfee(String doctorfee) {
		this.doctorfee = doctorfee;
	}
	public String getImagepath() {
		return imagepath;
	}
	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}
	public String getDoctordesignation() {
		return doctordesignation;
	}
	public void setDoctordesignation(String doctordesignation) {
		this.doctordesignation = doctordesignation;
	}
	
}
