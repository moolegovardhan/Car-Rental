package com.cgs.pro94tek.healthcare.helper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.cgs.pro94tek.healthcare.bean.School;
import com.cgs.pro94tek.healthcare.exeception.PMSException;
import com.cgs.pro94tek.healthcare.modal.SchoolModal;

public class SchoolHelper {

	/**
	 * This method will convert School Object to SchoolModal object
	 * @param school
	 * @return
	 */
	public SchoolModal createschoolModal(School school){
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy"); 
		SchoolModal schoolModal = new SchoolModal();
		schoolModal.setSchoolName(school.getSchoolName());
		schoolModal.setAddressline1(school.getAddressline1());
		schoolModal.setAddressline2(school.getAddressline2());
		schoolModal.setCity(school.getCity());
		schoolModal.setState(school.getState());
		schoolModal.setDistrict(school.getDistrict());
		schoolModal.setZipcode(school.getZipcode());
		schoolModal.setCreatedDate(df.format(school.getCreatedDate()));
		schoolModal.setCreatedby(school.getCreatedBy());
		schoolModal.setPrincipal(school.getPrincipal());
		schoolModal.setStatus(school.getStatus());
		schoolModal.setGovtregno(school.getGovtregno());
		schoolModal.setUnqiueid(school.getUnqiueid());
		schoolModal.setId(school.getId());


		return schoolModal;
	}

	/**
	 * here this method will convert schoolModal to school
	 * @param schoolModal
	 * @return
	 * @throws PMSException
	 * @throws ParseException
	 */
	public School createSchool(SchoolModal schoolModal) throws PMSException, ParseException{
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
		School school = new School();
		school.setSchoolName(schoolModal.getSchoolName());
		school.setAddressline1(schoolModal.getAddressline1());
		school.setAddressline2(schoolModal.getAddressline2());
		school.setCity(schoolModal.getCity());
		school.setState(schoolModal.getState());
		school.setDistrict(schoolModal.getDistrict());
		school.setZipcode(schoolModal.getZipcode());
		school.setCreatedDate(new Date());
		school.setCreatedBy(schoolModal.getCreatedby());
		school.setPrincipal(schoolModal.getPrincipal());
		school.setStatus(schoolModal.getStatus());
		school.setGovtregno(schoolModal.getGovtregno());
		school.setUnqiueid(schoolModal.getUnqiueid());
		school.setId(schoolModal.getId());
		
		return school;
	}

	
}
