package com.cgs.pro94tek.healthcare.service;

import java.util.List;

import com.cgs.pro94tek.healthcare.bean.Category;
import com.cgs.pro94tek.healthcare.bean.Medicine;
import com.cgs.pro94tek.healthcare.bean.SubCategory;
import com.cgs.pro94tek.healthcare.exeception.PMSException;

public interface IInventoryDataRetrivalService {

   public Category getCategoryByName (String categoryName) throws PMSException;
   
   public Category getCategoryById (String categoryId) throws PMSException;

   public SubCategory getSubCategoryByName (String subCategoryName) throws PMSException;

   public SubCategory getSubCategoryByCategoryId (Long categoryId) throws PMSException;

   public List<Medicine> getAllMedicinesByCategoryName (String categoryName) throws PMSException;

   public Medicine getMedicineByName (String name) throws PMSException;

   public List<Medicine> getAllMedicinesByChemicalCombination (String chemicalCombination) throws PMSException;

   public List<Medicine> getAllMedicinesByManufacturerName (String manufacturerName) throws PMSException;


   
 

}
