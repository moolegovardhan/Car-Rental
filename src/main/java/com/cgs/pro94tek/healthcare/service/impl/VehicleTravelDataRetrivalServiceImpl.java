package com.cgs.pro94tek.healthcare.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgs.pro94tek.healthcare.bean.VehicleTravelling;
import com.cgs.pro94tek.healthcare.dataaccess.dao.IVehicleTravellingDAO;
import com.cgs.pro94tek.healthcare.exeception.PMSException;
import com.cgs.pro94tek.healthcare.helper.VehicleTravelHelper;
import com.cgs.pro94tek.healthcare.modal.VehicleTravelModal;
import com.cgs.pro94tek.healthcare.service.IVehicleTravelDataManagementService;

@Service("iVehicleTravelDataManagementService")
public class VehicleTravelDataRetrivalServiceImpl implements IVehicleTravelDataManagementService{

	@Autowired
	private	IVehicleTravellingDAO vehicletravellingdao;
	
	@Override
	public List<VehicleTravelModal> fetchVehicleTravelDetails(String travelId) throws PMSException {
		List<VehicleTravelling> vtravelling = vehicletravellingdao.fetchvehicleTravellingById(travelId);
		VehicleTravelHelper vehicletravelhelper = new VehicleTravelHelper();
		
		return vehicletravelhelper.createVehicleModal(vtravelling);
		
	}

	@Override
	public VehicleTravelling fetchVehicleTravelDetailsByNumber(String vehicleNumber) throws PMSException {
		return vehicletravellingdao.getVehicleTravelDetailsByNumber(vehicleNumber);
	}

	@Override
	public void createOrUpdateVehicleTravelDetails(VehicleTravelling vehicletravelEntity) throws PMSException {
		 vehicletravellingdao.createOrUpdateVehicleDetails(vehicletravelEntity);
		
	}

	@Override
	public boolean deleteVehicleTravelById(String travelId) throws PMSException {
	
		return vehicletravellingdao.deleteVehicletravellingById(travelId);
	}

}
