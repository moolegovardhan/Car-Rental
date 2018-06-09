package com.cgs.pro94tek.healthcare.dataaccess.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.cgs.pro94tek.healthcare.bean.WardType;
import com.cgs.pro94tek.healthcare.dataaccess.dao.IWardTypeDAO;
import com.cgs.pro94tek.healthcare.dataaccess.dao.support.CustomHibernateDaoSupport;
import com.cgs.pro94tek.utils.PmsUtil;

@Repository("wardTypeDAO")
public class WardTypeDAOImpl extends CustomHibernateDaoSupport implements IWardTypeDAO{

	@Override
	public WardType getWardTypeByName(String wardTypeName) throws DataAccessException {
		  WardType wardtype = null;
	      String subWardTypequery = "from WardType where wardtype= :wardtype";
	      Query query = getSession().getNamedQuery(subWardTypequery);
	      query.setString("wardtype", wardTypeName);
	      List<WardType> wardTypes = query.list();
	      if (PmsUtil.isCollectionNotEmpty(wardTypes)) {
	    	  wardtype = wardTypes.get(0);
	      }
	      return wardtype;
	}

	@Override
	public List<WardType> getWardTypeByWardId(String wardId) throws DataAccessException {
		 List<WardType> wardtype = new ArrayList<WardType>();
			String queryWarpedtyById  = "from WardType where officeid = :wardtypeId";
			Query query = getSession().createQuery(queryWarpedtyById);
			query.setParameter("wardtypeId", Long.parseLong(wardId));
			List<WardType> wardtypes = query.list();
			if (PmsUtil.isCollectionNotEmpty(wardtypes)) {
				return wardtypes;
			}else{
				return wardtype;
			}
	}

	@Override
	public void createOrUpdateWardType(WardType wardtype) throws DataAccessException {
		getSession().saveOrUpdate(wardtype);
	}

	@Override
	public boolean deleteWardById(String wardId) throws DataAccessException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void deleteWardType(String wardtype) throws DataAccessException {
		 getSession().delete(wardtype);
		
	}

}
