package com.cgs.pro94tek.healthcare.helper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cgs.pro94tek.healthcare.bean.Vehicle;
import com.cgs.pro94tek.healthcare.exeception.PMSException;
import com.cgs.pro94tek.healthcare.modal.VehicleModal;

public class VehicleHelper {

	public List<VehicleModal> createVehicleModal(List<Vehicle> vehicle){
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy"); 
		List<VehicleModal> vehicleModals = new ArrayList<VehicleModal>();
		for(Vehicle vehicleobj :vehicle){
			VehicleModal vehiclemodal1 = new VehicleModal();
			vehiclemodal1.setVehicletypeid(vehicleobj.getVehicletypeid());
			vehiclemodal1.setOwnername(vehicleobj.getOwnername());
			vehiclemodal1.setChessisnumber(vehicleobj.getChessisnumber());
			vehiclemodal1.setOwnermobile(vehicleobj.getOwnermobile());
			vehiclemodal1.setDateofpurchase(df.format(vehicleobj.getDateofpurchase()));
			vehiclemodal1.setPollutionexpdate(df.format(vehicleobj.getPollutionexpdate()));
			vehiclemodal1.setFitnessexpdate(df.format(vehicleobj.getFitnessexpdate()));
			vehiclemodal1.setRoadtax(vehicleobj.getRoadtax());
			vehiclemodal1.setCreateddate(df.format(vehicleobj.getCreateddate()));
			vehiclemodal1.setCreatedby(vehicleobj.getCreatedby());
			vehiclemodal1.setStatus(vehicleobj.getStatus());
			vehiclemodal1.setOfficeid(vehicleobj.getOfficeid());
			vehiclemodal1.setId(vehicleobj.getId());
			vehicleModals.add(vehiclemodal1);
		}
		

		return vehicleModals;
	}

	/**
	 * here this method will convert vehiclemodal to vehicle
	 * @param vehiclemodal
	 * @return
	 * @throws PMSException
	 * @throws ParseException
	 */
	public Vehicle createVehicle(VehicleModal vehiclemodal) throws PMSException, ParseException{
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy"); 
	
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicletypeid(vehiclemodal.getVehicletypeid());
		vehicle.setOwnername(vehiclemodal.getOwnername());
		vehicle.setVehiclenumber(vehiclemodal.getVehiclenumber());
		vehicle.setChessisnumber(vehiclemodal.getChessisnumber());
		vehicle.setOwnermobile(vehiclemodal.getOwnermobile());
		vehicle.setDateofpurchase(df.parse(vehiclemodal.getDateofpurchase()));
		vehicle.setPollutionexpdate(df.parse(vehiclemodal.getPollutionexpdate()));
		vehicle.setFitnessexpdate(df.parse(vehiclemodal.getFitnessexpdate()));
		vehicle.setRoadtax(vehiclemodal.getRoadtax());
		vehicle.setCreateddate(new Date());
		vehicle.setCreatedby(vehiclemodal.getCreatedby());
		vehicle.setStatus(vehiclemodal.getStatus());
		vehicle.setOfficeid(vehiclemodal.getOfficeid());
		vehicle.setId(vehiclemodal.getId());
		return vehicle;
	}



}
