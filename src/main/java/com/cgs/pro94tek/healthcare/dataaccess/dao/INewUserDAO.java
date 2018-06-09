package com.cgs.pro94tek.healthcare.dataaccess.dao;

import org.springframework.dao.DataAccessException;

import com.cgs.pro94tek.healthcare.bean.NewUser;
import com.cgs.pro94tek.healthcare.exeception.PMSException;

public interface INewUserDAO {
	
	public NewUser fetchUserName(String username)throws DataAccessException;
	public NewUser fetchUserNamePassword(String username,String password) throws PMSException;
	public String insertUsernamePassword(Long userid, String username, String password, String officeid,String profession)throws PMSException;
	/*public boolean  deleteUserName(String username)throws DataAccessException;
	public void createOrUpdateUserName(NewUser newUser) throws DataAccessException;*/
	
	
	
	
	
	

}
