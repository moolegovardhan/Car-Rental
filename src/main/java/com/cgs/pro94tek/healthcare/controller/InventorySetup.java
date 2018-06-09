package com.cgs.pro94tek.healthcare.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cgs.pro94tek.healthcare.bean.Category;
import com.cgs.pro94tek.healthcare.exeception.PMSException;
import com.cgs.pro94tek.healthcare.helper.CategoryHelper;
import com.cgs.pro94tek.healthcare.modal.CategoryModal;
import com.cgs.pro94tek.healthcare.service.IInventoryDataManagmentService;
import com.cgs.pro94tek.healthcare.service.IInventoryDataRetrivalService;
import com.cgs.pro94tek.utils.CommonUtils;
import com.cgs.pro94tek.utils.InventoryRequestResponse;
import com.cgs.pro94tek.utils.InventoryURIConstant;
import com.cgs.pro94tek.utils.ResponseMessages;



@Controller
public class InventorySetup {

	
	private static final Logger logger = LoggerFactory.getLogger(InventorySetup.class);
		
	@Autowired
	IInventoryDataManagmentService inventoryMasterService;
	
	@Autowired
	IInventoryDataRetrivalService  inventoryDataRetrivalService;
	
	CommonUtils commonUtils = new CommonUtils();
	ResponseMessages message = new ResponseMessages();
	InventoryRequestResponse response = new InventoryRequestResponse();
	InventoryURIConstant inventoryURIConstants = new InventoryURIConstant();
	CategoryModal categoryModal = new CategoryModal();
	
	
	@RequestMapping(value = InventoryURIConstant.GET_CATEGORY_DETAILS, method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody InventoryRequestResponse getCategoryDetails(@RequestHeader(value="User-Agent") String userAgent,@PathVariable("id") String categoryId) {
		
		
		logger.info("Start getCategoryDetails. ID : "+categoryId);
		System.out.println("userAgent...................."+userAgent);
		try {
			     CategoryHelper cHelper = new CategoryHelper();
			     Category categoryDetails = new Category();
			     categoryDetails = (inventoryDataRetrivalService).getCategoryById(categoryId);
			    
			     if(categoryDetails != null ){
			       categoryModal = cHelper.createCategoryModal(categoryDetails);
				     
					response = commonUtils.createResponseData(categoryModal.getCategoryName(), message.GENERALL_FETCH_SUCCESS, message.SUCCESS, "1", categoryModal);
			     }else{
			    	 
			    	 Category categoryZero = new Category();
			    	 response = commonUtils.createResponseData("Zero records found", message.GENERALL_FETCH_SUCCESS, message.SUCCESS, "0", categoryZero);
				      
			     }
				 
		} catch (PMSException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			response = commonUtils.createResponseData(e.getMessage(), message.GENERALL_EXCEPTION, message.FAIL, "0", categoryId);
			
		} 
		return response;
	}
	
	@RequestMapping(value = InventoryURIConstant.POST_CATEGORY_DETAILS, method = RequestMethod.POST)
	public @ResponseBody InventoryRequestResponse createCategoryDetails(@RequestBody CategoryModal category) {
		try{
				System.out.println("Category..........."+category);
				System.out.println("Category Name............."+category.getCategoryName());
				 CategoryHelper cHelper = new CategoryHelper();
				 Category categoryEntity = cHelper.createCategoryEntity(category);
				 inventoryMasterService.createCategory(categoryEntity);
				response = commonUtils.createResponseData("Done", message.GENERALL_EXCEPTION, message.FAIL, "0", "--");
				
				
			} catch (Exception e) {
				e.printStackTrace();
				logger.error(e.getMessage());
				response = commonUtils.createResponseData(e.getMessage(), message.GENERALL_EXCEPTION, message.FAIL, "0", "--");
			} 
		return response;
	}
		
	
	public void getPrint(){
		System.out.println("sdfgsd");
	}
}
