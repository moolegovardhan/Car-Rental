package com.cgs.pro94tek.healthcare.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cgs.pro94tek.healthcare.exeception.PMSException;
import com.cgs.pro94tek.healthcare.modal.StateModal;
import com.cgs.pro94tek.healthcare.service.IStateDataManagementService;
import com.cgs.pro94tek.utils.CommonUtils;
import com.cgs.pro94tek.utils.InventoryRequestResponse;
import com.cgs.pro94tek.utils.InventoryURIConstant;
import com.cgs.pro94tek.utils.ResponseMessages;

@Controller
public class StateController {
	
	
	@Autowired
	private IStateDataManagementService iStateDataManagementService;
	
	private static final Logger logger = LoggerFactory.getLogger(StateController.class);
	CommonUtils commonUtils = new CommonUtils();
	InventoryRequestResponse response = new InventoryRequestResponse();
	InventoryURIConstant inventoryURIConstants = new InventoryURIConstant();

	
	@RequestMapping(value = InventoryURIConstant.GET_DISTRICT_BY_STATE, method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody InventoryRequestResponse fetchDistrictByStateName(@PathVariable("stateName") String stateName){
		System.out.println("State controller state Name.........:"+stateName);
		logger.info("District details stateName. : "+stateName);
		List<StateModal> stateModal = new ArrayList<StateModal>();

		try {
			stateModal = iStateDataManagementService.fetchDistrictInfoBystateName(stateName);
			response = commonUtils.createResponseData("District Details Fetch ", ResponseMessages.GENERALL_FETCH_SUCCESS, ResponseMessages.SUCCESS, "1", stateModal);
			System.out.println("response data in statename.....:"+response);
		} catch (PMSException e) {
			// TODO Auto-generated catch block
			logger.error(" In message Error"+e.getMessage());
			logger.error(" In cause Error"+e.getCause());

			response = commonUtils.createResponseData("District Details Fetch ", ResponseMessages.GENERALL_EXCEPTION, ResponseMessages.FAIL, "1", e.getMessage());
		}

		return response;
	}
}
