package com.cgs.pro94tek.healthcare.dataaccess.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.cgs.pro94tek.healthcare.bean.Company;

public interface ICompanyDAO {
	

	public Company getCompanyByName(String companyName) throws DataAccessException;
	public List<Company> fetchCompanyById(String companyId)throws DataAccessException;
	//public Tax fetchTaxByID(String taxId)throws DataAccessException;
	public void createOrUpdateCompany(Company company)throws DataAccessException;
	public boolean deleteCompanyById(String copanyId) throws DataAccessException;

}
