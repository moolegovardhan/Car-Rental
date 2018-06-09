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

import com.cgs.pro94tek.healthcare.bean.Location;
import com.cgs.pro94tek.healthcare.exeception.PMSException;
import com.cgs.pro94tek.healthcare.helper.LocationHelper;
import com.cgs.pro94tek.healthcare.modal.LocationModal;
import com.cgs.pro94tek.healthcare.service.ILocationDataManagementService;
import com.cgs.pro94tek.utils.CommonUtils;
import com.cgs.pro94tek.utils.InventoryRequestResponse;
import com.cgs.pro94tek.utils.InventoryURIConstant;
import com.cgs.pro94tek.utils.ResponseMessages;

@Controller
public class LocationController {

	
	@Autowired
	private ILocationDataManagementService ilocationDataManagementService;
	
	private static final Logger logger = LoggerFactory.getLogger(LocationController.class);
	CommonUtils commonUtils = new CommonUtils();
	InventoryRequestResponse response = new InventoryRequestResponse();
	InventoryURIConstant inventoryURIConstants = new InventoryURIConstant();
	
	
/*
	@RequestMapping(value = InventoryURIConstant.GET_LOCATION_DETAILS, method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody InventoryRequestResponse fetchLocaionDetailsById(@PathVariable("locationId") String locationId){

		logger.info("Location details locationId . : "+locationId);
		LocationModal locationModal = new LocationModal();

		try {
			locationModal = ilocationDataManagementService.getLocationById(locationId);
			response = commonUtils.createResponseData("Location Details Fetch ", ResponseMessages.GENERALL_FETCH_SUCCESS, ResponseMessages.SUCCESS, "1", locationModal);

		} catch (PMSException e) {
			// TODO Auto-generated catch block
			logger.error(" In message Error"+e.getMessage());
			logger.error(" In cause Error"+e.getCause());

			e.printStackTrace();
			response = commonUtils.createResponseData("Location Details Fetch ", ResponseMessages.GENERALL_EXCEPTION, ResponseMessages.FAIL, "1", e.getMessage());
		}

		return response;
	}*/
	
	/*-----------------fetch location by name--------*/

	@RequestMapping(value = InventoryURIConstant.GET_LOCATION_DETAILS_BY_NAME, method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody InventoryRequestResponse fetchLocationDetailsByLocationName(@PathVariable("locationName") String locationName){
		System.out.println("Location controller Location Name.........:"+locationName);
		logger.info("Location details LocationName. : "+locationName);
		List<LocationModal>  locationMod = new ArrayList<LocationModal>();

		try {
			locationMod = ilocationDataManagementService.fetchLocationDetailsByName(locationName);
			response = commonUtils.createResponseData("Location Details Fetch ", ResponseMessages.GENERALL_FETCH_SUCCESS, ResponseMessages.SUCCESS, "1", locationMod);
			System.out.println("response data in Locationname.....:"+response);
			System.out.println("");
		} catch (PMSException e) {
			// TODO Auto-generated catch block
			logger.error(" In message Error"+e.getMessage());
			logger.error(" In cause Error"+e.getCause());

			e.printStackTrace();
			response = commonUtils.createResponseData("Location Details Fetch ", ResponseMessages.GENERALL_EXCEPTION, ResponseMessages.FAIL, "1", e.getMessage());
		}

		return response;
	}
	
	
	

	@RequestMapping(value = InventoryURIConstant.CREATE_LOCATION_DETAILS, method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody InventoryRequestResponse createLocation(@RequestBody LocationModal location) {

		try {
			System.out.println("Location Name............."+location.getLocation());
			LocationHelper lHelper = new LocationHelper();
			Location locationEntity = lHelper.createLocation(location);
			ilocationDataManagementService.createOrUpdateLocationDetails(locationEntity);
			response = commonUtils.createResponseData("Done", ResponseMessages.GENERALL_INSERT_SUCCESS, ResponseMessages.SUCCESS, "1", "--");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			response = commonUtils.createResponseData(e.getMessage(), ResponseMessages.GENERALL_EXCEPTION, ResponseMessages.FAIL, "0", "--");
		} 
		return response;
	}
	
}
