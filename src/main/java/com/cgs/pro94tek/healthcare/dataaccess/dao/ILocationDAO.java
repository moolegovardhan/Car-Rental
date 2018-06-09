package com.cgs.pro94tek.healthcare.dataaccess.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.cgs.pro94tek.healthcare.bean.Location;
import com.cgs.pro94tek.healthcare.exeception.PMSException;

public interface ILocationDAO {

	//public List<Location> fetchLocationById(String locationId)throws DataAccessException;
	public List<Location> fetchLocationBylocationName(String locationName)throws DataAccessException;
	public boolean deleteLocationById(String locationId) throws DataAccessException;
	public void createOrUpdateLocation(Location locationEntity) throws DataAccessException;
	public boolean deleteLocationByName(String locationName)throws DataAccessException;
	public List<Location> fetchAllLocartionModal(Location locationEntity)throws PMSException;
	
	
	

}
