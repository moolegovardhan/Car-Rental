package com.cgs.pro94tek.healthcare.helper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cgs.pro94tek.healthcare.bean.StateInfo;
import com.cgs.pro94tek.healthcare.exeception.PMSException;
import com.cgs.pro94tek.healthcare.modal.StateModal;

public class StateHelper {

	public List<StateModal> createStateModal(List<String> state){
		List<StateModal> statemodals = new ArrayList<StateModal>();
		for (String string : state) {
			StateModal statemodal = new StateModal();
			statemodal.setDistrict(string);
			statemodals.add(statemodal);
		}
		return statemodals;
	}
	public StateInfo createState(StateModal statemodal) throws ParseException, PMSException{
		DateFormat df = new SimpleDateFormat("dd/mm/yyyy");
		StateInfo state = new StateInfo();
		state.setId(statemodal.getId());
		state.setState(statemodal.getState());
		state.setDistrict(statemodal.getDistrict());
		state.setVillage(statemodal.getVillage());
		state.setCreateddate(new Date());
		state.setCreatedby(statemodal.getCreatedby());
		state.setOfficeid(statemodal.getOfficeid());
		state.setStatus(statemodal.getStatus());

		return state;

	}
}