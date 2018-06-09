package com.cgs.pro94tek.healthcare.dataaccess.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.cgs.pro94tek.healthcare.bean.Ward;
import com.cgs.pro94tek.healthcare.dataaccess.dao.IWardDAO;
import com.cgs.pro94tek.healthcare.dataaccess.dao.support.CustomHibernateDaoSupport;
import com.cgs.pro94tek.utils.PmsUtil;

@Repository("wardDAO")
public class WardDAOImpl extends CustomHibernateDaoSupport implements IWardDAO{

	@SuppressWarnings("unchecked")
	@Transactional
	public Ward getWardByName(String wardName) throws DataAccessException {
		Ward ward = null;
		String queryWardByName = "from Ward where wardName = :wardName";
		Query query = getSession().createQuery(queryWardByName);
		query.setParameter("wardName", wardName);
		List<Ward> wards = query.list();
		if (PmsUtil.isCollectionNotEmpty(wards)) {
			ward = wards.get(0);
		}
		return ward;
	}
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Ward> fetchWardById(String wardId) throws DataAccessException {

		 List<Ward> ward = new ArrayList<Ward>();
		 String queryWardById  = "from Ward where officeid = :wardId";
			Query query = getSession().createQuery(queryWardById);
			query.setParameter("wardId", Long.parseLong(wardId));
			List<Ward> wards = query.list();
			if (PmsUtil.isCollectionNotEmpty(wards)) {
				return wards;
			}else{
				return ward;
			}
	}

	@Transactional
	public void createOrUpdateWard(Ward ward) throws DataAccessException {
		getSession().saveOrUpdate(ward);

	}

	@Transactional
	public boolean deleteWardById(String wardId) throws DataAccessException {
		String queryWardId = " Delete from Ward where id = wardId";
		Query query = getSession().createQuery(queryWardId);
		query.setParameter("wardId", Long.parseLong(wardId));
		query.executeUpdate();
		return true;
	}
	@Transactional
	public void deleteCategory(Ward ward) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

}
