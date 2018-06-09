package com.cgs.pro94tek.healthcare.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgs.pro94tek.healthcare.bean.Ward;
import com.cgs.pro94tek.healthcare.dataaccess.dao.IWardDAO;
import com.cgs.pro94tek.healthcare.exeception.PMSException;
import com.cgs.pro94tek.healthcare.helper.WardHelper;
import com.cgs.pro94tek.healthcare.modal.WardModal;
import com.cgs.pro94tek.healthcare.service.IWardDataManagementService;

@Service("wardDataManagementService")
public class WardDataRetrivalServiceImpl implements IWardDataManagementService{
	
	@Autowired
	private IWardDAO warddao;
	
	@Override
	public List<WardModal> fetchWardById(String wardId) throws PMSException {
		List<Ward> ward = warddao.fetchWardById(wardId);
		WardHelper wardhelper = new WardHelper();
		return wardhelper.createwardModal(ward);
	}

	@Override
	public WardModal fetchWardDetails(String wardId) throws PMSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ward fetchWardByName(String wardName) throws PMSException {
		
		return warddao.getWardByName(wardName);
	}

	@Override
	public void createOrUpdateWard(Ward wardEntity) throws PMSException {
		warddao.createOrUpdateWard(wardEntity);
		
	}

	@Override
	public boolean deleteWardById(String wardId) throws PMSException {
		
		return warddao.deleteWardById(wardId);
	}

}
