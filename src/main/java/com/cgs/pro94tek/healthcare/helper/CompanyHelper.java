package com.cgs.pro94tek.healthcare.helper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cgs.pro94tek.healthcare.bean.Company;
import com.cgs.pro94tek.healthcare.exeception.PMSException;
import com.cgs.pro94tek.healthcare.modal.CompanyModal;

public class CompanyHelper {
	
	public List<CompanyModal> createcompanyModal(List<Company> company){
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy"); 
		
		List<CompanyModal> companyModals = new ArrayList<CompanyModal>();
		for(Company companyobj : company){
			CompanyModal companymodal1 = new CompanyModal();
			companymodal1.setDisplayName(companyobj.getDisplayName());
			companymodal1.setSignatureInNameOf(companyobj.getSignatureInNameOf());
			companymodal1.setMailingaddress(companyobj.getMailingaddress());
			companymodal1.setBillingaddress(companyobj.getBillingaddress());
			companymodal1.setCorporateaddress(companyobj.getCorporateaddress());
			companymodal1.setDateOfIncorporation(companyobj.getDateOfIncorporation());
			companymodal1.setLogo(companyobj.getLogo());
			companymodal1.setMobileNo(companyobj.getMobileNo());
			companymodal1.setLandlineNo(companyobj.getLandlineNo());
			companymodal1.setEmail(companyobj.getEmail());
			companymodal1.setCreatedDate(df.format(companyobj.getCreatedDate()));
			companymodal1.setCreatedBy(companyobj.getCreatedBy());
			companymodal1.setOfficeId(companyobj.getOfficeId());
			companymodal1.setStatus(companyobj.getStatus());
			companymodal1.setIsDealer(companyobj.getIsDealer());
			companymodal1.setIsRetailer(companyobj.getIsRetailer());
			companymodal1.setSetupdate(companyobj.getSetupdate());
			companymodal1.setId(companyobj.getId());
			companyModals.add(companymodal1);
		}
		


		return companyModals;
	}


	public Company createCompany(CompanyModal companyModal) throws PMSException, ParseException{
		@SuppressWarnings("unused")
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
		Company company = new Company();
		company.setDisplayName(companyModal.getDisplayName());
		company.setSignatureInNameOf(companyModal.getSignatureInNameOf());
		company.setMailingaddress(companyModal.getMailingaddress());
		company.setBillingaddress(companyModal.getBillingaddress());
		company.setCorporateaddress(companyModal.getCorporateaddress());
		company.setDateOfIncorporation(companyModal.getDateOfIncorporation());
		company.setLogo(companyModal.getLogo());
		company.setMobileNo(companyModal.getMobileNo());
		company.setLandlineNo(companyModal.getLandlineNo());
		company.setEmail(companyModal.getEmail());
		company.setCreatedDate(new Date());
		company.setCreatedBy(companyModal.getCreatedBy());
		company.setOfficeId(companyModal.getOfficeId());
		company.setStatus(companyModal.getStatus());
		company.setIsDealer(companyModal.getIsDealer());
		company.setIsRetailer(companyModal.getIsRetailer());
		company.setSetupdate(companyModal.getSetupdate());
		company.setId(companyModal.getId());
		
		return company;
	}


}
