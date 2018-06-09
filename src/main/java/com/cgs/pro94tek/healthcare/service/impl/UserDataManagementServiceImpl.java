package com.cgs.pro94tek.healthcare.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgs.pro94tek.healthcare.bean.Patientvoucher;
import com.cgs.pro94tek.healthcare.bean.User;
import com.cgs.pro94tek.healthcare.dataaccess.dao.IUserDAO;
import com.cgs.pro94tek.healthcare.exeception.PMSException;
import com.cgs.pro94tek.healthcare.helper.UserHelper;
import com.cgs.pro94tek.healthcare.modal.PatientVoucherModal;
import com.cgs.pro94tek.healthcare.modal.UserModal;
import com.cgs.pro94tek.healthcare.service.IUserDataManagementService;
import com.cgs.pro94tek.utils.CommonUtils;

@Service("userDataManagementService")
public class UserDataManagementServiceImpl implements
		IUserDataManagementService {

	private static final Logger logger = LoggerFactory
			.getLogger(UserDataManagementServiceImpl.class);

	@Autowired
	private IUserDAO userdao;

	@Override
	public UserModal authenticateUser(String username, String password)
			throws PMSException {
		UserModal userModal = new UserModal();
		try {
			if (username != null && username.length() > 0 && password != null && password.length() > 0){
				String encryptPassword = CommonUtils.encryptPassword(password);
				User user = userdao.authenticateUser(username, encryptPassword);
				if(user != null){
					userModal = new UserHelper().createUserModal(user);	
				}else{
					logger.debug("User Validation Failed. Invalid UserName and Password");
					//throw new PMSException(10,"User Validation Failed. Invalid UserName and Password");
					return null;
				}
			}else {
				logger.debug("UserName and Password should not be null");
				throw new PMSException(10,"UserName and Password should not be null");
			}
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("Error : " + e.getMessage());
			throw new PMSException(10, e);
		}
		return userModal;
	}

	@Override
	public User fetchUserInformation(String username) throws PMSException {

		return userdao.fetchUserInformation(username);
	}

	@Override
	public List<PatientVoucherModal> fetchPatientVoucherDetails(Integer userid)
			throws PMSException {

		List<PatientVoucherModal> patientVoucherModal = new ArrayList<PatientVoucherModal>();
		PatientVoucherModal voucherModal = new PatientVoucherModal();

		List<Patientvoucher> patientVoucher = userdao
				.fetchPatientVoucherDetails(userid);

		UserHelper userHelper = new UserHelper();

		if (patientVoucher != null && patientVoucher.size() > 0) {
			for (Patientvoucher voucher : patientVoucher) {
				if (voucher != null)
					voucherModal = userHelper
							.createPatientVoucherModal(voucher);

				patientVoucherModal.add(voucherModal);
				voucherModal = new PatientVoucherModal();
			}
		}

		return patientVoucherModal;
	}

	@Override
	public void createOrUpdateUser(User userObj) throws PMSException {
		String encryptPassword = CommonUtils.encryptPassword(userObj.getPassword());
		userObj.setPassword(encryptPassword);		
		userdao.createOrUpdateUser(userObj);
	}

}
