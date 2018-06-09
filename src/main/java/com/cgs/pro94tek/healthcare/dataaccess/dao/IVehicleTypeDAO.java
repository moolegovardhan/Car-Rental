package com.cgs.pro94tek.healthcare.dataaccess.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.cgs.pro94tek.healthcare.bean.VehicleType;

public interface IVehicleTypeDAO {

	public List<VehicleType> fetchVehicleTypeById (String vehicletypeId) throws DataAccessException;
	public void createOrUpdateVehicleType (VehicleType vehicletype) throws DataAccessException;
	public boolean deletevehicleById(String vehicletypeId) throws DataAccessException;


}
