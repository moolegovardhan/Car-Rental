package com.cgs.pro94tek.healthcare.dataaccess.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.cgs.pro94tek.healthcare.bean.Ward;

public interface IWardDAO {
	
	public Ward getWardByName(String wardName) throws DataAccessException;
	public List<Ward> fetchWardById(String wardId)throws DataAccessException;
	public void createOrUpdateWard(Ward ward)throws DataAccessException;
	public boolean deleteWardById(String wardId) throws DataAccessException;

	public void deleteCategory(Ward ward)throws DataAccessException;

}
