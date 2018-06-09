package com.cgs.pro94tek.healthcare.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cgs.pro94tek.healthcare.bean.Department;
import com.cgs.pro94tek.healthcare.dataaccess.dao.IDepartmentDAO;
import com.cgs.pro94tek.healthcare.exeception.PMSException;
import com.cgs.pro94tek.healthcare.helper.DepartmentHelper;
import com.cgs.pro94tek.healthcare.modal.DepartmentModal;
import com.cgs.pro94tek.healthcare.service.IDepartmentDataManagementService;

@Service("departmentDataManagementService")
public class DepartmentDataRetrivalServiceImpl implements IDepartmentDataManagementService{
	
	@Autowired
	private IDepartmentDAO departmentdao;
	
	@Override
	public List<DepartmentModal> fetchDepartmentById(String deptId) throws PMSException {
		List<Department> department = departmentdao.fetchDepartmentById(deptId);
		DepartmentHelper departmentHelper = new DepartmentHelper();
		return departmentHelper.createDepartmentModal(department);
	}

	@Override
	public void createOrUpdateDepartment(Department deptEntity) throws PMSException {
		departmentdao.createOrUpdateDepartment(deptEntity);
		
	}

	@Override
	public boolean deleteDepartmentById(String deptId) throws PMSException {
		return departmentdao.deleteDepartmentById(deptId);
	}

}
