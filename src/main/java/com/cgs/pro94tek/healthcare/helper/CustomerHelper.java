package com.cgs.pro94tek.healthcare.helper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cgs.pro94tek.healthcare.bean.Customer;
import com.cgs.pro94tek.healthcare.exeception.PMSException;
import com.cgs.pro94tek.healthcare.modal.CustomerModal;

public class CustomerHelper {

	 
		public List<CustomerModal> createcustomerModal(List<Customer> customer){
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy"); 
			List<CustomerModal> CustomerModals = new ArrayList<CustomerModal>();
			for (Customer customerobj : customer) {
				CustomerModal customerModal1 = new CustomerModal();
				customerModal1.setCustomerName(customerobj.getCustomerName());
				customerModal1.setMobileNo(customerobj.getMobileNo());
				customerModal1.setEmail(customerobj.getEmail());
				customerModal1.setAddress(customerobj.getAddress());
				customerModal1.setOfficeid(customerobj.getOfficeid());
				customerModal1.setCreatedDate(df.format(customerobj.getCreatedDate()));
				customerModal1.setCreatedBy(customerobj.getCreatedBy());
				customerModal1.setStatus(customerobj.getStatus());
				customerModal1.setId(customerobj.getId());
				CustomerModals.add(customerModal1);
			}
			
			return CustomerModals;
		}

		
		public Customer createCustomer(CustomerModal customerModal) throws PMSException, ParseException{
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
			Customer customer = new Customer();
			customer.setCustomerName(customerModal.getCustomerName());
			customer.setMobileNo(customerModal.getMobileNo());
			customer.setEmail(customerModal.getEmail());
			customer.setAddress(customerModal.getAddress());
			customer.setCreatedDate(new Date());
			customer.setCreatedBy(customerModal.getCreatedBy());
			customer.setStatus(customerModal.getStatus());
			customer.setOfficeid(customerModal.getOfficeid());
			customer.setId(customerModal.getId());
			
			return customer;
		}

}
