package com.cgs.pro94tek.healthcare.dataaccess.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.cgs.pro94tek.healthcare.bean.StateInfo;

public interface IStateDAO {

	
	public List<String> fetchDistrictByStateName(String stateName)throws DataAccessException;
}
