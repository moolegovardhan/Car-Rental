package com.cgs.pro94tek.healthcare.service;

import org.springframework.stereotype.Component;

import com.cgs.pro94tek.healthcare.bean.NewUser;
import com.cgs.pro94tek.healthcare.exeception.PMSException;
import com.cgs.pro94tek.healthcare.modal.NewUserModal;

@Component


public interface INewUserDataManagerService {
	public NewUser fetchUserName(String username) throws PMSException;
	public NewUserModal fetchUserNamePassword(String username,String password) throws PMSException;
	/*public boolean deleteUserName(String username)throws PMSException;
	public void createOrUpdateUserName(NewUser newUser)throws PMSException;*/
}
