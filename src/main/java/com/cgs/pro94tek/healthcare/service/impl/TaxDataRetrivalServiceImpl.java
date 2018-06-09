package com.cgs.pro94tek.healthcare.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgs.pro94tek.healthcare.bean.Tax;
import com.cgs.pro94tek.healthcare.dataaccess.dao.ITaxDAO;
import com.cgs.pro94tek.healthcare.exeception.PMSException;
import com.cgs.pro94tek.healthcare.helper.TaxHelper;
import com.cgs.pro94tek.healthcare.modal.TaxModal;
import com.cgs.pro94tek.healthcare.service.ITaxDataManagementService;

@Service("taxDataManagementService")
public class TaxDataRetrivalServiceImpl implements ITaxDataManagementService{

	@Autowired
	private	ITaxDAO taxdao;
	//here is the actual business logic for db calls (DAO classes are only for fetching data from Database) 
	//ServiceImpl classes will have actual business logic
	//after fetching data from DAO classes, if you want to do any processing on the fetched data then it is the business logic. Which must be in serviceImpl classes
	//DAO classes will have basic CRUD operations create read, delete,update operations
	@Override
	public List<TaxModal> fetchTaxById(String taxId) throws PMSException {
		List<Tax> tax = taxdao.fetchTaxById(taxId);
		TaxHelper taxhelper = new TaxHelper();
		// convert tax object to taxmodal
		return taxhelper.createtaxModal(tax);
	}

	@Override
	public TaxModal fetchTaxDetails(String taxId) throws PMSException {

		return null;
	}

	@Override
	public Tax fetchTaxByName(String taxName) throws PMSException {

		return taxdao.getTaxByName(taxName);
	}

	@Override
	public void createOrUpdateTax(Tax taxEntity) throws PMSException {
		taxdao.createOrUpdateTax(taxEntity);

	}

	@Override
	public boolean deleteTaxById(String taxId) throws PMSException {
		return taxdao.deleteTaxById(taxId);
	}

}
