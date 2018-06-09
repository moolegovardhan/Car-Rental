package com.cgs.pro94tek.healthcare.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cgs.pro94tek.healthcare.bean.Tax;
import com.cgs.pro94tek.healthcare.exeception.PMSException;
import com.cgs.pro94tek.healthcare.modal.TaxModal;

@Component
public interface ITaxDataManagementService {
	
	public List<TaxModal> fetchTaxById(String taxId) throws PMSException;

	public TaxModal fetchTaxDetails(String taxId) throws PMSException;

	public Tax fetchTaxByName(String taxName) throws PMSException;
	
	public void createOrUpdateTax(Tax taxEntity) throws PMSException;

	public boolean deleteTaxById(String taxId) throws PMSException;
	
	//public boolean deleteTax(String status) throws PMSException;

}
