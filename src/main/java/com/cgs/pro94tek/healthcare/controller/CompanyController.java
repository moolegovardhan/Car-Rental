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

import com.cgs.pro94tek.healthcare.bean.Company;
import com.cgs.pro94tek.healthcare.exeception.PMSException;
import com.cgs.pro94tek.healthcare.helper.CompanyHelper;
import com.cgs.pro94tek.healthcare.modal.CompanyModal;
import com.cgs.pro94tek.healthcare.service.ICompanyDataManagementService;
import com.cgs.pro94tek.utils.CommonUtils;
import com.cgs.pro94tek.utils.InventoryRequestResponse;
import com.cgs.pro94tek.utils.InventoryURIConstant;
import com.cgs.pro94tek.utils.ResponseMessages;

@Controller
public class CompanyController {
	
	@Autowired
	ICompanyDataManagementService iCompanyDataManagementService;
	
	private static final Logger logger = LoggerFactory.getLogger(CompanyController.class);
	CommonUtils commonUtils = new CommonUtils();
	InventoryRequestResponse response = new InventoryRequestResponse();
	InventoryURIConstant inventoryURIConstants = new InventoryURIConstant();

	@RequestMapping(value = InventoryURIConstant.GET_COMPANY_DETAILS, method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody InventoryRequestResponse fetchCompanyDetailsById(@PathVariable("companyId") String companyId){

		logger.info("company details companyId . : "+companyId);
		List<CompanyModal> companyModal = new ArrayList<CompanyModal>();

		try {
			companyModal = iCompanyDataManagementService.fetchCompanyById(companyId);
			logger.error(companyModal.toString());
			//logger.error(companyModal.getDisplayName());
			response = commonUtils.createResponseData("Company Details fetch", ResponseMessages.GENERALL_FETCH_SUCCESS, ResponseMessages.SUCCESS, "1", companyModal);

		} catch (PMSException e) {
			// TODO Auto-generated catch block
			logger.error(" In message Error"+e.getMessage());
			logger.error(" In cause Error"+e.getCause());

			e.printStackTrace();
			response = commonUtils.createResponseData("Company details fetch failure", ResponseMessages.GENERALL_EXCEPTION, ResponseMessages.FAIL, "1", e.getMessage());
		}

		return response;
	}
	
	
	/**
	 * this method will either create or update company object
	 * @param tax
	 * @return
	 */
	@RequestMapping(value = InventoryURIConstant.CREATE_COMPANY_DETAILS, method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody InventoryRequestResponse createCompany(@RequestBody CompanyModal company) {
		
		try {
			System.out.println("Company Name............."+company.getDisplayName());
			CompanyHelper cHelper = new CompanyHelper();
			Company companyEntity = cHelper.createCompany(company);
			iCompanyDataManagementService.createOrUpdateCompany(companyEntity);
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
	@RequestMapping(value = InventoryURIConstant.PUT_COMPANY_DETAILS, method = RequestMethod.DELETE, produces = "application/json")
	public @ResponseBody InventoryRequestResponse deletecompany(@PathVariable("compnayId") String companyId){
		try {
			

			Company companyDetails = new Company();
			boolean result = iCompanyDataManagementService.deleteCompanyById(companyId);

			if(result){
				response = commonUtils.createResponseData("Done", ResponseMessages.GENERALL_DELETE_SUCCESS, ResponseMessages.SUCCESS, "1", companyDetails);
			}else{

				Company companyZero = new Company();
				response = commonUtils.createResponseData("Zero records found", ResponseMessages.GENERALL_DELETE_SUCCESS, ResponseMessages.SUCCESS, "0", companyZero);

			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			response = commonUtils.createResponseData(e.getMessage(), ResponseMessages.GENERALL_EXCEPTION, ResponseMessages.FAIL, "0", e);
		} 
		return response;

	}


}
