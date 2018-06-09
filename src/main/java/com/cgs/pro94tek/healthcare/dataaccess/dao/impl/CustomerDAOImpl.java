
package com.cgs.pro94tek.healthcare.dataaccess.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.cgs.pro94tek.healthcare.bean.Customer;
import com.cgs.pro94tek.healthcare.dataaccess.dao.ICustomerDAO;
import com.cgs.pro94tek.healthcare.dataaccess.dao.support.CustomHibernateDaoSupport;
import com.cgs.pro94tek.utils.PmsUtil;

@Repository("customerDAO")
public class CustomerDAOImpl extends CustomHibernateDaoSupport implements ICustomerDAO{

	@SuppressWarnings("unchecked")
	@Transactional
	public Customer getCustomerByName(String customerName) throws DataAccessException {
		Customer customer = null;
		String queryCustomerByName = "from Customer where customerName = :customerName";
		Query query = getSession().createQuery(queryCustomerByName);
		query.setParameter("customerName", customerName);
		List<Customer> customers = query.list();
		if (PmsUtil.isCollectionNotEmpty(customers)) {
			customer = customers.get(0);
		}
		return customer;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Customer> fetchCustomerById(String customerId) throws DataAccessException {
		List<Customer> customer = new ArrayList<Customer>();
		 String queryCustomerById  = "from Customer where officeid = :customerId";
			Query query = getSession().createQuery(queryCustomerById);
			query.setParameter("customerId",(customerId));
			List<Customer> customers = query.list();
			if (PmsUtil.isCollectionNotEmpty(customers)) {
				return customers;
			}else{
				return customer;
			}
	}

	@Transactional
	public void createOrUpdateCustomer(Customer customer) throws DataAccessException {
		getSession().saveOrUpdate(customer);
		
	}

	@Transactional
	public boolean deleteCustomerById(String customerId) throws DataAccessException {
		String queryCustomerId = " Update Customer set status :status "+" where id = customerId";
		Query query = getSession().createQuery(queryCustomerId);
		query.setParameter("customerId", Long.parseLong(customerId));
		query.setParameter("status", "N");
		query.executeUpdate();
		return true;
	}

}
