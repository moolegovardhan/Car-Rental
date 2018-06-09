package com.cgs.pro94tek.healthcare.service;

import org.springframework.stereotype.Component;

import com.cgs.pro94tek.healthcare.bean.Category;
import com.cgs.pro94tek.healthcare.bean.Medicine;
import com.cgs.pro94tek.healthcare.bean.SubCategory;
import com.cgs.pro94tek.healthcare.exeception.PMSException;

@Component
public interface IInventoryDataManagmentService {

   public void createCategory (Category category) throws PMSException;

   public void updateCategory (Category category) throws PMSException;

   public void deleteCategory (Category category) throws PMSException;

   public void createSubCategory (SubCategory subCategory) throws PMSException;

   public void updateSubCategory (SubCategory subCategory) throws PMSException;

   public void deleteSubCategory (SubCategory subCategory) throws PMSException;

   public void createMedicine (Medicine medicine) throws PMSException;

   public void updateMedicine (Medicine medicine) throws PMSException;

   public void deleteMedicine (Medicine medicine) throws PMSException;
   

   
   

}
