package com.cgs.pro94tek.healthcare.dataaccess.dao.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.cgs.pro94tek.healthcare.bean.NewUser;
import com.cgs.pro94tek.healthcare.bean.UserToken;
import com.cgs.pro94tek.healthcare.dataaccess.dao.INewUserDAO;
import com.cgs.pro94tek.healthcare.dataaccess.dao.support.CustomHibernateDaoSupport;
import com.cgs.pro94tek.healthcare.exeception.PMSException;
import com.cgs.pro94tek.utils.CommonUtils;
import com.cgs.pro94tek.utils.PmsUtil;

@Repository("newUserDAO")
public class NewUserDAOImpl extends CustomHibernateDaoSupport implements INewUserDAO{

	@SuppressWarnings("unchecked")
	@Transactional
	public NewUser fetchUserName(String username) throws DataAccessException {
		NewUser  newUser=null;
		
		String userquery="from NewUser where id=:username ";
		System.out.println("get data by id............:"+userquery);
		Query query = getSession().createQuery(userquery);
		query.setParameter("username",Long.parseLong(username));
		System.out.println("face.........:");
		List<NewUser> newUsers = query.list();
		// TODO Auto-generated method stub
		if (PmsUtil.isCollectionNotEmpty(newUsers)) {
			newUser = newUsers.get(0);
		}
		return newUser;
	}

		@SuppressWarnings ("unchecked")
		@Transactional
	public NewUser fetchUserNamePassword(String username, String password)
			throws PMSException {
			
			
			NewUser nuser=null;
			String query="from NewUser  username =:username and password =: password";
			System.out.println(query);
			Query queryr = getSession().createQuery(query);
			queryr.setParameter("username",username);
			queryr.setParameter("password",password);
			System.out.println("enter the username...............:"+username+"passowrd................."+password);
			System.out.println("face.........:");
			List<NewUser> nusers=queryr.list();
			if (PmsUtil.isCollectionNotEmpty(nusers)) {
				nuser = nusers.get(0);
			}
		// TODO Auto-generated method stub
		return nuser;
	}

		@Transactional
		public String insertUsernamePassword(Long userid, String username,
				String password, String officeid, String profession) throws PMSException {
			try {
				String currentDate = PmsUtil.convertDatetoString(new Date());	
				byte[] token = CommonUtils.tokenGenerator(currentDate, username, profession, officeid);
				UserToken userToken = new UserToken();
				userToken.setDateoflogin(new Date());
				userToken.setToken(token.toString());
				userToken.setUserid(userid);
				getSession().save(userToken);
				return token.toString();
			
			} 
		catch (Exception e) 
			
				{
					e.printStackTrace();
					throw new PMSException(1000,e);
				}
		
		
		}

		
			
	

		}

