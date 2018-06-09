package com.cgs.pro94tek.healthcare.dataaccess.dao;

import org.springframework.dao.DataAccessException;

import com.cgs.pro94tek.healthcare.bean.SchoolDetails;

public interface ISchoolDetailsDAO {
	
	public SchoolDetails getSchoolDetailsById(String schoolId) throws DataAccessException;
	
	public SchoolDetails fetchSchoolDetailsById(String schoolId)throws DataAccessException;
	
	public void createOrUpdateSchoolDetails(SchoolDetails schoolDetails)throws DataAccessException;

	public boolean deleteSchoolDetailsById(String schoolId) throws DataAccessException;
	
	public void deleteSchoolDetails(SchoolDetails schoolDetails)throws DataAccessException;

	

}
