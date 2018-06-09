package com.cgs.pro94tek.healthcare.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgs.pro94tek.healthcare.bean.Location;
import com.cgs.pro94tek.healthcare.dataaccess.dao.ILocationDAO;
import com.cgs.pro94tek.healthcare.exeception.PMSException;
import com.cgs.pro94tek.healthcare.helper.LocationHelper;
import com.cgs.pro94tek.healthcare.modal.LocationModal;
import com.cgs.pro94tek.healthcare.service.ILocationDataManagementService;

@Service("iLocationDataManagementService")
public class LocationDataManagementServiceImpl implements ILocationDataManagementService{

	
	@Autowired
	private	ILocationDAO locationdao;
	
//	@Override
//	public LocationModal getLocationById(String locationId) throws PMSException {
//		Location locations = locationdao.fetchLocationById(locationId);
//		LocationHelper locHelper = new LocationHelper();
//		return locHelper.createLocationModal(locations);
//	}

	@Override
	public List<LocationModal> fetchLocationDetailsByName(String locationName) throws PMSException {
		System.out.println("fetcheing data...service.....:"+locationName);
		List<Location> locations = locationdao.fetchLocationBylocationName(locationName);
		LocationHelper locHelper = new LocationHelper();
		System.out.println("LocationHelper in service..........:"+locHelper);
	
		return locHelper.createLocationModal(locations);
	}

	@Override
	public void createOrUpdateLocationDetails(Location locationEntity) throws PMSException {
		 locationdao.createOrUpdateLocation(locationEntity);
		
	}

	@Override
	public boolean deleteLocationById(String locationId) throws PMSException {
	
		return locationdao.deleteLocationById(locationId);
	}

}
