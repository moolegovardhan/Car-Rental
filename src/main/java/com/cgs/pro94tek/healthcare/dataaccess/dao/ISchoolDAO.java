package com.cgs.pro94tek.healthcare.dataaccess.dao;

import org.springframework.dao.DataAccessException;

import com.cgs.pro94tek.healthcare.bean.School;

public interface ISchoolDAO {

	public School getSchoolByName(String schoolName) throws DataAccessException;

	/*public School getSchoolById(String schoolId) throws DataAccessException;*/

	public void createOrUpdateSchool(School school)throws DataAccessException;

	/*public School updateSchool(School school)throws DataAccessException;*/

	public School fetchSchoolById(String schoolId)throws DataAccessException;

	public boolean deleteSchoolById(String schoolId) throws DataAccessException;


}
