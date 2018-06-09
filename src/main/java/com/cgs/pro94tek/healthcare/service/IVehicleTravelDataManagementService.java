package com.cgs.pro94tek.healthcare.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cgs.pro94tek.healthcare.bean.VehicleTravelling;
import com.cgs.pro94tek.healthcare.exeception.PMSException;
import com.cgs.pro94tek.healthcare.modal.VehicleTravelModal;

@Component
public interface IVehicleTravelDataManagementService {
	
	public List<VehicleTravelModal> fetchVehicleTravelDetails(String travelId) throws PMSException;

	public VehicleTravelling fetchVehicleTravelDetailsByNumber(String vehicleNumber) throws PMSException;
	
	public void createOrUpdateVehicleTravelDetails(VehicleTravelling vehicletravelEntity) throws PMSException;

	public boolean deleteVehicleTravelById(String travelId) throws PMSException;

}
