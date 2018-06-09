package com.cgs.pro94tek.healthcare.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgs.pro94tek.healthcare.dataaccess.dao.IStateDAO;
import com.cgs.pro94tek.healthcare.exeception.PMSException;
import com.cgs.pro94tek.healthcare.helper.StateHelper;
import com.cgs.pro94tek.healthcare.modal.StateModal;
import com.cgs.pro94tek.healthcare.service.IStateDataManagementService;

@Service("iStateDataManagementService")
public class StateDataRetrivalServiceImpl implements IStateDataManagementService{

	@Autowired
	private	IStateDAO statedao;
	
	@Override
	public List<StateModal> fetchDistrictInfoBystateName(String stateName) throws PMSException {
		System.out.println("fetcheing data...State.....:"+stateName);
		List<String> state = statedao.fetchDistrictByStateName(stateName);
		StateHelper stateHelper = new StateHelper();
		System.out.println("stateHelper in service..........:"+stateHelper);
	
		return stateHelper.createStateModal(state);
	}

}
