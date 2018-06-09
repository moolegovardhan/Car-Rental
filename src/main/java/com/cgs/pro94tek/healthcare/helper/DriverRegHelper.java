package com.cgs.pro94tek.healthcare.helper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.cgs.pro94tek.healthcare.bean.Driver;
import com.cgs.pro94tek.healthcare.exeception.PMSException;
import com.cgs.pro94tek.healthcare.modal.DriverModal;

public class DriverRegHelper {
	
	public List<DriverModal> createDriverModal(List<Driver> driver){
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy"); 

		List<DriverModal> driverModal = new ArrayList<DriverModal>();
		for(Driver driverobj : driver){
			DriverModal drivermodal1 = new DriverModal();
			drivermodal1.setDriverid(driverobj.getDriverid());
			drivermodal1.setBloodgroup(driverobj.getBloodgroup());
			drivermodal1.setCreateddate(df.format(driverobj.getCreateddate()));
			drivermodal1.setCreatedby(driverobj.getCreatedby());
			drivermodal1.setId(driverobj.getId());
			driverModal.add(drivermodal1);
		}
		


		return driverModal;
	}
	
	public Driver createDriver(DriverModal driverModal) throws PMSException,ParseException{
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
		Driver driver = new Driver();
		driver.setId(driverModal.getId());
		driver.setDriverid(driverModal.getDriverid());
		driver.setLicencenumber(driverModal.getLicencenumber());
		driver.setBloodgroup(driverModal.getBloodgroup());
		driver.setCreateddate(driverModal.getCreateddate());
		driver.setCreatedby(driverModal.getCreatedby());
		driver.setStatus(driverModal.getStatus());
		
		return driver;
	}
	}
	
