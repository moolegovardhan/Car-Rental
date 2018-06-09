package com.cgs.pro94tek.healthcare.dataaccess.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.cgs.pro94tek.healthcare.dataaccess.dao.IStateDAO;
import com.cgs.pro94tek.healthcare.dataaccess.dao.support.CustomHibernateDaoSupport;

@Repository("stateDAO")
public class StateInfoDAOImpl extends CustomHibernateDaoSupport implements IStateDAO{

	@Override
	@SuppressWarnings("unchecked")
	@Transactional
	public List<String> fetchDistrictByStateName(String stateName) throws DataAccessException {

		//List<String> state = new ArrayList<String>();

		String hql = "select distinct s.district from StateInfo s where s.state like :stateName";

		//String keyword = "New";
		System.out.println("state query "+hql);
		Query query = getSession().createQuery(hql);
		query.setParameter("stateName", stateName);
		
		System.out.println("State query  "+query);
		
		
		List<String> liststate = query.list();
		
	
		// List of Strings {"kadapa", "anatapur", "nellore", "kurnul", "EG", "EG", "VZG"}
		// List of StateInfo {{district, mandal}, {}, {}, {},{} } 

		System.out.println("district  List value  "+liststate); 

		return liststate;



	}
}
