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

import com.cgs.pro94tek.healthcare.bean.Charge;
import com.cgs.pro94tek.healthcare.exeception.PMSException;
import com.cgs.pro94tek.healthcare.helper.ChargeHelper;
import com.cgs.pro94tek.healthcare.modal.ChargeModal;
import com.cgs.pro94tek.healthcare.service.IChargeDataManagementService;
import com.cgs.pro94tek.utils.CommonUtils;
import com.cgs.pro94tek.utils.InventoryRequestResponse;
import com.cgs.pro94tek.utils.InventoryURIConstant;
import com.cgs.pro94tek.utils.ResponseMessages;

@Controller
public class ChargeController {
	
	@Autowired
	IChargeDataManagementService ichargeDataManagementService;
	
	private static final Logger logger = LoggerFactory.getLogger(ChargeController.class);
	CommonUtils commonUtils = new CommonUtils();
	InventoryRequestResponse response = new InventoryRequestResponse();
	InventoryURIConstant inventoryURIConstants = new InventoryURIConstant();

	@RequestMapping(value = InventoryURIConstant.GET_CHARGE_DETAILS, method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody InventoryRequestResponse fetchChargeDetailsById(@PathVariable("chargeId") String chargeId){

		logger.info("Charge details chargeid . : "+chargeId);
		List<ChargeModal> chargeModal = new ArrayList<ChargeModal>();

		try {
			chargeModal = ichargeDataManagementService.fetchChargeById(chargeId);
			response = commonUtils.createResponseData("Charge Fetch Issues", ResponseMessages.GENERALL_FETCH_SUCCESS, ResponseMessages.SUCCESS, "1", chargeModal);

		} catch (PMSException e) {
			// TODO Auto-generated catch block
			logger.error(" In message Error"+e.getMessage());
			logger.error(" In cause Error"+e.getCause());

			e.printStackTrace();
			response = commonUtils.createResponseData("Charge Fetch Issues", ResponseMessages.GENERALL_EXCEPTION, ResponseMessages.FAIL, "1", e.getMessage());
		}

		return response;
	}
	
	
	/**
	 * this method will either create or update Charge object
	 * @param charge
	 * @return
	 */
	@RequestMapping(value = InventoryURIConstant.CREATE_CHARGE_DETAILS, method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody InventoryRequestResponse createCharge(@RequestBody ChargeModal charge) {
		try {
			System.out.println("Charge Name............."+charge.getChargename());
			ChargeHelper cHelper = new ChargeHelper();
			Charge chargeEntity = cHelper.createCharge(charge);
			ichargeDataManagementService.createOrUpdateCharge(chargeEntity);
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
	 * @param chargeId
	 * @return
	 */
	@RequestMapping(value = InventoryURIConstant.DELETE_CHARGE_DETAILS, method = RequestMethod.DELETE, produces = "application/json")
	public @ResponseBody InventoryRequestResponse deletecharge(@PathVariable("chargeId") String chargeId){
		try {

			Charge chargeDetails = new Charge();
			boolean result = ichargeDataManagementService.deleteChargeById(chargeId);

			if(result){
				response = commonUtils.createResponseData("Done", ResponseMessages.GENERALL_DELETE_SUCCESS, ResponseMessages.SUCCESS, "1", chargeDetails);
			}else{

				Charge chargeZero = new Charge();
				response = commonUtils.createResponseData("Zero records found", ResponseMessages.GENERALL_DELETE_SUCCESS, ResponseMessages.SUCCESS, "0", chargeZero);

			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			response = commonUtils.createResponseData(e.getMessage(), ResponseMessages.GENERALL_EXCEPTION, ResponseMessages.FAIL, "0", e);
		} 
		return response;

	}
}
