package com.cgs.pro94tek.healthcare.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cgs.pro94tek.healthcare.bean.Vehicle;
import com.cgs.pro94tek.healthcare.exeception.PMSException;
import com.cgs.pro94tek.healthcare.modal.VehicleModal;

@Component
public interface IVehicleDataManagementService {

	public List<VehicleModal> fetchVehicleById(String vehicleId) throws PMSException;

	public VehicleModal fetchVehicleDetails(String vehicleId) throws PMSException;

	public Vehicle fetchVehicleByNumber(String vehicleNumber) throws PMSException;
	
	public void createOrUpdateVehicle(Vehicle vehicleEntity) throws PMSException;

	public boolean deleteVehicleById(String vehicleId) throws PMSException;
}
