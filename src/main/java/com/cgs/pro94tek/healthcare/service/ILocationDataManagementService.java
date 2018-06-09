package com.cgs.pro94tek.healthcare.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cgs.pro94tek.healthcare.bean.Location;
import com.cgs.pro94tek.healthcare.exeception.PMSException;
import com.cgs.pro94tek.healthcare.modal.LocationModal;

@Component
public interface ILocationDataManagementService {

	
	//public LocationModal getLocationById(String locationId) throws PMSException;
	public List<LocationModal> fetchLocationDetailsByName(String locationName) throws PMSException;
	public void createOrUpdateLocationDetails(Location locationEntity) throws PMSException;
	public boolean deleteLocationById(String locationId) throws PMSException;
	
	/*public LocationModal fetchLocationDetailsByName(String locationName)throws PMSException;
	public LocationModal fetchLocationById(String locationId) throws PMSException;
	public void createOrUpdateLocation(Location locationEntity) throws PMSException;
	public boolean deleteLocationById(String locationId) throws PMSException;
	public boolean deleteLocationByName(String locationName)throws PMSException;
	public List<LocationModal> fetchAllLocationModal(Location locationEntity)throws PMSException;*/
}
