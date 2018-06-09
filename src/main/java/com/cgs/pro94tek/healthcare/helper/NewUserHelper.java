package com.cgs.pro94tek.healthcare.helper;



import java.text.ParseException;

import com.cgs.pro94tek.healthcare.bean.NewUser;
import com.cgs.pro94tek.healthcare.exeception.PMSException;
import com.cgs.pro94tek.healthcare.modal.NewUserModal;

public class NewUserHelper {
	
	public  NewUserModal  createUserModal(NewUser newUser)
	{
		
		NewUserModal newUserModal=new NewUserModal();
		newUserModal.setUsername(newUser.getUsername());
		newUserModal.setAadharcard(newUser.getAadharcard());
		newUserModal.setFirstname(newUser.getFirstname());
		newUserModal.setLastname(newUser.getLastname());
		return	newUserModal;
	}

	public NewUser createUser(NewUserModal newUserModal)throws PMSException, ParseException
	{
		NewUser newUser=new NewUser();
		newUser.setUsername(newUserModal.getUsername());
		newUser.setAadharcard(newUserModal.getAadharcard());
		newUser.setFirstname(newUserModal.getFirstname());
		newUser.setLastname(newUserModal.getLastname());
	return 	newUser;
	}
	
}
