package com.cgs.pro94tek.healthcare.dataaccess.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.cgs.pro94tek.healthcare.bean.Department;

public interface IDepartmentDAO {
	
	public List<Department> fetchDepartmentById(String deptId) throws DataAccessException;
	public void createOrUpdateDepartment(Department department)throws DataAccessException;
	public boolean deleteDepartmentById(String deptId) throws DataAccessException;
}
