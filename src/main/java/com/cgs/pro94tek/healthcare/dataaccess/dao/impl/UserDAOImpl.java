package com.cgs.pro94tek.healthcare.dataaccess.dao.impl;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.cgs.pro94tek.healthcare.bean.Patientvoucher;
import com.cgs.pro94tek.healthcare.bean.User;
import com.cgs.pro94tek.healthcare.bean.UserToken;
import com.cgs.pro94tek.healthcare.dataaccess.dao.IUserDAO;
import com.cgs.pro94tek.healthcare.dataaccess.dao.support.CustomHibernateDaoSupport;
import com.cgs.pro94tek.healthcare.exeception.PMSException;
import com.cgs.pro94tek.utils.CommonUtils;
import com.cgs.pro94tek.utils.PmsUtil;

@Repository("userDAO")
public class UserDAOImpl extends CustomHibernateDaoSupport  implements IUserDAO {

	
	 
	@SuppressWarnings ("unchecked")
	@Transactional
	public User authenticateUser(String username, String password) throws PMSException {
		User user = null;
		String queryUserByUserNameandPassword= "from User where username = :username and password = :password";
	    Query query = getSession().createQuery(queryUserByUserNameandPassword);
	    query.setParameter("username", username);
	    query.setParameter("password", password);
	      List<User> userList = query.list();
	      if (PmsUtil.isCollectionNotEmpty(userList)) {
	         user = userList.get(0);
	      }
		return user;
	}


	 @Transactional
	public String insertUserToken(long userid, String username,
			String profession, String officeid) throws PMSException {

		try {
				String currentDate = PmsUtil.convertDatetoString(new Date());			
				byte[] token = CommonUtils.tokenGenerator(currentDate, username, profession, officeid);
				UserToken userToken = new UserToken();
				userToken.setDateoflogin(new Date());
				userToken.setToken(token.toString());
				userToken.setUserid(userid);
				getSession().save(userToken);
				return token.toString();
		} catch (Exception e) {
			e.printStackTrace();
			throw new PMSException(1000,e);
		}
	}

	
	 @Transactional
	public User fetchUserInformation(String userid) throws PMSException {
	     User user = null;
		
		String queryUserByUserNameandPassword= "from User where officeid = :userid";
	    Query query = getSession().createQuery(queryUserByUserNameandPassword);
	    query.setParameter("username", userid);
	      List<User> userList = query.list();
	      if (PmsUtil.isCollectionNotEmpty(userList)) {
	         user = userList.get(0);
	      }  
		return user;
	}
	 
	 @SuppressWarnings("unused" )
	 @Transactional
		public List<Patientvoucher> fetchPatientVoucherDetails(Integer userid) throws PMSException {
		 
		 BigInteger bg = BigInteger.valueOf(userid.longValue());
		 Patientvoucher patientVoucher = null;
			System.out.println("User id......................."+bg);
			String queryPatientVoucherByUserIdNameandPassword= "from Patientvoucher where patientid = :patientid";
			System.out.println("queryPatientVoucherByUserIdNameandPassword........................."+queryPatientVoucherByUserIdNameandPassword);
		    Query query = getSession().createQuery(queryPatientVoucherByUserIdNameandPassword);
		    query.setParameter("patientid", bg);
		    
		      List<Patientvoucher> patientVoucherList = query.list();
		      
		      System.out.println("patientVoucherList................."+patientVoucherList);
		      
		     
			return patientVoucherList;
		}


	 @Transactional
	public void createOrUpdateUser(User userEntity) throws DataAccessException {

		getSession().saveOrUpdate(userEntity);
	}
	

	
}
