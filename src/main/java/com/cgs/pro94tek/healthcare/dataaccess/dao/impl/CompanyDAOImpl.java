package com.cgs.pro94tek.healthcare.dataaccess.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.cgs.pro94tek.healthcare.bean.Company;
import com.cgs.pro94tek.healthcare.dataaccess.dao.ICompanyDAO;
import com.cgs.pro94tek.healthcare.dataaccess.dao.support.CustomHibernateDaoSupport;
import com.cgs.pro94tek.utils.PmsUtil;



@Repository("companyDAO")
public class CompanyDAOImpl extends CustomHibernateDaoSupport implements ICompanyDAO{

	@SuppressWarnings("unchecked")
	@Transactional
	public Company getCompanyByName(String companyName) throws DataAccessException {
		Company company = null;
		String queryCompanyByName = "from Company where companyName = :companyName";
		Query query = getSession().createQuery(queryCompanyByName);
		query.setParameter("companyName", companyName);
		List<Company> companys = query.list();
		if (PmsUtil.isCollectionNotEmpty(companys)) {
			company = companys.get(0);
		}
		return company;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Company> fetchCompanyById(String companyId) throws DataAccessException {
		 List<Company> company = new ArrayList<Company>();
			String queryCompanyById  = "from Company where officeid = :companyId";
			Query query = getSession().createQuery(queryCompanyById);
			query.setParameter("companyId", Long.parseLong(companyId));
			List<Company> companys = query.list();
			if (PmsUtil.isCollectionNotEmpty(companys)) {
				return companys;
			}else{
				return company;
			}
	}

	@Transactional
	public void createOrUpdateCompany(Company company) throws DataAccessException {
		getSession().saveOrUpdate(company);
		
	}

	@Transactional
	public boolean deleteCompanyById(String companyId) throws DataAccessException {
		String queryCompanyId = " Delete from Company where id = :companyId";
		Query query = getSession().createQuery(queryCompanyId);
		query.setParameter("companyId", Long.parseLong(companyId));
		query.executeUpdate();
		return true;
	}

}
