package com.cgs.pro94tek.healthcare.dataaccess.dao;

import org.springframework.dao.DataAccessException;

import com.cgs.pro94tek.healthcare.bean.DriverMapping;
import com.cgs.pro94tek.healthcare.bean.SchoolDetails;

public interface IDriverMappingDAO {
	

	public DriverMapping fetchDriverMappingById(String drivermappingId)throws DataAccessException;
	
	public void createOrUpdateSchoolDetails(SchoolDetails schoolDetails)throws DataAccessException;

	public boolean deleteSchoolDetailsById(String schoolId) throws DataAccessException;


}
