package com.cgs.pro94tek.healthcare.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgs.pro94tek.healthcare.bean.Driver;
import com.cgs.pro94tek.healthcare.dataaccess.dao.IDriverRegDAO;
import com.cgs.pro94tek.healthcare.exeception.PMSException;
import com.cgs.pro94tek.healthcare.helper.DriverRegHelper;
import com.cgs.pro94tek.healthcare.modal.DriverModal;
import com.cgs.pro94tek.healthcare.service.IDriverManagmentService;

@Service("driverDataManagementService")
public class DriverRegistrationDataRetrivalServiceImpl implements IDriverManagmentService{

	@Autowired
	private IDriverRegDAO driverRegDAO;
	
	
	@Override
	public List<DriverModal> fetchDriverById(String driverId) throws PMSException {
		List<Driver> driver = driverRegDAO.fetchDriverById(driverId);
		DriverRegHelper driverreghelper = new DriverRegHelper();
		return driverreghelper.createDriverModal(driver);
	}

	@Override
	public Driver fetchDriverByName(String driverName) throws PMSException {	
		return driverRegDAO.getDriverByName(driverName);
	}

	@Override
	public void createOrUpdateDriver(Driver driverEntity) throws PMSException {
		 driverRegDAO.createOrUpdateDriver(driverEntity);
		
	}

	@Override
	public boolean deleteDriverrById(String driverId) throws PMSException {
		return driverRegDAO.deleteDriverById(driverId);
	}

}
