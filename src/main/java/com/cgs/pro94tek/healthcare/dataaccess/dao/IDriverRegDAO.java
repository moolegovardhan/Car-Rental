package com.cgs.pro94tek.healthcare.dataaccess.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.cgs.pro94tek.healthcare.bean.Driver;

public interface IDriverRegDAO {
	
	public Driver getDriverByName(String driverName) throws DataAccessException;
	public List<Driver> fetchDriverById(String driverId)throws DataAccessException;
	public void createOrUpdateDriver(Driver driver)throws DataAccessException;
	public boolean deleteDriverById(String driverId) throws DataAccessException;

	
	
	

}
