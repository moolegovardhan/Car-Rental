package com.cgs.pro94tek.healthcare.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgs.pro94tek.healthcare.bean.Category;
import com.cgs.pro94tek.healthcare.bean.Medicine;
import com.cgs.pro94tek.healthcare.bean.SubCategory;
import com.cgs.pro94tek.healthcare.dataaccess.manager.ICategoryDataAccessManager;
import com.cgs.pro94tek.healthcare.dataaccess.manager.IMedicineDataAccessManager;
import com.cgs.pro94tek.healthcare.dataaccess.manager.ISubCategoryDataAccessManager;
import com.cgs.pro94tek.healthcare.exeception.PMSException;
import com.cgs.pro94tek.healthcare.service.IInventoryDataRetrivalService;

@Service ("invetoryDataRetrivalService")
public class InventoryDataRetrivalServiceImpl implements IInventoryDataRetrivalService {

	@Autowired
	private ICategoryDataAccessManager categoryDataAccessManager;
	@Autowired
	private ISubCategoryDataAccessManager subCategoryDataAccessManager;
	@Autowired
	private IMedicineDataAccessManager  medicineDataAccessManager;
	

	public Category getCategoryByName (String categoryName) throws PMSException {
		return categoryDataAccessManager.getCategoryByName(categoryName);
	}


	public Category getCategoryById(String categoryId) throws PMSException {
		return categoryDataAccessManager.getCategoryById(categoryId);
	}


	public SubCategory getSubCategoryByName (String subCategoryName) throws PMSException {
		return subCategoryDataAccessManager.getSubCategoryByName(subCategoryName);
	}

	public SubCategory getSubCategoryByCategoryId (Long categoryId) throws PMSException {
		return subCategoryDataAccessManager.getSubCategoryByCategoryId(categoryId);
	}

	public List<Medicine> getAllMedicinesByCategoryName (String categoryName) throws PMSException {
		return medicineDataAccessManager.getAllMedicinesByCategoryName(categoryName);
	}

	public Medicine getMedicineByName (String name) throws PMSException {
		return medicineDataAccessManager.getMedicineByName(name);
	}

	public List<Medicine> getAllMedicinesByChemicalCombination (String chemicalCombination) throws PMSException {
		return medicineDataAccessManager.getAllMedicinesByChemicalCombination(chemicalCombination);
	}

	public List<Medicine> getAllMedicinesByManufacturerName (String manufacturerName) throws PMSException {
		return medicineDataAccessManager.getAllMedicinesByManufacturerName(manufacturerName);
	}



}
