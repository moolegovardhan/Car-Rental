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

import com.cgs.pro94tek.healthcare.bean.Vehicle;
import com.cgs.pro94tek.healthcare.exeception.PMSException;
import com.cgs.pro94tek.healthcare.helper.VehicleHelper;
import com.cgs.pro94tek.healthcare.modal.VehicleModal;
import com.cgs.pro94tek.healthcare.service.IVehicleDataManagementService;
import com.cgs.pro94tek.utils.CommonUtils;
import com.cgs.pro94tek.utils.InventoryRequestResponse;
import com.cgs.pro94tek.utils.InventoryURIConstant;
import com.cgs.pro94tek.utils.ResponseMessages;

@Controller
public class VehicleController {

	
	@Autowired
	IVehicleDataManagementService ivehicleDataManagementService;
	
	private static final Logger logger = LoggerFactory.getLogger(VehicleController.class);
	CommonUtils commonUtils = new CommonUtils();
	InventoryRequestResponse response = new InventoryRequestResponse();
	InventoryURIConstant inventoryURIConstants = new InventoryURIConstant();
	
	@RequestMapping(value = InventoryURIConstant.GET_VEHICLE_DETAILS, method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody InventoryRequestResponse fetchVehicleDetailsById(@PathVariable("vehicleId") String vehicleId){

		logger.info("Vehicle  details vehicleId . : "+vehicleId);
		List<VehicleModal> vehicleModal = new ArrayList<VehicleModal>();

		try {
			vehicleModal = ivehicleDataManagementService.fetchVehicleById(vehicleId);
			response = commonUtils.createResponseData("VEHICLE Details fetch", ResponseMessages.GENERALL_FETCH_SUCCESS, ResponseMessages.SUCCESS, "1", vehicleModal);

		} catch (PMSException e) {
			// TODO Auto-generated catch block
			logger.error(" In message Error"+e.getMessage());
			logger.error(" In cause Error"+e.getCause());

			e.printStackTrace();
			response = commonUtils.createResponseData("Vehicle Details fetch", ResponseMessages.GENERALL_EXCEPTION, ResponseMessages.FAIL, "1", e.getMessage());
		}

		return response;
	}
	

	@RequestMapping(value = InventoryURIConstant.CREATE_VEHICLE_DETAILS, method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody InventoryRequestResponse createVehicle(@RequestBody VehicleModal vehicle) {

		try {
			System.out.println("Vehicle Name............."+vehicle.getOwnername());
			VehicleHelper vHelper = new VehicleHelper();
			Vehicle vehicleEntity = vHelper.createVehicle(vehicle);
			ivehicleDataManagementService.createOrUpdateVehicle(vehicleEntity);
			response = commonUtils.createResponseData("Done", ResponseMessages.GENERALL_INSERT_SUCCESS, ResponseMessages.SUCCESS, "1", "--");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			response = commonUtils.createResponseData(e.getMessage(), ResponseMessages.GENERALL_EXCEPTION, ResponseMessages.FAIL, "0", "--");
		} 
		return response;
	}
	
	
	@RequestMapping(value = InventoryURIConstant.DELETE_VEHICLE_DETAILS, method = RequestMethod.DELETE, produces = "application/json")
	public @ResponseBody InventoryRequestResponse deletevehicle(@PathVariable("vehicleId") String vehicleId){
		try {
		

			Vehicle vehicleDetails = new Vehicle();
			boolean result = ivehicleDataManagementService.deleteVehicleById(vehicleId);

			if(result){
				response = commonUtils.createResponseData("Done", ResponseMessages.GENERALL_DELETE_SUCCESS, ResponseMessages.SUCCESS, "1", vehicleDetails);
			}else{

				Vehicle vehiclezero = new Vehicle();
				response = commonUtils.createResponseData("Zero records found", ResponseMessages.GENERALL_DELETE_SUCCESS, ResponseMessages.SUCCESS, "0", vehiclezero);

			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			response = commonUtils.createResponseData(e.getMessage(), ResponseMessages.GENERALL_EXCEPTION, ResponseMessages.FAIL, "0", e);
		} 
		return response;

	}

}
