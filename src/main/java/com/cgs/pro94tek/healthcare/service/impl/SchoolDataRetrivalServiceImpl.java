package com.cgs.pro94tek.healthcare.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgs.pro94tek.healthcare.bean.School;
import com.cgs.pro94tek.healthcare.dataaccess.dao.ISchoolDAO;
import com.cgs.pro94tek.healthcare.exeception.PMSException;
import com.cgs.pro94tek.healthcare.helper.SchoolHelper;
import com.cgs.pro94tek.healthcare.modal.SchoolModal;
import com.cgs.pro94tek.healthcare.service.ISchoolDataRetrivalService;

@Service("schoolDataRetrivalService")
public class SchoolDataRetrivalServiceImpl implements ISchoolDataRetrivalService{

	@Autowired
	private ISchoolDAO schooldao;


	@Override
	public School fetchSchoolByName(String schoolName) throws PMSException {

		return schooldao.getSchoolByName(schoolName);
	}

	@Override
	public SchoolModal fetchSchoolById(String schoolId) throws PMSException {
		School school = schooldao.fetchSchoolById(schoolId);
		SchoolHelper schoolhelper = new SchoolHelper();
		// convert school object to shoolmodal
		return schoolhelper.createschoolModal(school);
	}

	@Override
	public SchoolModal fetchSchoolDetails(String schoolId) throws PMSException {

		return null;
	}

	@Override
	public void createOrUpdateSchool(School schoolEntity) throws PMSException{
		schooldao.createOrUpdateSchool(schoolEntity);

	}

	@Override
	public boolean deleteSchoolById(String schoolId) throws PMSException {

		return schooldao.deleteSchoolById(schoolId);
	}

	/*@Override
	public School getSchoolById(String schoolId) throws PMSException {

		return schoolDataAccessManager.getSchoolById(schoolId);
	}*/



	/*public School updateSchool(String schoolId) throws PMSException {
		 return schoolDataAccessManager.updateSchool(schoolId);

	}*/


	/*public void deleteSchool(School school) throws PMSException {
		schooldao.deleteSchool(school);

	}*/

	/*public List<SchoolModal> updateSchoolById(String schoolId) throws PMSException {
		// TODO Auto-generated method stub
		// Here use School helper and convert the School object to SchoolModal object
		List<SchoolModal> schoolModal = new ArrayList<SchoolModal>();
		
		List<SchoolModal> school = (List<SchoolModal>) schoolDataAccessManager.fetchSchoolById(schoolId);
		SchoolHelper schoolHelper = new SchoolHelper();
		schoolHelper.createschoolModal(school); // you are just converting School object to SchoolModal Object
		
			
		return schoolModal;
	}*/

	

}
