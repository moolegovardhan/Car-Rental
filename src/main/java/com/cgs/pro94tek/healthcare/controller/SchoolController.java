package com.cgs.pro94tek.healthcare.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cgs.pro94tek.healthcare.bean.School;
import com.cgs.pro94tek.healthcare.exeception.PMSException;
import com.cgs.pro94tek.healthcare.helper.SchoolHelper;
import com.cgs.pro94tek.healthcare.modal.SchoolModal;
import com.cgs.pro94tek.healthcare.service.ISchoolDataRetrivalService;
import com.cgs.pro94tek.utils.CommonUtils;
import com.cgs.pro94tek.utils.InventoryRequestResponse;
import com.cgs.pro94tek.utils.InventoryURIConstant;
import com.cgs.pro94tek.utils.ResponseMessages;

@Controller
public class SchoolController {

	@Autowired 
	ISchoolDataRetrivalService iSchoolDataRetrivalService;

	private static final Logger logger = LoggerFactory.getLogger(SchoolController.class);
	CommonUtils commonUtils = new CommonUtils();
	InventoryRequestResponse response = new InventoryRequestResponse();
	InventoryURIConstant inventoryURIConstants = new InventoryURIConstant();


	@RequestMapping(value = InventoryURIConstant.GET_SCHOOL_DETAILS, method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody InventoryRequestResponse fetchSchoolDetailsById(@PathVariable("schoolId") String schoolId){

		logger.info("school detaials schoolid . : "+schoolId);
		SchoolModal schoolModal = new SchoolModal();

		try {
			schoolModal = iSchoolDataRetrivalService.fetchSchoolById(schoolId);
			response = commonUtils.createResponseData(schoolModal.getSchoolName(), ResponseMessages.GENERALL_FETCH_SUCCESS, ResponseMessages.SUCCESS, "1", schoolModal);

		} catch (PMSException e) {
			// TODO Auto-generated catch block
			logger.error(" In message Error"+e.getMessage());
			logger.error(" In cause Error"+e.getCause());

			e.printStackTrace();
			response = commonUtils.createResponseData(schoolModal.getSchoolName(), ResponseMessages.GENERALL_EXCEPTION, ResponseMessages.FAIL, "1", e.getMessage());
		}

		return response;
	}

	/**
	 * this method will either create or update school object
	 * @param school
	 * @return
	 */
	@RequestMapping(value = InventoryURIConstant.CREATE_SCHOOL_DETAILS, method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody InventoryRequestResponse createSchool(@RequestBody SchoolModal school) {
		// SchoolModal is just used for controller and DataRetrieval service only.
		// School is used for Database Interaction - Hibernate, why because School class is having all configurations of database, @Table, @Column
		// SchoolHelper is used only for converting School to SchoolModal and vice versa.
		try {
			System.out.println("school Name............."+school.getSchoolName());
			SchoolHelper sHelper = new SchoolHelper();
			School schoolEntity = sHelper.createSchool(school);
			iSchoolDataRetrivalService.createOrUpdateSchool(schoolEntity);
			response = commonUtils.createResponseData("Done", ResponseMessages.GENERALL_INSERT_SUCCESS, ResponseMessages.SUCCESS, "1", "--");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			response = commonUtils.createResponseData(e.getMessage(), ResponseMessages.GENERALL_EXCEPTION, ResponseMessages.FAIL, "0", "--");
		} 
		return response;
	}

	/*
	@RequestMapping(value = InventoryURIConstant.PUT_SCHOOL_DETAILS, method = RequestMethod.PUT, produces = "application/json")
	public @ResponseBody InventoryRequestResponse updateSchool(@PathVariable("schoolId") String schoolId){

		try {

			response = commonUtils.createResponseData("Done", message.GENERALL_EXCEPTION, message.FAIL, "0", "--");
			// call service method by passing the schoolId - > ISchoolDataService

			SchoolHelper cHelper = new SchoolHelper();
			School schoolDetails = new School();
			schoolDetails = iSchoolDataRetrivalService.updateSchoolById(schoolModal);

			if(schoolDetails != null ){
				schoolModal = cHelper.createschoolModal(schoolDetails);

				response = commonUtils.createResponseData(schoolModal.getSchoolName(), message.GENERALL_UPDATE_SUCCESS, message.SUCCESS, "1", schoolModal);
			}else{

				School schoolZero = new School();
				response = commonUtils.createResponseData("Zero records found", message.GENERALL_UPDATE_SUCCESS, message.SUCCESS, "0", schoolZero);

			}


		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			response = commonUtils.createResponseData(e.getMessage(), message.GENERALL_EXCEPTION, message.FAIL, "0", "--");
		} 
		return response;


	}
	 */
	
	/**
	 * this method is for delete operation
	 * @param schoolId
	 * @return
	 */
	@RequestMapping(value = InventoryURIConstant.DELETE_SCHOOL_DETAILS, method = RequestMethod.DELETE, produces = "application/json")
	public @ResponseBody InventoryRequestResponse deleteSchool(@PathVariable("schoolId") String schoolId){
		try {
			// call service method by passing the schoolId - > ISchoolDataService

			School schoolDetails = new School();
			boolean result = iSchoolDataRetrivalService.deleteSchoolById(schoolId);

			if(result){
				response = commonUtils.createResponseData("Done", ResponseMessages.GENERALL_DELETE_SUCCESS, ResponseMessages.SUCCESS, "1", schoolDetails);
			}else{

				School schoolZero = new School();
				response = commonUtils.createResponseData("Zero records found", ResponseMessages.GENERALL_DELETE_SUCCESS, ResponseMessages.SUCCESS, "0", schoolZero);

			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			response = commonUtils.createResponseData(e.getMessage(), ResponseMessages.GENERALL_EXCEPTION, ResponseMessages.FAIL, "0", e);
		} 
		return response;

	}


}
