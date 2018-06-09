package com.cgs.pro94tek.healthcare.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgs.pro94tek.healthcare.bean.Category;
import com.cgs.pro94tek.healthcare.bean.Medicine;
import com.cgs.pro94tek.healthcare.bean.SubCategory;
import com.cgs.pro94tek.healthcare.dataaccess.dao.ICategoryDAO;
import com.cgs.pro94tek.healthcare.dataaccess.dao.IMedicineDAO;
import com.cgs.pro94tek.healthcare.dataaccess.dao.ISubCategoryDAO;
import com.cgs.pro94tek.healthcare.exeception.PMSException;
import com.cgs.pro94tek.healthcare.service.IInventoryDataManagmentService;

@Service ("invetoryDataManagmentService")
public class InventoryDataManagmentServiceImpl implements IInventoryDataManagmentService {

	@Autowired
	private ICategoryDAO categoryDAO;
	@Autowired
	private ISubCategoryDAO subCategoryDAO;
	@Autowired
	private IMedicineDAO medicineDAO;


	public void createCategory (Category category) throws PMSException {
		categoryDAO.createCategory(category);
	}

	public void updateCategory (Category category) throws PMSException {
		categoryDAO.updateCategory(category);

	}

	public void deleteCategory (Category category) throws PMSException {
		categoryDAO.deleteCategory(category);
	}

	public void createSubCategory (SubCategory subCategory) throws PMSException {
		subCategoryDAO.createSubCategory(subCategory);
	}

	public void updateSubCategory (SubCategory subCategory) throws PMSException {
		subCategoryDAO.updateSubCategory(subCategory);
	}

	public void deleteSubCategory (SubCategory subCategory) throws PMSException {
		subCategoryDAO.deleteSubCategory(subCategory);

	}

	public void createMedicine (Medicine medicine) throws PMSException {
		medicineDAO.createMedicine(medicine);
	}

	public void updateMedicine (Medicine medicine) throws PMSException {
		medicineDAO.updateMedicine(medicine);
	}

	public void deleteMedicine (Medicine medicine) throws PMSException {
		medicineDAO.deleteMedicine(medicine);
	}



}
