package com.cgs.pro94tek.healthcare.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cgs.pro94tek.healthcare.exeception.PMSException;
import com.cgs.pro94tek.healthcare.modal.StateModal;

@Component
public interface IStateDataManagementService {
	
	public List<StateModal> fetchDistrictInfoBystateName(String stateName) throws PMSException;

}
