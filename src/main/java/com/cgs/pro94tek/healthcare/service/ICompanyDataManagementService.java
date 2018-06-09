package com.cgs.pro94tek.healthcare.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cgs.pro94tek.healthcare.bean.Company;
import com.cgs.pro94tek.healthcare.exeception.PMSException;
import com.cgs.pro94tek.healthcare.modal.CompanyModal;

@Component
public interface ICompanyDataManagementService {
	
	public List<CompanyModal> fetchCompanyById(String companyId) throws PMSException;

	public CompanyModal fetchCompanyDetails(String companyId) throws PMSException;

	public Company fetchCompanyByName(String companyName) throws PMSException;
	
	public void createOrUpdateCompany(Company companyEntity) throws PMSException;

	public boolean deleteCompanyById(String companyId) throws PMSException;

}
