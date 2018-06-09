package com.cgs.pro94tek.healthcare.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cgs.pro94tek.healthcare.bean.Customer;
import com.cgs.pro94tek.healthcare.exeception.PMSException;
import com.cgs.pro94tek.healthcare.modal.CustomerModal;

@Component
public interface ICustomerDataManagementService {
	

	public List<CustomerModal> fetchCustomerById(String customerId) throws PMSException;


	public Customer fetchCustomerByName(String customerName) throws PMSException;

	public void createOrUpdateCustomer(Customer customerEntity) throws PMSException;

	public boolean deleteCustomerById(String customerId) throws PMSException;

}
