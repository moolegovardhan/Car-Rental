package com.cgs.pro94tek.healthcare.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cgs.pro94tek.healthcare.bean.VehicleType;
import com.cgs.pro94tek.healthcare.exeception.PMSException;
import com.cgs.pro94tek.healthcare.modal.VehicleTypeModal;

@Component
public interface IVehicleTypeDataManagementService {

	
	public List<VehicleTypeModal> fetchVehicleTypeById(String vehicletypeId) throws PMSException;
	
	public void createOrUpdateVehicleType(VehicleType vehicletype) throws PMSException;

	public boolean deleteVehicleTypeById(String vehicletypeId) throws PMSException;
}
