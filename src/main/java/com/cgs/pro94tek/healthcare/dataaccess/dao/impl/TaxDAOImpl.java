package com.cgs.pro94tek.healthcare.dataaccess.dao.impl;


import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.cgs.pro94tek.healthcare.bean.Tax;
import com.cgs.pro94tek.healthcare.dataaccess.dao.ITaxDAO;
import com.cgs.pro94tek.healthcare.dataaccess.dao.support.CustomHibernateDaoSupport;
import com.cgs.pro94tek.utils.PmsUtil;


@Repository("taxDAO")
public class TaxDAOImpl extends CustomHibernateDaoSupport implements ITaxDAO{


	@SuppressWarnings("unchecked")
	@Transactional
	public Tax getTaxByName(String taxName) throws DataAccessException {
		Tax tax = null;
		String queryTaxByName = "from Tax where taxName = :taxName";
		Query query = getSession().createQuery(queryTaxByName);
		query.setParameter("taxName", taxName);
		List<Tax> taxs = query.list();
		if (PmsUtil.isCollectionNotEmpty(taxs)) {
			tax = taxs.get(0);
		}
		return tax;
	}
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Tax> fetchTaxById(String taxId) throws DataAccessException {
		 List<Tax> tax = new ArrayList<Tax>();
		String queryTaxById  = "from Tax where officeid = :taxId";
		Query query = getSession().createQuery(queryTaxById);
		query.setParameter("taxId", Long.parseLong(taxId));
		List<Tax> taxs = query.list();
		if (PmsUtil.isCollectionNotEmpty(taxs)) {
			return taxs;
		}else{
			return tax;
		}
			
	}
	/*@Transactional
	public Tax fetchTaxByID(String taxId) throws DataAccessException {
		Tax tax = null;
		String queryTaxById  = "from Tax where id = :taxId";
		Query query = getSession().createQuery(queryTaxById);
		query.setParameter("taxId", Long.parseLong(taxId));
		List<Tax> taxs = query.list();
		if (PmsUtil.isCollectionNotEmpty(taxs)) {
			tax = taxs.get(0);
		}
		return tax;
	}*/
	@Transactional
	public void createOrUpdateTax(Tax tax) throws DataAccessException {
		getSession().saveOrUpdate(tax);

	}

	@Transactional
	public boolean deleteTaxById(String taxId) throws DataAccessException {
		String queryTaxId = " Delete from Tax where id = :taxId";
		Query query = getSession().createQuery(queryTaxId);
		query.setParameter("taxId", Long.parseLong(taxId));
		query.executeUpdate();
		return true;
	}



}
