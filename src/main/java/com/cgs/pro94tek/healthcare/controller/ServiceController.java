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

import com.cgs.pro94tek.healthcare.bean.Service;
import com.cgs.pro94tek.healthcare.exeception.PMSException;
import com.cgs.pro94tek.healthcare.helper.ServiceHelper;
import com.cgs.pro94tek.healthcare.modal.ServiceModal;
import com.cgs.pro94tek.healthcare.service.IServiceDataManagmentService;
import com.cgs.pro94tek.utils.CommonUtils;
import com.cgs.pro94tek.utils.InventoryRequestResponse;
import com.cgs.pro94tek.utils.InventoryURIConstant;
import com.cgs.pro94tek.utils.ResponseMessages;

@Controller
public class ServiceController {
	

	@Autowired
	IServiceDataManagmentService iserviceDataManagementService;
	
	private static final Logger logger = LoggerFactory.getLogger(ServiceController.class);
	CommonUtils commonUtils = new CommonUtils();
	InventoryRequestResponse response = new InventoryRequestResponse();
	InventoryURIConstant inventoryURIConstants = new InventoryURIConstant();

	@RequestMapping(value = InventoryURIConstant.GET_SERVICE_DETAILS, method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody InventoryRequestResponse fetchServiceDetailsById(@PathVariable("serviceId") String serviceId){

		logger.info("Service detaials serviceId . : "+serviceId);
		List<ServiceModal> serviceModal = new ArrayList<ServiceModal>();

		try {
			serviceModal = iserviceDataManagementService.fetchServiceById(serviceId);
			response = commonUtils.createResponseData("Service Details fetch", ResponseMessages.GENERALL_FETCH_SUCCESS, ResponseMessages.SUCCESS, "1", serviceModal);

		} catch (PMSException e) {
			// TODO Auto-generated catch block
			logger.error(" In message Error"+e.getMessage());
			logger.error(" In cause Error"+e.getCause());

			e.printStackTrace();
			response = commonUtils.createResponseData("Service Details fetch", ResponseMessages.GENERALL_EXCEPTION, ResponseMessages.FAIL, "1", e.getMessage());
		}

		return response;
	}
	
	
	/**
	 * this method will either create or update serivce object
	 * @param serivce
	 * @return
	 */
	@RequestMapping(value = InventoryURIConstant.CREATE_SERVICE_DETAILS, method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody InventoryRequestResponse createService(@RequestBody ServiceModal service) {
		// ServiceModal is just used for controller and DataRetrieval service only.
		// SErvice is used for Database Interaction - Hibernate, why because Service class is having all configurations of database, @Table, @Column
		// ServiceHelper is used only for converting SErvice to ServiceModal and vice versa.
		try {
			System.out.println("Service Name............."+service.getServicename());
			ServiceHelper sHelper = new ServiceHelper();
			Service serviceEntity = sHelper.createService(service);
			iserviceDataManagementService.createOrUpdateService(serviceEntity);
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
	 * @param serviceId
	 * @return
	 */
	@RequestMapping(value = InventoryURIConstant.DELETE_SERVICE_DETAILS, method = RequestMethod.DELETE, produces = "application/json")
	public @ResponseBody InventoryRequestResponse deleteservice(@PathVariable("serviceId") String serviceId){
		try {
		

			Service serviceDetails = new Service();
			boolean result = iserviceDataManagementService.deleteServiceById(serviceId);

			if(result){
				response = commonUtils.createResponseData("Done", ResponseMessages.GENERALL_DELETE_SUCCESS, ResponseMessages.SUCCESS, "1", serviceDetails);
			}else{

				Service serviceZero = new Service();
				response = commonUtils.createResponseData("Zero records found", ResponseMessages.GENERALL_DELETE_SUCCESS, ResponseMessages.SUCCESS, "0", serviceZero);

			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			response = commonUtils.createResponseData(e.getMessage(), ResponseMessages.GENERALL_EXCEPTION, ResponseMessages.FAIL, "0", e);
		} 
		return response;

	}

}
