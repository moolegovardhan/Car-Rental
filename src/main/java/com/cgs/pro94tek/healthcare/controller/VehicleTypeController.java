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

import com.cgs.pro94tek.healthcare.bean.VehicleType;
import com.cgs.pro94tek.healthcare.exeception.PMSException;
import com.cgs.pro94tek.healthcare.helper.VehicleTypeHelper;
import com.cgs.pro94tek.healthcare.modal.VehicleTypeModal;
import com.cgs.pro94tek.healthcare.service.IVehicleTypeDataManagementService;
import com.cgs.pro94tek.utils.CommonUtils;
import com.cgs.pro94tek.utils.InventoryRequestResponse;
import com.cgs.pro94tek.utils.InventoryURIConstant;
import com.cgs.pro94tek.utils.ResponseMessages;

@Controller
public class VehicleTypeController {
	
	@Autowired
	IVehicleTypeDataManagementService ivehicletypeDataManagementService;

	private static final Logger logger = LoggerFactory.getLogger(VehicleController.class);
	CommonUtils commonUtils = new CommonUtils();
	InventoryRequestResponse response = new InventoryRequestResponse();
	InventoryURIConstant inventoryURIConstants = new InventoryURIConstant();

	@RequestMapping(value = InventoryURIConstant.GET_VEHICLE_TYPE_DETAILS,method=RequestMethod.GET, produces="application/json" )
	public @ResponseBody InventoryRequestResponse fetchVehicleTypeDetailsById(@PathVariable("vehicletypeId") String vehicletypeId){
		
		logger.info("vehicletype detials   :"  +vehicletypeId);
		List<VehicleTypeModal> vehicletypeModal = new ArrayList<VehicleTypeModal>();

		try {
			vehicletypeModal = ivehicletypeDataManagementService.fetchVehicleTypeById(vehicletypeId);
			response = commonUtils.createResponseData("VehicleType Details fetch", ResponseMessages.GENERALL_FETCH_SUCCESS, ResponseMessages.SUCCESS, "1", vehicletypeModal);

		} catch (PMSException e) {
			// TODO Auto-generated catch block
			logger.error(" In message Error"+e.getMessage());
			logger.error(" In cause Error"+e.getCause());

			e.printStackTrace();
			response = commonUtils.createResponseData("Vehicletype Details fetch", ResponseMessages.GENERALL_EXCEPTION, ResponseMessages.FAIL, "1", e.getMessage());
		}

		return response;
		
	}
	
	

	@RequestMapping(value = InventoryURIConstant.CREATE_VEHICLE_TYPE_DETAILS, method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody InventoryRequestResponse createVehicleType(@RequestBody VehicleTypeModal vehicletypemodal) {

		try {
			System.out.println("VehicleType Datails............."+vehicletypemodal.getId());
			VehicleTypeHelper vtypeHelper = new VehicleTypeHelper();
			VehicleType vehicletypeEntity = vtypeHelper.createVehicleType(vehicletypemodal);
			ivehicletypeDataManagementService.createOrUpdateVehicleType(vehicletypeEntity);
			response = commonUtils.createResponseData("Done", ResponseMessages.GENERALL_INSERT_SUCCESS, ResponseMessages.SUCCESS, "1", "--");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			response = commonUtils.createResponseData(e.getMessage(), ResponseMessages.GENERALL_EXCEPTION, ResponseMessages.FAIL, "0", "--");
		} 
		return response;
	}
	
	

	
	@RequestMapping(value = InventoryURIConstant.DELETE_VEHICLETYPE_DETAILS, method = RequestMethod.DELETE, produces = "application/json")
	public @ResponseBody InventoryRequestResponse deletevehicleType(@PathVariable("vehicletypeId") String vehicletypeId){
		try {
		

			VehicleType vehicletypeDetails = new VehicleType();
			boolean result = ivehicletypeDataManagementService.deleteVehicleTypeById(vehicletypeId);

			if(result){
				response = commonUtils.createResponseData("Done", ResponseMessages.GENERALL_DELETE_SUCCESS, ResponseMessages.SUCCESS, "1", vehicletypeDetails);
			}else{

				VehicleType vehicletypezero = new VehicleType();
				response = commonUtils.createResponseData("Zero records found", ResponseMessages.GENERALL_DELETE_SUCCESS, ResponseMessages.SUCCESS, "0", vehicletypezero);

			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			response = commonUtils.createResponseData(e.getMessage(), ResponseMessages.GENERALL_EXCEPTION, ResponseMessages.FAIL, "0", e);
		} 
		return response;

	}

	
	
}

