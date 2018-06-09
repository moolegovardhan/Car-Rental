package com.cgs.pro94tek.healthcare.helper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cgs.pro94tek.healthcare.bean.VehicleTravelling;
import com.cgs.pro94tek.healthcare.exeception.PMSException;
import com.cgs.pro94tek.healthcare.modal.VehicleTravelModal;

public class VehicleTravelHelper {

	public List<VehicleTravelModal> createVehicleModal(List<VehicleTravelling> vehicleTravel){
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy"); 
		List<VehicleTravelModal> vehicletravels = new ArrayList<VehicleTravelModal>();
		for (VehicleTravelling vehicleTravelobj : vehicleTravel) {
			VehicleTravelModal vehicletravelModal1 = new VehicleTravelModal();
			vehicletravelModal1.setId(vehicleTravelobj.getId());
			vehicletravelModal1.setVehicleid(vehicleTravelobj.getVehicleid());
			vehicletravelModal1.setDriverid(vehicleTravelobj.getDriverid());
			vehicletravelModal1.setStartpoint(vehicleTravelobj.getStartpoint());
			vehicletravelModal1.setEndpoint(vehicleTravelobj.getEndpoint());
			vehicletravelModal1.setJourneytype(vehicleTravelobj.getJourneytype());
			vehicletravelModal1.setOtp(vehicleTravelobj.getOtp());
			vehicletravelModal1.setTotaldistencetraveled(vehicleTravelobj.getTotaldistencetraveled());
			vehicletravelModal1.setTotalfare(vehicleTravelobj.getTotalfare());
			vehicletravelModal1.setStatus(vehicleTravelobj.getStatus());
			vehicletravelModal1.setCreatedby(vehicleTravelobj.getCreatedby());
			vehicletravelModal1.setCreateddate(df.format(vehicleTravelobj.getCreateddate()));
			vehicletravelModal1.setOfficeid(vehicleTravelobj.getOfficeid());
			vehicletravels.add(vehicletravelModal1);
		}

		return vehicletravels;
	}


	public VehicleTravelling CreateVehicleTravel(VehicleTravelModal vehicletravelmodal) throws PMSException, ParseException{
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy"); 
		
		VehicleTravelling vtravelling = new VehicleTravelling();
		vtravelling.setId(vehicletravelmodal.getId());
		vtravelling.setDriverid(vehicletravelmodal.getDriverid());
		vtravelling.setVehicleid(vehicletravelmodal.getVehicleid());
		vtravelling.setStartpoint(vehicletravelmodal.getStartpoint());
		vtravelling.setEndpoint(vehicletravelmodal.getEndpoint());
		vtravelling.setJourneytype(vehicletravelmodal.getJourneytype());
		vtravelling.setOtp(vehicletravelmodal.getOtp());
		vtravelling.setTotaldistencetraveled(vehicletravelmodal.getTotaldistencetraveled());
		vtravelling.setTotalfare(vehicletravelmodal.getTotalfare());
		vtravelling.setStatus(vehicletravelmodal.getStatus());
		vtravelling.setCreatedby(vehicletravelmodal.getCreatedby());
		vtravelling.setCreateddate(new Date());
		vtravelling.setOfficeid(vehicletravelmodal.getOfficeid());

		return vtravelling;


	}

}
