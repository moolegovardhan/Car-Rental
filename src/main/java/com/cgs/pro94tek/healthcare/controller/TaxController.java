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

import com.cgs.pro94tek.healthcare.bean.Tax;
import com.cgs.pro94tek.healthcare.exeception.PMSException;
import com.cgs.pro94tek.healthcare.helper.TaxHelper;
import com.cgs.pro94tek.healthcare.modal.TaxModal;
import com.cgs.pro94tek.healthcare.service.ITaxDataManagementService;
import com.cgs.pro94tek.utils.CommonUtils;
import com.cgs.pro94tek.utils.InventoryRequestResponse;
import com.cgs.pro94tek.utils.InventoryURIConstant;
import com.cgs.pro94tek.utils.ResponseMessages;

@Controller
public class TaxController {
	
	@Autowired
	ITaxDataManagementService iTaxDataManagementService;
	
	private static final Logger logger = LoggerFactory.getLogger(TaxController.class);
	CommonUtils commonUtils = new CommonUtils();
	InventoryRequestResponse response = new InventoryRequestResponse();
	InventoryURIConstant inventoryURIConstants = new InventoryURIConstant();

	@RequestMapping(value = InventoryURIConstant.GET_TAX_DETAILS, method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody InventoryRequestResponse fetchTaxDetailsById(@PathVariable("taxId") String taxId){

		logger.info("tax detaials taxId . : "+taxId);
		List<TaxModal> taxModal = new ArrayList<TaxModal>();

		try {
			taxModal = iTaxDataManagementService.fetchTaxById(taxId);
			response = commonUtils.createResponseData("Tax Details fetch", ResponseMessages.GENERALL_FETCH_SUCCESS, ResponseMessages.SUCCESS, "1", taxModal);

		} catch (PMSException e) {
			// TODO Auto-generated catch block
			logger.error(" In message Error"+e.getMessage());
			logger.error(" In cause Error"+e.getCause());

			e.printStackTrace();
			response = commonUtils.createResponseData("Tax Details fetch", ResponseMessages.GENERALL_EXCEPTION, ResponseMessages.FAIL, "1", e.getMessage());
		}

		return response;
	}
	
	
	/**
	 * this method will either create or update tax object
	 * @param tax
	 * @return
	 */
	@RequestMapping(value = InventoryURIConstant.CREATE_TAX_DETAILS, method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody InventoryRequestResponse createTax(@RequestBody TaxModal tax) {
		// TaxModal is just used for controller and DataRetrieval service only.
		// Tax is used for Database Interaction - Hibernate, why because Tax class is having all configurations of database, @Table, @Column
		// TaxHelper is used only for converting Tax to TaxModal and vice versa.
		try {
			System.out.println("Tax Name............."+tax.getTaxname());
			TaxHelper tHelper = new TaxHelper();
			Tax taxEntity = tHelper.createTax(tax);
			iTaxDataManagementService.createOrUpdateTax(taxEntity);
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
	 * @param schoolId
	 * @return
	 */
	@RequestMapping(value = InventoryURIConstant.DELETE_TAX_DETAILS, method = RequestMethod.DELETE, produces = "application/json")
	public @ResponseBody InventoryRequestResponse deletetax(@PathVariable("taxId") String taxId){
		try {
		

			Tax taxDetails = new Tax();
			boolean result = iTaxDataManagementService.deleteTaxById(taxId);

			if(result){
				response = commonUtils.createResponseData("Done", ResponseMessages.GENERALL_DELETE_SUCCESS, ResponseMessages.SUCCESS, "1", taxDetails);
			}else{

				Tax taxZero = new Tax();
				response = commonUtils.createResponseData("Zero records found", ResponseMessages.GENERALL_DELETE_SUCCESS, ResponseMessages.SUCCESS, "0", taxZero);

			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			response = commonUtils.createResponseData(e.getMessage(), ResponseMessages.GENERALL_EXCEPTION, ResponseMessages.FAIL, "0", e);
		} 
		return response;

	}
	


}
