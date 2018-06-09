package com.cgs.pro94tek.healthcare.helper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cgs.pro94tek.healthcare.bean.Tax;
import com.cgs.pro94tek.healthcare.exeception.PMSException;
import com.cgs.pro94tek.healthcare.modal.TaxModal;

public class TaxHelper {


	/**
	 * This method will convert Tax Object to TaxModal object
	 * @param tax
	 * @return
	 */
	public List<TaxModal> createtaxModal(List<Tax> tax){
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy"); 
		List<TaxModal> taxModals = new ArrayList<TaxModal>();
		for(Tax taxobj :tax){
			TaxModal taxmodal1 = new TaxModal();
			taxmodal1.setTaxname(taxobj.getTaxname());
			taxmodal1.setTaxdesc(taxobj.getTaxdesc());
			taxmodal1.setTaxrate(taxobj.getTaxrate());
			taxmodal1.setCreatedDate(df.format(taxobj.getCreatedDate()));
			taxmodal1.setCreatedby(taxobj.getCreatedBy());
			taxmodal1.setStatus(taxobj.getStatus());
			taxmodal1.setOfficeid(taxobj.getOfficeid());
			taxmodal1.setId(taxobj.getId());
			taxModals.add(taxmodal1);
		}
		

		return taxModals;
	}

	/**
	 * here this method will convert taxModal to tax
	 * @param taxModal
	 * @return
	 * @throws PMSException
	 * @throws ParseException
	 */
	public Tax createTax(TaxModal taxModal) throws PMSException, ParseException{
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
		Tax tax = new Tax();
		tax.setTaxname(taxModal.getTaxname());
		tax.setTaxdesc(taxModal.getTaxdesc());
		tax.setTaxrate(taxModal.getTaxrate());
		tax.setCreatedDate(new Date());
		tax.setCreatedBy(taxModal.getCreatedby());
		tax.setStatus(taxModal.getStatus());
		tax.setOfficeid(taxModal.getOfficeid());
		tax.setId(taxModal.getId());
		return tax;
	}



}
