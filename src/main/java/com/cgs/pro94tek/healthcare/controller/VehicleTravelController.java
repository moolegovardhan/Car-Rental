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

import com.cgs.pro94tek.healthcare.bean.VehicleTravelling;
import com.cgs.pro94tek.healthcare.exeception.PMSException;
import com.cgs.pro94tek.healthcare.helper.VehicleTravelHelper;
import com.cgs.pro94tek.healthcare.modal.VehicleTravelModal;
import com.cgs.pro94tek.healthcare.service.IVehicleTravelDataManagementService;
import com.cgs.pro94tek.utils.CommonUtils;
import com.cgs.pro94tek.utils.InventoryRequestResponse;
import com.cgs.pro94tek.utils.InventoryURIConstant;
import com.cgs.pro94tek.utils.ResponseMessages;

@Controller
public class VehicleTravelController {
	
	@Autowired
	IVehicleTravelDataManagementService ivehicleTravelDataManagementService;
	
	private static final Logger logger = LoggerFactory.getLogger(VehicleTravelController.class);
	CommonUtils commonUtils = new CommonUtils();
	InventoryRequestResponse response = new InventoryRequestResponse();
	InventoryURIConstant inventoryURIConstants = new InventoryURIConstant();
	
	
	@RequestMapping(value = InventoryURIConstant.GET_JOURNEY_DETAILS, method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody InventoryRequestResponse fetchVehicleTravelDetailsById(@PathVariable("travelId") String travelId){

		logger.info("Journey details travelId . : "+travelId);
		List<VehicleTravelModal> vehicleTravelModal = new ArrayList<VehicleTravelModal>();

		try {
			vehicleTravelModal = ivehicleTravelDataManagementService.fetchVehicleTravelDetails(travelId);
			response = commonUtils.createResponseData("Journey Details Fetch ", ResponseMessages.GENERALL_FETCH_SUCCESS, ResponseMessages.SUCCESS, "1", vehicleTravelModal);

		} catch (PMSException e) {
			// TODO Auto-generated catch block
			logger.error(" In message Error"+e.getMessage());
			logger.error(" In cause Error"+e.getCause());

			e.printStackTrace();
			response = commonUtils.createResponseData("Journey Details Fetch ", ResponseMessages.GENERALL_EXCEPTION, ResponseMessages.FAIL, "1", e.getMessage());
		}

		return response;
	}
	
	
	@RequestMapping(value = InventoryURIConstant.GET_JOURNEY_DETAILS_BY_NUMBER, method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody InventoryRequestResponse fetchVehicleTravelDetailsByNumber (@PathVariable("vehicleNumber") String vehicleNumber){

		logger.info("travel details vehicle number . : "+vehicleNumber);
		VehicleTravelling journey = new VehicleTravelling();

		try {
			journey = ivehicleTravelDataManagementService.fetchVehicleTravelDetailsByNumber(vehicleNumber);
			response = commonUtils.createResponseData("travel Details Fetch ", ResponseMessages.GENERALL_FETCH_SUCCESS, ResponseMessages.SUCCESS, "1", journey);

		} catch (PMSException e) {
			// TODO Auto-generated catch block
			logger.error(" In message Error"+e.getMessage());
			logger.error(" In cause Error"+e.getCause());

			e.printStackTrace();
			response = commonUtils.createResponseData("travel Details Fetch ", ResponseMessages.GENERALL_EXCEPTION, ResponseMessages.FAIL, "1", e.getMessage());
		}

		return response;
	}
	

	/*-----------insert jouney detials--------  */
	 
		@RequestMapping(value = InventoryURIConstant.CREATE_TRAVEL_DETAILS, method = RequestMethod.POST, produces = "application/json")
		public @ResponseBody InventoryRequestResponse createVehicleTravel(@RequestBody VehicleTravelModal vehicletravelmodal) {
			
			try {
				System.out.println("Journry Details............."+vehicletravelmodal.getDriverid());
				VehicleTravelHelper VTravelHelper = new VehicleTravelHelper();
				VehicleTravelling vtravelEntity = VTravelHelper.CreateVehicleTravel(vehicletravelmodal);
				
				ivehicleTravelDataManagementService.createOrUpdateVehicleTravelDetails(vtravelEntity);
				response = commonUtils.createResponseData("Done", ResponseMessages.GENERALL_INSERT_SUCCESS, ResponseMessages.SUCCESS, "1", "--");
			} catch (Exception e) {
				e.printStackTrace();
				logger.error(e.getMessage());
				response = commonUtils.createResponseData(e.getMessage(), ResponseMessages.GENERALL_EXCEPTION, ResponseMessages.FAIL, "0", "--");
			} 
			return response;
		}
		
		/*delete travel details*/
		
		@RequestMapping(value = InventoryURIConstant.DELETE_TRAVEL_DETAILS, method = RequestMethod.DELETE, produces = "application/json")
		public @ResponseBody InventoryRequestResponse deleteVehicleTravel(@PathVariable("travelId") String travelId){
			try {
				
				
				VehicleTravelling vehicletravelDetails = new VehicleTravelling();
				boolean result = ivehicleTravelDataManagementService.deleteVehicleTravelById(travelId);

				if(result){
					response = commonUtils.createResponseData("Done", ResponseMessages.GENERALL_DELETE_SUCCESS, ResponseMessages.SUCCESS, "1", vehicletravelDetails);
				}else{

					VehicleTravelling vehicletravelZero = new VehicleTravelling();
					response = commonUtils.createResponseData("Zero records found", ResponseMessages.GENERALL_DELETE_SUCCESS, ResponseMessages.SUCCESS, "0", vehicletravelZero);

				}

			} catch (Exception e) {
				e.printStackTrace();
				logger.error(e.getMessage());
				response = commonUtils.createResponseData(e.getMessage(), ResponseMessages.GENERALL_EXCEPTION, ResponseMessages.FAIL, "0", e);
			} 
			return response;

		}

		

}
