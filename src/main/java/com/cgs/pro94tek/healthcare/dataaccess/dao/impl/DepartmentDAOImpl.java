package com.cgs.pro94tek.healthcare.dataaccess.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.cgs.pro94tek.healthcare.bean.Department;
import com.cgs.pro94tek.healthcare.dataaccess.dao.IDepartmentDAO;
import com.cgs.pro94tek.healthcare.dataaccess.dao.support.CustomHibernateDaoSupport;
import com.cgs.pro94tek.utils.PmsUtil;

@Repository("departmentDAO")
public class DepartmentDAOImpl extends CustomHibernateDaoSupport implements IDepartmentDAO{

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Department> fetchDepartmentById(String deptId) throws DataAccessException {
		List<Department> department = new ArrayList<Department>();
		String deptqueryById = "from Department where officeid = :deptId";
		Query query = getSession().createQuery(deptqueryById);
		query.setParameter("deptId", deptId);
		List<Department> departments = query.list();
		if (PmsUtil.isCollectionNotEmpty(departments)) {
			return departments;
		}else{

			return department;
		}
	}

	@Transactional
	public void createOrUpdateDepartment(Department department) throws DataAccessException {
		getSession().saveOrUpdate(department);

	}

	@Transactional
	public boolean deleteDepartmentById(String deptId) throws DataAccessException {
	String queryDeptId = "update Department set status = :status "+" where id = :deptId";
		Query query = getSession().createQuery(queryDeptId);
		query.setParameter("deptId", Long.parseLong(deptId));
		query.setParameter("status", "N");
		query.executeUpdate();
		return true;
	}
}


