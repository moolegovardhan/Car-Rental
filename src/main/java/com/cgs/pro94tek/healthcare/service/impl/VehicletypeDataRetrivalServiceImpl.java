package com.cgs.pro94tek.healthcare.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgs.pro94tek.healthcare.bean.VehicleType;
import com.cgs.pro94tek.healthcare.dataaccess.dao.IVehicleTypeDAO;
import com.cgs.pro94tek.healthcare.exeception.PMSException;
import com.cgs.pro94tek.healthcare.helper.VehicleTypeHelper;
import com.cgs.pro94tek.healthcare.modal.VehicleTypeModal;
import com.cgs.pro94tek.healthcare.service.IVehicleTypeDataManagementService;

@Service("vehicleTypeDataManagementService")
public class VehicletypeDataRetrivalServiceImpl implements IVehicleTypeDataManagementService{

	@Autowired
	private IVehicleTypeDAO vehicletypedao;
	
	@Override
	public List<VehicleTypeModal> fetchVehicleTypeById(String vehicletypeId) throws PMSException {
		List<VehicleType> vehicletype = vehicletypedao.fetchVehicleTypeById(vehicletypeId);
		VehicleTypeHelper vtypehelper = new VehicleTypeHelper();
		return vtypehelper.createVehicleTypeModal(vehicletype);
	}

	@Override
	public void createOrUpdateVehicleType(VehicleType vehicletype) throws PMSException {
		vehicletypedao.createOrUpdateVehicleType(vehicletype);
		
	}

	@Override
	public boolean deleteVehicleTypeById(String vehicletypeId) throws PMSException {
		return  vehicletypedao.deletevehicleById(vehicletypeId);
	}

}
