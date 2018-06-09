package com.cgs.pro94tek.healthcare.dataaccess.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.cgs.pro94tek.healthcare.bean.Vehicle;

public interface IVehicleDAO {


	public Vehicle getVehicleDetailsByNumber(String vehicleNumber) throws DataAccessException;
	public List<Vehicle> fetchvehicleById(String vehicleId)throws DataAccessException;
	public void createOrUpdateVehicle(Vehicle vehicle)throws DataAccessException;
	public boolean deleteVehicleById(String vehicleId) throws DataAccessException;


}
