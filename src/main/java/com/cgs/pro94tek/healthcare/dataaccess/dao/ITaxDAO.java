package com.cgs.pro94tek.healthcare.dataaccess.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.cgs.pro94tek.healthcare.bean.Tax;

public interface ITaxDAO {
	
	public Tax getTaxByName(String taxName) throws DataAccessException;
	public List<Tax> fetchTaxById(String taxId)throws DataAccessException;
	//public Tax fetchTaxByID(String taxId)throws DataAccessException;
	public void createOrUpdateTax(Tax tax)throws DataAccessException;
	public boolean deleteTaxById(String taxId) throws DataAccessException;
	


}
