package com.cgs.pro94tek.healthcare.helper;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.cgs.pro94tek.healthcare.bean.Patientvoucher;
import com.cgs.pro94tek.healthcare.bean.User;
import com.cgs.pro94tek.healthcare.modal.PatientVoucherModal;
import com.cgs.pro94tek.healthcare.modal.UserModal;

public class UserHelper {

	public UserModal createUserModal(User myuser){
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy"); 
		UserModal myusermodal=new UserModal();
		if(myuser.getFirstName() != null)
		myusermodal.setFirstName(myuser.getFirstName());
		if(myuser.getLastName() != null)
		myusermodal.setLastName(myuser.getLastName());
		if(myuser.getMiddleName() != null)
		myusermodal.setMiddleName(myuser.getMiddleName());
		myusermodal.setFullName(myuser.getFirstName() + myuser.getLastName()+myuser.getMiddleName());
		if(myuser.getPassword() != null)
		myusermodal.setPassword(myuser.getPassword());
		if(myuser.getUsername() != null)
		myusermodal.setUsername(myuser.getUsername());
		if(myuser.getAddress1() != null)
		myusermodal.setAddress1(myuser.getAddress1());
		if(myuser.getAddress2() != null)
		myusermodal.setAddress2(myuser.getAddress2());
		if(myuser.getMobile() != null)
		myusermodal.setMobile(myuser.getMobile());
		if(myuser.getDob() != null)
		myusermodal.setDob(df.format(myuser.getDob()));
		if(myuser.getProfession() != null)
		myusermodal.setProfession(myuser.getProfession());
		if(myuser.getOfficeid() != null)
		myusermodal.setOfficeid(myuser.getOfficeid());
		if(myuser.getCreatedby() != null)
		myusermodal.setCreatedby(myuser.getCreatedby());
		if(myuser.getCreateddate() != null)
		myusermodal.setCreateddate(df.format(myuser.getCreateddate()));
		if(myuser.getStatus() != null)
		myusermodal.setStatus(myuser.getStatus());
		if(myuser.getId() != null)
		myusermodal.setId(myuser.getId());
		return myusermodal;
	}

	public User createUser(UserModal userModal){
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy"); 
		User user=new User();
		user.setFirstName(userModal.getFirstName());
		user.setLastName(userModal.getLastName());
		user.setMiddleName(userModal.getMiddleName());
		user.setFullName(userModal.getFirstName() + userModal.getLastName() + userModal.getMiddleName());
		user.setPassword(userModal.getPassword());
		user.setUsername(userModal.getUsername());
		user.setAddress1(userModal.getAddress1());
		user.setAddress2(userModal.getAddress2());
		user.setMobile(userModal.getMobile());
		user.setDob(new Date());
		user.setProfession(userModal.getProfession());
		user.setOfficeid(userModal.getOfficeid());
		user.setCreatedby(userModal.getCreatedby());
		user.setCreateddate(new Date());
		user.setStatus(userModal.getStatus());
		user.setId(userModal.getId());
		return user;
	}

	public PatientVoucherModal createPatientVoucherModal(Patientvoucher patientVoucher){
		PatientVoucherModal patientVoucherModal = new PatientVoucherModal();

		if(patientVoucher.getCardtype() != null)
			patientVoucherModal.setCardtype(patientVoucher.getCardtype());
		if(patientVoucher.getCreatedate() != null)
			patientVoucherModal.setCreatedate(patientVoucher.getCreatedate());
		if(patientVoucher.getCreatedby() != null)
			patientVoucherModal.setCreatedby(patientVoucher.getCreatedby());
		if(patientVoucher.getExpirydate() != null)
			patientVoucherModal.setExpirydate(patientVoucher.getExpirydate());
		if(patientVoucher.getId() != null)
			patientVoucherModal.setId(String.valueOf(patientVoucher.getId()));
		if(patientVoucher.getInsttype() != null)
			patientVoucherModal.setInsttype(patientVoucher.getInsttype());
		if(patientVoucher.getPatientid() != null)
			patientVoucherModal.setPatientid(patientVoucher.getPatientid());
		if(patientVoucher.getPercent() != null)
			patientVoucherModal.setPercent(patientVoucher.getPercent());
		if(patientVoucher.getStatus() != null)
			patientVoucherModal.setStatus(patientVoucher.getStatus());
		if(patientVoucher.getVouchercount() != null)
			patientVoucherModal.setVouchercount(patientVoucher.getVouchercount());
		if(patientVoucher.getVouchername() != null)
			patientVoucherModal.setVouchername(patientVoucher.getVouchername());

		return patientVoucherModal;
	}




}
