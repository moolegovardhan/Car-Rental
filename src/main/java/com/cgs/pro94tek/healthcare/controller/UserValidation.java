package com.cgs.pro94tek.healthcare.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cgs.pro94tek.healthcare.bean.User;
import com.cgs.pro94tek.healthcare.exeception.PMSException;
import com.cgs.pro94tek.healthcare.helper.UserHelper;
import com.cgs.pro94tek.healthcare.modal.PatientVoucherModal;
import com.cgs.pro94tek.healthcare.modal.UserModal;
import com.cgs.pro94tek.healthcare.service.IUserDataManagementService;
import com.cgs.pro94tek.utils.CommonUtils;
import com.cgs.pro94tek.utils.InventoryRequestResponse;
import com.cgs.pro94tek.utils.InventoryURIConstant;
import com.cgs.pro94tek.utils.ResponseMessages;

@Controller
public class UserValidation {

	@Autowired
	IUserDataManagementService userDataManagementService;

	InventoryRequestResponse response = new InventoryRequestResponse();

	private static final Logger logger = LoggerFactory.getLogger(UserValidation.class);
	CommonUtils commonUtils = new CommonUtils();
	ResponseMessages message = new ResponseMessages();
	InventoryURIConstant inventoryURIConstants = new InventoryURIConstant();

	@RequestMapping(value = InventoryURIConstant.GET_MYUSER_AUTHONTICATION, method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody InventoryRequestResponse authenticateUser(@PathVariable("username") String username, @PathVariable("password") String password) {
		logger.info("username . :l password - " + username + " : " + password);
		UserModal userModal = new UserModal();
		try {
			userModal = userDataManagementService.authenticateUser(username,password);
			if (userModal != null) {
				response = commonUtils.createResponseData(userModal.getUsername(), message.GENERALL_FETCH_SUCCESS, message.SUCCESS, "1", userModal);
			} else {
				response = commonUtils.createResponseData("User Validation Failed", message.GENERALL_EXCEPTION, message.FAIL, "1", "Invalid UserName and Password");
			}
		} catch (Exception e) {
			logger.error(" In message Error" + e.getMessage());
			logger.error(" In cause Error" + e.getCause());
			response = commonUtils.createResponseData(userModal.getUsername(),
					message.GENERALL_EXCEPTION, message.FAIL, "1",
					e.getMessage());
		}
		return response;
	}

	@RequestMapping(value = InventoryURIConstant.GET_PATIENT_VOUCHER_DETAILS, method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody InventoryRequestResponse fetchPatientVoucherDetails(
			@PathVariable("userid") String userid) {
		logger.info("userid . : " + userid);
		List<PatientVoucherModal> patientVoucherModal = new ArrayList<PatientVoucherModal>();
		try {
			patientVoucherModal = userDataManagementService
					.fetchPatientVoucherDetails(Integer.parseInt(userid));
			response = commonUtils.createResponseData(
					"Patient Voucher Details", message.GENERALL_FETCH_SUCCESS,
					message.SUCCESS,
					String.valueOf(patientVoucherModal.size()),
					patientVoucherModal);
		} catch (PMSException e) {
			// TODO Auto-generated catch block
			logger.error(" In message Error" + e.getMessage());
			logger.error(" In cause Error" + e.getCause());
			e.printStackTrace();
			response = commonUtils.createResponseData(
					"Exception in fetching Patient Voucher Details",
					message.GENERALL_EXCEPTION, message.FAIL, "0",
					e.getMessage());
		}
		return response;
	}

	// ------------------------------------------------------insert-----------------------------------
	@RequestMapping(value = InventoryURIConstant.CREATE_USER_DETAILS, method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody InventoryRequestResponse createUserNamePassword(
			@RequestBody UserModal userModal) {
		try {
			System.out.println("UserName and Password............."+ userModal.getUsername() + " -  "
					+ userModal.getPassword());
			UserHelper userHelper = new UserHelper();
			User userObj = userHelper.createUser(userModal);
			userDataManagementService.createOrUpdateUser(userObj);
			response = commonUtils.createResponseData("Done",
					ResponseMessages.GENERALL_INSERT_SUCCESS,
					ResponseMessages.SUCCESS, "1", "--");
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			logger.error(e.getMessage());
			response = commonUtils.createResponseData(e.getMessage(),
					ResponseMessages.GENERALL_EXCEPTION, ResponseMessages.FAIL,
					"0", "--");
		}
		return response;
	}

}
