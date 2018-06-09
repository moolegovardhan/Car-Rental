package com.cgs.pro94tek.healthcare.helper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.cgs.pro94tek.healthcare.bean.Department;
import com.cgs.pro94tek.healthcare.bean.VehicleTravelling;
import com.cgs.pro94tek.healthcare.exeception.PMSException;
import com.cgs.pro94tek.healthcare.modal.DepartmentModal;
import com.cgs.pro94tek.healthcare.modal.VehicleTravelModal;

public class DepartmentHelper {
	
	public List<DepartmentModal> createDepartmentModal(List<Department> department) {
	DateFormat df = new SimpleDateFormat("dd/mm/yyyy");
	List<DepartmentModal> departments = new ArrayList<DepartmentModal>();
	for (Department departmentobj : department) {
		DepartmentModal departmentModal1 = new DepartmentModal();
		departmentModal1.setId(departmentobj.getId());
		departmentModal1.setId(departmentobj.getId());
		departmentModal1.setDepartmentname(departmentobj.getDepartmentname());
		departmentModal1.setDescription(departmentobj.getDescription());
		departmentModal1.setOfficeid(departmentobj.getOfficeid());
		departmentModal1.setCreatedBy(departmentobj.getCreatedBy());
		departmentModal1.setCreatedDate(df.format(departmentobj.getCreatedDate()));
		departments.add(departmentModal1);
	}

	return departments;
}
	
	public Department createDepartment(DepartmentModal departmentModal) throws PMSException, ParseException{
		DateFormat df = new SimpleDateFormat("dd/mm/yyyy");
		Department department = new Department();
		department.setDepartmentname(departmentModal.getDepartmentname());
		department.setDescription(departmentModal.getDescription());
		department.setCreatedBy(departmentModal.getCreatedBy());
		department.setOfficeid(departmentModal.getOfficeid());
		department.setCreatedDate(new Date());
		department.setStatus(departmentModal.getStatus());
		department.setId(departmentModal.getId());
		return department;
		
	}
	
}
