package com.cgs.pro94tek.healthcare.service;

import org.springframework.stereotype.Component;

import com.cgs.pro94tek.healthcare.bean.School;
import com.cgs.pro94tek.healthcare.exeception.PMSException;
import com.cgs.pro94tek.healthcare.modal.SchoolModal;

@Component
public interface ISchoolDataRetrivalService {

	public SchoolModal fetchSchoolById(String schoolId) throws PMSException;

	public SchoolModal fetchSchoolDetails(String schoolId) throws PMSException;

	public School fetchSchoolByName(String schoolName) throws PMSException;

	public void createOrUpdateSchool(School schoolEntity) throws PMSException;

	public boolean deleteSchoolById(String schoolId) throws PMSException;

	/*public School updateSchoolById(SchoolModal schoolModal) throws PMSException;
*/
}
