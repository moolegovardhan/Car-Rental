package com.cgs.pro94tek.healthcare.dataaccess.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.cgs.pro94tek.healthcare.bean.Charge;


public interface IChargeDAO {
	
	public Charge getChargeByName(String ChargeName) throws DataAccessException;
	public List<Charge> fetchChargeById(String chargeId)throws DataAccessException;
	public void createOrUpdateCharge(Charge charge)throws DataAccessException;
	public boolean deleteChargeById(String chargeId) throws DataAccessException;

}
