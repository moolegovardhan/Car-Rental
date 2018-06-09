package com.cgs.pro94tek.healthcare.dataaccess.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.cgs.pro94tek.healthcare.bean.Customer;


public interface ICustomerDAO {

	public Customer getCustomerByName(String customerName) throws DataAccessException;
	public List<Customer> fetchCustomerById(String customerId)throws DataAccessException;
	public void createOrUpdateCustomer(Customer customer)throws DataAccessException;
	public boolean deleteCustomerById(String customerId) throws DataAccessException;
}
