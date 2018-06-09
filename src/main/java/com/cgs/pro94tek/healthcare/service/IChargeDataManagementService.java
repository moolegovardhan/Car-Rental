package com.cgs.pro94tek.healthcare.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cgs.pro94tek.healthcare.bean.Charge;
import com.cgs.pro94tek.healthcare.exeception.PMSException;
import com.cgs.pro94tek.healthcare.modal.ChargeModal;

@Component
public interface IChargeDataManagementService {
	
	public List<ChargeModal> fetchChargeById(String chargeId) throws PMSException;

	public ChargeModal fetchChargeDetails(String chargeId) throws PMSException;

	public Charge fetchChargeByName(String chargeName) throws PMSException;

	public void createOrUpdateCharge(Charge chargeEntity) throws PMSException;

	public boolean deleteChargeById(String chargeId) throws PMSException;

}
