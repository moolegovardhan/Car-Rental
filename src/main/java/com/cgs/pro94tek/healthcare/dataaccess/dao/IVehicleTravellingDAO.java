package com.cgs.pro94tek.healthcare.dataaccess.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.cgs.pro94tek.healthcare.bean.VehicleTravelling;


public interface IVehicleTravellingDAO {
	
	public VehicleTravelling getVehicleTravelDetailsByNumber(String vehicleNumber) throws DataAccessException;
	public List<VehicleTravelling> fetchvehicleTravellingById(String travelId)throws DataAccessException;
	public void createOrUpdateVehicleDetails(VehicleTravelling vehicletravelling)throws DataAccessException;
	public boolean deleteVehicletravellingById(String travelId) throws DataAccessException;

}
