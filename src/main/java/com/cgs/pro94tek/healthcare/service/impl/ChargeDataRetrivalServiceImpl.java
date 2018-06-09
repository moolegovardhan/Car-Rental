package com.cgs.pro94tek.healthcare.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgs.pro94tek.healthcare.bean.Charge;
import com.cgs.pro94tek.healthcare.dataaccess.dao.IChargeDAO;
import com.cgs.pro94tek.healthcare.exeception.PMSException;
import com.cgs.pro94tek.healthcare.helper.ChargeHelper;
import com.cgs.pro94tek.healthcare.modal.ChargeModal;
import com.cgs.pro94tek.healthcare.service.IChargeDataManagementService;

@Service("chargeDataManagementService")
public class ChargeDataRetrivalServiceImpl implements IChargeDataManagementService{
	
	@Autowired
	private IChargeDAO chargedao;

	@Override
	public List<ChargeModal> fetchChargeById(String chargeId) throws PMSException {
		List<Charge> charge = chargedao.fetchChargeById(chargeId);
		ChargeHelper chargehelper = new ChargeHelper();
		return chargehelper.createchargeModal(charge);
	}

	@Override
	public ChargeModal fetchChargeDetails(String chargeId) throws PMSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Charge fetchChargeByName(String chargesName) throws PMSException {
		return chargedao.getChargeByName(chargesName);
	}

	@Override
	public void createOrUpdateCharge(Charge chargeEntity) throws PMSException {
		chargedao.createOrUpdateCharge(chargeEntity);
		
	}

	@Override
	public boolean deleteChargeById(String chargeId) throws PMSException {
		return deleteChargeById(chargeId);
	}

}
