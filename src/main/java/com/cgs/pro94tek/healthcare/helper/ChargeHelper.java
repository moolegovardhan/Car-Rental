package com.cgs.pro94tek.healthcare.helper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cgs.pro94tek.healthcare.bean.Charge;
import com.cgs.pro94tek.healthcare.exeception.PMSException;
import com.cgs.pro94tek.healthcare.modal.ChargeModal;

public class ChargeHelper {
	

	/**
	 * This method will convert Charge Object to ChargeModal object
	 * @param Charge
	 * @return
	 */
	public List<ChargeModal> createchargeModal(List<Charge> charge){
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy"); 
		
		List<ChargeModal> chargeModals = new ArrayList<ChargeModal>();
		for (Charge chargeobj : charge) {
			ChargeModal chargemodal1 = new ChargeModal();
			chargemodal1.setApplyid(chargeobj.getApplyid());
			chargemodal1.setChargeid(chargeobj.getChargeid());
			chargemodal1.setChargename(chargeobj.getChargename());
			chargemodal1.setEffectivedate(chargeobj.getEffectivedate());
			chargemodal1.setCreatedDate(df.format(chargeobj.getCreatedDate()));
			chargemodal1.setCreatedBy(chargeobj.getCreatedBy());
			chargemodal1.setOfficeid(chargeobj.getOfficeid());
			chargemodal1.setStatus(chargeobj.getStatus());
			chargemodal1.setApplyname(chargeobj.getApplyname());
			chargemodal1.setChargetype(chargeobj.getChargetype());
			chargemodal1.setId(chargeobj.getId());
			chargeModals.add(chargemodal1);
		}

		return chargeModals;
	}

	/**
	 * here this method will convert ChargeModal to charge
	 * @param ChargeModal
	 * @return
	 * @throws PMSException
	 * @throws ParseException
	 */
	public Charge createCharge(ChargeModal chargeModal) throws PMSException, ParseException{
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
		Charge charge = new Charge();
		charge.setApplyid(chargeModal.getApplyid());
		charge.setChargeid(chargeModal.getChargeid());
		charge.setChargename(chargeModal.getChargename());
		charge.setEffectivedate(chargeModal.getEffectivedate());
		charge.setCreatedDate(new Date());
		charge.setCreatedBy(chargeModal.getCreatedBy());
		charge.setOfficeid(chargeModal.getOfficeid());
		charge.setStatus(chargeModal.getStatus());
		charge.setApplyname(chargeModal.getApplyname());
		charge.setChargetype(chargeModal.getChargetype());
		charge.setId(chargeModal.getId());
		
		return charge;
	}


}
