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

import com.cgs.pro94tek.healthcare.bean.Ward;
import com.cgs.pro94tek.healthcare.exeception.PMSException;
import com.cgs.pro94tek.healthcare.helper.WardHelper;
import com.cgs.pro94tek.healthcare.modal.WardModal;
import com.cgs.pro94tek.healthcare.service.IWardDataManagementService;
import com.cgs.pro94tek.utils.CommonUtils;
import com.cgs.pro94tek.utils.InventoryRequestResponse;
import com.cgs.pro94tek.utils.InventoryURIConstant;
import com.cgs.pro94tek.utils.ResponseMessages;

@Controller
public class WardController {
	
	@Autowired
	IWardDataManagementService iWardDataManagementService;
	
	private static final Logger logger = LoggerFactory.getLogger(WardController.class);
	CommonUtils commonUtils = new CommonUtils();
	InventoryRequestResponse response = new InventoryRequestResponse();
	InventoryURIConstant inventoryURIConstants = new InventoryURIConstant();

	@RequestMapping(value = InventoryURIConstant.GET_WARD_DETAILS, method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody InventoryRequestResponse fetchWardDetailsById(@PathVariable("wardId") String wardId){

		logger.info("ward details wardid . : "+wardId);
		List<WardModal> wardModal = new ArrayList<WardModal>();

		try {
			wardModal = iWardDataManagementService.fetchWardById(wardId);
			response = commonUtils.createResponseData("Ward Details Fetch ", ResponseMessages.GENERALL_FETCH_SUCCESS, ResponseMessages.SUCCESS, "1", wardModal);

		} catch (PMSException e) {
			// TODO Auto-generated catch block
			logger.error(" In message Error"+e.getMessage());
			logger.error(" In cause Error"+e.getCause());

			e.printStackTrace();
			response = commonUtils.createResponseData("Ward Details Fetch ", ResponseMessages.GENERALL_EXCEPTION, ResponseMessages.FAIL, "1", e.getMessage());
		}

		return response;
	}
	
	
	/**
	 * this method will either create or update ward object
	 * @param ward
	 * @return
	 */
	@RequestMapping(value = InventoryURIConstant.CREATE_WARD_DETAILS, method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody InventoryRequestResponse createWard(@RequestBody WardModal ward) {
		
		try {
			System.out.println("Ward Name............."+ward.getWardname());
			WardHelper wHelper = new WardHelper();
			Ward wardEntity = wHelper.createWard(ward);
			iWardDataManagementService.createOrUpdateWard(wardEntity);
			response = commonUtils.createResponseData("Done", ResponseMessages.GENERALL_INSERT_SUCCESS, ResponseMessages.SUCCESS, "1", "--");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			response = commonUtils.createResponseData(e.getMessage(), ResponseMessages.GENERALL_EXCEPTION, ResponseMessages.FAIL, "0", "--");
		} 
		return response;
	}
	
	
	/**
	 * this method is for delete operation
	 * @param wardId
	 * @return
	 */
	@RequestMapping(value = InventoryURIConstant.DELETE_WARD_DETAILS, method = RequestMethod.DELETE, produces = "application/json")
	public @ResponseBody InventoryRequestResponse deleteward(@PathVariable("wardId") String wardId){
		try {
			// call service method by passing the wardId - > iWardDataManagementService

			Ward wardDetails = new Ward();
			boolean result = iWardDataManagementService.deleteWardById(wardId);

			if(result){
				response = commonUtils.createResponseData("Done", ResponseMessages.GENERALL_DELETE_SUCCESS, ResponseMessages.SUCCESS, "1", wardDetails);
			}else{

				Ward wardZero = new Ward();
				response = commonUtils.createResponseData("Zero records found", ResponseMessages.GENERALL_DELETE_SUCCESS, ResponseMessages.SUCCESS, "0", wardZero);

			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			response = commonUtils.createResponseData(e.getMessage(), ResponseMessages.GENERALL_EXCEPTION, ResponseMessages.FAIL, "0", e);
		} 
		return response;

	}

}
