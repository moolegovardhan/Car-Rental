package com.cgs.pro94tek.healthcare.helper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cgs.pro94tek.healthcare.bean.VehicleType;
import com.cgs.pro94tek.healthcare.exeception.PMSException;
import com.cgs.pro94tek.healthcare.modal.VehicleTypeModal;

public class VehicleTypeHelper {

	
	public List<VehicleTypeModal> createVehicleTypeModal(List<VehicleType> vehicleType) {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		List<VehicleTypeModal> VehicleTypeModals = new ArrayList<VehicleTypeModal>();
		for (VehicleType vehicleTypeobj : vehicleType) {
			VehicleTypeModal vehiclTypeModal1 = new VehicleTypeModal();
			vehiclTypeModal1.setId(vehicleTypeobj.getId());
			vehiclTypeModal1.setType(vehicleTypeobj.getType());
			vehiclTypeModal1.setDescription(vehicleTypeobj.getDescription());
			vehiclTypeModal1.setCreatedby(vehicleTypeobj.getCreatedby());
			vehiclTypeModal1.setCreateddate(df.format(vehicleTypeobj.getCreateddate()));
			vehiclTypeModal1.setStatus(vehicleTypeobj.getStatus());
			vehiclTypeModal1.setOffiecid(vehicleTypeobj.getOfficeid());
			VehicleTypeModals.add(vehiclTypeModal1);
		}
		return VehicleTypeModals;
		
	}
	
	public VehicleType createVehicleType(VehicleTypeModal vehicleTypeModal) throws PMSException,ParseException{
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
		VehicleType vehicletype = new VehicleType();
		vehicletype.setType(vehicleTypeModal.getType());
		vehicletype.setId(vehicleTypeModal.getId());
		vehicletype.setType(vehicleTypeModal.getType());
		vehicletype.setDescription(vehicleTypeModal.getDescription());
		vehicletype.setStatus(vehicleTypeModal.getStatus());
		vehicletype.setCreateddate(new Date());
		vehicletype.setCreatedby(vehicleTypeModal.getCreatedby());
		vehicletype.setOfficeid(vehicleTypeModal.getOffiecid());
		return vehicletype;
		
		
	}
	
}
