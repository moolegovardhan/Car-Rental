package com.cgs.pro94tek.healthcare.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgs.pro94tek.healthcare.bean.Vehicle;
import com.cgs.pro94tek.healthcare.dataaccess.dao.IVehicleDAO;
import com.cgs.pro94tek.healthcare.exeception.PMSException;
import com.cgs.pro94tek.healthcare.helper.VehicleHelper;
import com.cgs.pro94tek.healthcare.modal.VehicleModal;
import com.cgs.pro94tek.healthcare.service.IVehicleDataManagementService;

@Service("vehicleDataManagementService")
public class VehicleDataRetrivalServiceImpl implements IVehicleDataManagementService{

	@Autowired
	private IVehicleDAO vehicledao;
	
	@Override
	public List<VehicleModal> fetchVehicleById(String vehicleId) throws PMSException {
		List<Vehicle> vehicle = vehicledao.fetchvehicleById(vehicleId);
		VehicleHelper vehiclehelper = new VehicleHelper();
		return vehiclehelper.createVehicleModal(vehicle);
	}

	@Override
	public VehicleModal fetchVehicleDetails(String vehicleId) throws PMSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vehicle fetchVehicleByNumber(String vehicleNumber) throws PMSException {
		
		return vehicledao.getVehicleDetailsByNumber(vehicleNumber);
		
	}

	@Override
	public void createOrUpdateVehicle(Vehicle vehicleEntity) throws PMSException {
		vehicledao.createOrUpdateVehicle(vehicleEntity);
		
	}

	@Override
	public boolean deleteVehicleById(String vehicleId) throws PMSException {
	
		return vehicledao.deleteVehicleById(vehicleId);
	}

}
