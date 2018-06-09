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
import com.cgs.pro94tek.healthcare.bean.Department;
import com.cgs.pro94tek.healthcare.exeception.PMSException;
import com.cgs.pro94tek.healthcare.helper.DepartmentHelper;
import com.cgs.pro94tek.healthcare.modal.DepartmentModal;
import com.cgs.pro94tek.healthcare.service.IDepartmentDataManagementService;
import com.cgs.pro94tek.utils.CommonUtils;
import com.cgs.pro94tek.utils.InventoryRequestResponse;
import com.cgs.pro94tek.utils.InventoryURIConstant;
import com.cgs.pro94tek.utils.ResponseMessages;
	
@Controller
public class DepartmentController {
	
	@Autowired
	IDepartmentDataManagementService idepartmentDataManagementService;

	private static final Logger logger = LoggerFactory.getLogger(DepartmentController.class);
	CommonUtils commonUtils = new CommonUtils();
	InventoryRequestResponse response = new InventoryRequestResponse();
	InventoryURIConstant inventoryURIConstants = new InventoryURIConstant();
	
	
	/*--------------------Fetch by deptId------------*/

	@RequestMapping(value = InventoryURIConstant.GET_DEPARTMENT_DETAILS, method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody InventoryRequestResponse fetchDepartmentById(@PathVariable("deptId") String deptId){

		logger.info("Department details departmentId . : "+deptId);
		List<DepartmentModal> departmentModal = new ArrayList<DepartmentModal>();

		try {
			departmentModal = idepartmentDataManagementService.fetchDepartmentById(deptId);
			response = commonUtils.createResponseData("Department Details Fetch ", ResponseMessages.GENERALL_FETCH_SUCCESS, ResponseMessages.SUCCESS, "1", departmentModal);

		} catch (PMSException e) {
			// TODO Auto-generated catch block
			logger.error(" In message Error"+e.getMessage());
			logger.error(" In cause Error"+e.getCause());

			e.printStackTrace();
			response = commonUtils.createResponseData("Department Details Fetch ", ResponseMessages.GENERALL_EXCEPTION, ResponseMessages.FAIL, "1", e.getMessage());
		}

		return response;
	}
	

	/*-----------insert Department details--------  */

	@RequestMapping(value = InventoryURIConstant.CREATE_DEPARTMENT_DETAILS, method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody InventoryRequestResponse createDepartment(@RequestBody DepartmentModal departmentmodal) {
		
		try {
			System.out.println("Deaprtment Details............."+departmentmodal.getDepartmentname());
			DepartmentHelper departmentHelper = new DepartmentHelper();
			Department deptEntity = departmentHelper.createDepartment(departmentmodal);
			
			idepartmentDataManagementService.createOrUpdateDepartment(deptEntity);
			response = commonUtils.createResponseData("Done", ResponseMessages.GENERALL_INSERT_SUCCESS, ResponseMessages.SUCCESS, "1", "--");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			response = commonUtils.createResponseData(e.getMessage(), ResponseMessages.GENERALL_EXCEPTION, ResponseMessages.FAIL, "0", "--");
		} 
		return response;
	}


	
	@RequestMapping(value = InventoryURIConstant.DELETE_DEPARTMENT_DETAILS, method = RequestMethod.DELETE, produces = "application/json")
	public @ResponseBody InventoryRequestResponse deleteDepartment(@PathVariable("deptId") String deptId){
		try {
		

			Department deptDetails = new Department();
			boolean result = idepartmentDataManagementService.deleteDepartmentById(deptId);

			if(result){
				response = commonUtils.createResponseData("Done", ResponseMessages.GENERALL_DELETE_SUCCESS, ResponseMessages.SUCCESS, "1", deptDetails);
			}else{

				Department departmentzero = new Department();
				response = commonUtils.createResponseData("Zero records found", ResponseMessages.GENERALL_DELETE_SUCCESS, ResponseMessages.SUCCESS, "0", departmentzero);

			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			response = commonUtils.createResponseData(e.getMessage(), ResponseMessages.GENERALL_EXCEPTION, ResponseMessages.FAIL, "0", e);
		} 
		return response;

	}
}
