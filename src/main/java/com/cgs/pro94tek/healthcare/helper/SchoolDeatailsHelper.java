package com.cgs.pro94tek.healthcare.helper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.cgs.pro94tek.healthcare.bean.SchoolDetails;
import com.cgs.pro94tek.healthcare.exeception.PMSException;
import com.cgs.pro94tek.healthcare.modal.SchoolDetailsModal;

public class SchoolDeatailsHelper {
	
	public SchoolDetailsModal createschooldetailsModal(SchoolDetails schooldetails){
		@SuppressWarnings("unused")
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy"); 
		SchoolDetailsModal schooldetailsModal = new SchoolDetailsModal();
	



		return schooldetailsModal;
	}

	/**
	 * here this method will convert schoolModal to school
	 * @param schoolModal
	 * @return
	 * @throws PMSException
	 * @throws ParseException
	 */
	public SchoolDetails createSchoolDetails(SchoolDetailsModal schooldetailsModal) throws PMSException, ParseException{
		@SuppressWarnings("unused")
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
		SchoolDetails schooldetails = new SchoolDetails();
		
		
		return schooldetails;
	}


}
