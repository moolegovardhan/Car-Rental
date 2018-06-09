package com.cgs.pro94tek.healthcare.dataaccess.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.cgs.pro94tek.healthcare.bean.WardType;

public interface IWardTypeDAO {
	
	public WardType getWardTypeByName (String wardTypeName) throws DataAccessException;

	   public List<WardType> getWardTypeByWardId (String wardId) throws DataAccessException;
	   public void createOrUpdateWardType (WardType wardtype) throws DataAccessException;
	   public boolean deleteWardById(String wardId) throws DataAccessException;
	   
	   public void deleteWardType (String wardtype) throws DataAccessException;

}
