package com.cgs.pro94tek.healthcare.dataaccess.manager;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cgs.pro94tek.healthcare.bean.Patientvoucher;
import com.cgs.pro94tek.healthcare.bean.User;
import com.cgs.pro94tek.healthcare.exeception.PMSException;
@Component
public interface IUserDataAccessManager {
	
	public User authenticateUser(String userId,String password) throws PMSException;
	
	public String insertUserToken(int userid,String username,String profession,String officeid) throws PMSException;

	public User fetchUserInformation(String username) throws PMSException;
	
	public List<Patientvoucher> fetchPatientVoucherDetails(Integer userid) throws PMSException;
}
