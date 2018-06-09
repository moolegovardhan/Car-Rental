package com.cgs.pro94tek.healthcare.helper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cgs.pro94tek.healthcare.bean.Ward;
import com.cgs.pro94tek.healthcare.exeception.PMSException;
import com.cgs.pro94tek.healthcare.modal.WardModal;

public class WardTypeHelper {
	
	public List<WardModal> createwardModal(List<Ward> ward){
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy"); 
		List<WardModal> WardModals = new ArrayList<WardModal>();
		for (Ward wardobj : ward) {
			WardModal wardModal1 = new WardModal();
			wardModal1.setWardname(wardobj.getWardname());
			wardModal1.setWardtype(wardobj.getWardtype());
			wardModal1.setOfficeid(wardobj.getOfficeid());
			wardModal1.setTotaloccupied(wardobj.getTotaloccupied());
			wardModal1.setBedscount(wardobj.getBedscount());
			wardModal1.setDiscount(wardobj.getDiscount());
			wardModal1.setCreatedDate(df.format(wardobj.getCreatedDate()));
			wardModal1.setCreatedBy(wardobj.getCreatedBy());
			wardModal1.setStatus(wardobj.getStatus());
			wardModal1.setBedcost(wardobj.getBedcost());
			wardModal1.setFinalcost(wardobj.getFinalcost());
			wardModal1.setChargescost(wardobj.getChargescost());
			wardModal1.setId(wardobj.getId());
			WardModals.add(wardModal1);
		}
		


		return WardModals;
	}

	/**
	 * here this method will convert wardModal to ward
	 * @param wardModal
	 * @return
	 * @throws PMSException
	 * @throws ParseException
	 */
	public Ward createWard(WardModal wardModal) throws PMSException, ParseException{
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
		Ward ward = new Ward();
		ward.setWardname(wardModal.getWardname());
		ward.setWardtype(wardModal.getWardtype());
		ward.setOfficeid(wardModal.getOfficeid());
		ward.setTotaloccupied(wardModal.getTotaloccupied());
		ward.setBedscount(wardModal.getBedscount());
		ward.setDiscount(wardModal.getDiscount());
		ward.setCreatedDate(new Date());
		ward.setCreatedBy(wardModal.getCreatedBy());
		ward.setStatus(wardModal.getStatus());
		ward.setBedcost(wardModal.getBedcost());
		ward.setFinalcost(ward.getFinalcost());
		ward.setChargescost(wardModal.getChargescost());
		ward.setId(wardModal.getId());
		
		return ward;
	}

}
