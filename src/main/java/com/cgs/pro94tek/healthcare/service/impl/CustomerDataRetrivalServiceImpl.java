package com.cgs.pro94tek.healthcare.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgs.pro94tek.healthcare.bean.Customer;
import com.cgs.pro94tek.healthcare.dataaccess.dao.ICustomerDAO;
import com.cgs.pro94tek.healthcare.exeception.PMSException;
import com.cgs.pro94tek.healthcare.helper.CustomerHelper;
import com.cgs.pro94tek.healthcare.modal.CustomerModal;
import com.cgs.pro94tek.healthcare.service.ICustomerDataManagementService;

@Service("customerDataManagementService")
public class CustomerDataRetrivalServiceImpl implements ICustomerDataManagementService{

	@Autowired
	private ICustomerDAO customerdao;
	
	public List<CustomerModal> fetchCustomerById(String customerId) throws PMSException {
		List<Customer> ward = customerdao.fetchCustomerById(customerId);
		CustomerHelper customerhelper = new CustomerHelper();
		return customerhelper.createcustomerModal(ward);
	}
	
	public Customer fetchCustomerByName(String customerName) throws PMSException {
		
		return customerdao.getCustomerByName(customerName);
	}
	@Override
	public void createOrUpdateCustomer(Customer customerEntity) throws PMSException {
	customerdao.createOrUpdateCustomer(customerEntity);
		
	}

	@Override
	public boolean deleteCustomerById(String customerId) throws PMSException {
		return customerdao.deleteCustomerById(customerId);
	}
	
	
}
