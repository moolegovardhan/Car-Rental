package com.cgs.pro94tek.healthcare.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgs.pro94tek.healthcare.bean.Company;
import com.cgs.pro94tek.healthcare.dataaccess.dao.ICompanyDAO;
import com.cgs.pro94tek.healthcare.exeception.PMSException;
import com.cgs.pro94tek.healthcare.helper.CompanyHelper;
import com.cgs.pro94tek.healthcare.modal.CompanyModal;
import com.cgs.pro94tek.healthcare.service.ICompanyDataManagementService;

@Service("companyDataManagementService")
public class CompanyDataRetrivalServiceImpl implements ICompanyDataManagementService{
	
	@Autowired
	private	ICompanyDAO companydao;

	@Override
	public List<CompanyModal> fetchCompanyById(String companyId) throws PMSException {
		List<Company> company = companydao.fetchCompanyById(companyId);
		CompanyHelper companyhelper = new CompanyHelper();
		// convert tax object to company modal
		return companyhelper.createcompanyModal(company);
	}

	@Override
	public CompanyModal fetchCompanyDetails(String companyId) throws PMSException {
		return null;
	
	}

	@Override
	public Company fetchCompanyByName(String companyName) throws PMSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createOrUpdateCompany(Company companyEntity) throws PMSException {
		companydao.createOrUpdateCompany(companyEntity);
		
	}

	@Override
	public boolean deleteCompanyById(String companyId) throws PMSException {
		return companydao.deleteCompanyById(companyId);
	}



}
