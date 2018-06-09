package com.cgs.pro94tek.healthcare.dataaccess.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.cgs.pro94tek.healthcare.bean.SchoolDetails;
import com.cgs.pro94tek.healthcare.dataaccess.dao.ISchoolDetailsDAO;
import com.cgs.pro94tek.healthcare.dataaccess.dao.support.CustomHibernateDaoSupport;
import com.cgs.pro94tek.utils.PmsUtil;

@Repository("schoolDetailsDAO")
public class SchoolDetailsDAOImpl extends CustomHibernateDaoSupport implements ISchoolDetailsDAO{

	@SuppressWarnings("unchecked")
	@Transactional
	public SchoolDetails fetchSchoolDetailsById(String schoolId) throws DataAccessException {
		SchoolDetails schooldetails = null;
		String querySchooldetailsById  = "from SchoolDetails where id = :schoolId";
		Query query = getSession().createQuery(querySchooldetailsById);
		query.setParameter("schoolId", Long.parseLong(schoolId));
		List<SchoolDetails> schooldetailss = query.list();
		if (PmsUtil.isCollectionNotEmpty(schooldetailss)) {
			schooldetails = schooldetailss.get(0);
		}
		return schooldetails;
	}

	@Transactional
	public void createOrUpdateSchoolDetails(SchoolDetails schoolDetails) throws DataAccessException {
		
		getSession().saveOrUpdate(schoolDetails);
	}


	@Transactional
	public boolean deleteSchoolDetailsById(String schoolId) throws DataAccessException {
		String querySchooldetailsId = " Delete from SchoolDetails where id = :schoolId";
		Query query = getSession().createQuery(querySchooldetailsId);
		query.setParameter("schoolId", Long.parseLong(schoolId));
		query.executeUpdate();
		/*List<School> schoolIds = query.list();
		if (PmsUtil.isCollectionNotEmpty(schoolIds)) {
			school = schoolIds.get(0);
		}*/
		return true;
	}

	@Override
	public void deleteSchoolDetails(SchoolDetails schoolDetails) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SchoolDetails getSchoolDetailsById(String schoolId) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

}
