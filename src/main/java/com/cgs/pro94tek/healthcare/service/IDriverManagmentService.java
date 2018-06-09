package com.cgs.pro94tek.healthcare.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cgs.pro94tek.healthcare.bean.Driver;
import com.cgs.pro94tek.healthcare.exeception.PMSException;
import com.cgs.pro94tek.healthcare.modal.DriverModal;

@Component
public interface IDriverManagmentService {

	
	public List<DriverModal> fetchDriverById(String driverId) throws PMSException;

	public Driver fetchDriverByName(String driverName) throws PMSException;

	public void createOrUpdateDriver(Driver driverEntity) throws PMSException;

	public boolean deleteDriverrById(String driverId) throws PMSException;

}
