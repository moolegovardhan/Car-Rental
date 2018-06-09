package com.cgs.pro94tek.healthcare.dataaccess.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.cgs.pro94tek.healthcare.bean.School;
import com.cgs.pro94tek.healthcare.dataaccess.dao.ISchoolDAO;
import com.cgs.pro94tek.healthcare.dataaccess.dao.support.CustomHibernateDaoSupport;
import com.cgs.pro94tek.utils.PmsUtil;

@Repository("schoolDAO")
public class SchoolDAOImpl extends CustomHibernateDaoSupport implements ISchoolDAO{

	@SuppressWarnings("unchecked")
	@Transactional
	public School getSchoolByName(String schoolName) throws DataAccessException {
		School school = null;
		String querySchoolByName = "from School where schoolName = :schoolName";
		Query query = getSession().createQuery(querySchoolByName);
		query.setParameter("schoolName", schoolName);
		List<School> schools = query.list();
		if (PmsUtil.isCollectionNotEmpty(schools)) {
			school = schools.get(0);
		}
		return school;
	}
	

	@SuppressWarnings("unchecked")
	@Transactional
	public School fetchSchoolById(String schoolId) throws DataAccessException {
		School school = null;
		String querySchoolById  = "from School where id = :schoolId";
		Query query = getSession().createQuery(querySchoolById);
		query.setParameter("schoolId", Long.parseLong(schoolId));
		List<School> schools = query.list();
		if (PmsUtil.isCollectionNotEmpty(schools)) {
			school = schools.get(0);
		}
		return school;
	}

	@Transactional
	public boolean deleteSchoolById(String schoolId) throws DataAccessException {
		String querySchoolId = " Delete from School where id = :schoolId";
		//Query query = getSession().delete(querySchoolId);
		Query query = getSession().createQuery(querySchoolId);
		query.setParameter("schoolId", Long.parseLong(schoolId));
		query.executeUpdate();
		/*List<School> schoolIds = query.list();
		if (PmsUtil.isCollectionNotEmpty(schoolIds)) {
			school = schoolIds.get(0);
		}*/
		return true;
	}

	@Transactional
	public void createOrUpdateSchool(School school) throws DataAccessException {
		getSession().saveOrUpdate(school);
	}


	public void deleteSchool(School school) {
		// TODO Auto-generated method stub
		
	}
	
}

