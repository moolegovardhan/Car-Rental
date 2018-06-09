package com.cgs.pro94tek.healthcare.helper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cgs.pro94tek.healthcare.bean.Location;
import com.cgs.pro94tek.healthcare.exeception.PMSException;
import com.cgs.pro94tek.healthcare.modal.LocationModal;

public class LocationHelper {
	
	public List<LocationModal> createLocationModal(List<Location> location){
	List<LocationModal> locationModals = new ArrayList<LocationModal>();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		for(Location locationobj : location) {		
			LocationModal locationModal1 = new LocationModal();
			if(locationobj.getId() != null)
			locationModal1.setId(locationobj.getId());
			if(locationobj.getLocation() != null)
			locationModal1.setLocation(locationobj.getLocation());
			if(locationobj.getStatus() != null)
			locationModal1.setStatus(locationobj.getStatus());
			if(locationobj.getCreatedby() != null)
			locationModal1.setCreatedby(locationobj.getCreatedby());
			if(locationobj.getCreateddate() != null)
			locationModal1.setCreateddate(df.format(locationobj.getCreateddate()));
			if(locationobj.getOfficeid() != null)
			locationModal1.setOfficeid(locationobj.getOfficeid());
			locationModals.add(locationModal1);
	}
		return locationModals;
	}

	
	public Location createLocation(LocationModal locationModal) throws ParseException, PMSException{
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		Location location = new Location();
		location.setLocation(locationModal.getLocation());
		location.setCreateddate(new Date());
		location.setCreatedby(locationModal.getCreatedby());
		location.setId(locationModal.getId());
		location.setOfficeid(locationModal.getOfficeid());
		location.setStatus(locationModal.getStatus());
		
		return location;
		
	}
}
