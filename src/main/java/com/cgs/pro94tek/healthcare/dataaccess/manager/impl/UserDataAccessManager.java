package com.cgs.pro94tek.healthcare.dataaccess.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.cgs.pro94tek.healthcare.bean.Patientvoucher;
import com.cgs.pro94tek.healthcare.bean.User;
import com.cgs.pro94tek.healthcare.dataaccess.dao.IUserDAO;
import com.cgs.pro94tek.healthcare.dataaccess.manager.IUserDataAccessManager;
import com.cgs.pro94tek.healthcare.exeception.PMSException;


@Service ("userDataAccessManager")
public class UserDataAccessManager implements IUserDataAccessManager {

	  @Autowired
	   private IUserDAO userDAO;
	
	@Override
	public User authenticateUser(String userId, String password) throws PMSException {
		 try {
			 System.out.println("service implementation .......:"+password);
	         return userDAO.authenticateUser(userId, password);
	      } catch (DataAccessException dae) {
	         throw new PMSException(1000, dae);
	      }
	}

	@Override
	public String insertUserToken(int userid, String username, String profession, String officeid)
			throws PMSException {
		return userDAO.insertUserToken(userid, username, profession, officeid);
		
	}

	@Override
	public User fetchUserInformation(String userid) throws PMSException {
		
		return userDAO.fetchUserInformation(userid);
	}

	@Override
	public List<Patientvoucher> fetchPatientVoucherDetails(Integer userid) throws PMSException {
		
		return userDAO.fetchPatientVoucherDetails(userid);
	}

}
