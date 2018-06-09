package com.cgs.pro94tek.healthcare.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cgs.pro94tek.healthcare.bean.Department;
import com.cgs.pro94tek.healthcare.exeception.PMSException;
import com.cgs.pro94tek.healthcare.modal.DepartmentModal;

@Component
public interface IDepartmentDataManagementService {
	
	

	public List<DepartmentModal> fetchDepartmentById(String deptId) throws PMSException;

	

	public void createOrUpdateDepartment(Department deptEntity) throws PMSException;

	public boolean deleteDepartmentById(String deptId) throws PMSException;

}
