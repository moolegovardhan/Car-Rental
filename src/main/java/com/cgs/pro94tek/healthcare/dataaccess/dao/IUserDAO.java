package com.cgs.pro94tek.healthcare.dataaccess.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.cgs.pro94tek.healthcare.bean.Patientvoucher;
import com.cgs.pro94tek.healthcare.bean.User;
import com.cgs.pro94tek.healthcare.exeception.PMSException;

public interface IUserDAO {
	
	public User authenticateUser(String userId,String password) throws PMSException;

	public String insertUserToken(long userid,String username,String profession,String officeid) throws PMSException;
	
	public User fetchUserInformation(String userid) throws PMSException;
	
	public List<Patientvoucher> fetchPatientVoucherDetails(Integer userid) throws PMSException;
	public void createOrUpdateUser(User userEntity)throws DataAccessException;
}
