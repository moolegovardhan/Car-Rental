package com.cgs.pro94tek.healthcare.dataaccess.manager;

import com.cgs.pro94tek.healthcare.bean.SubCategory;
import com.cgs.pro94tek.healthcare.exeception.PMSException;

public interface ISubCategoryDataAccessManager {

   public SubCategory getSubCategoryByName (String subCategoryName) throws PMSException;

   public SubCategory getSubCategoryByCategoryId (Long categoryId) throws PMSException;

   public void createSubCategory (SubCategory subCategory) throws PMSException;

   public void updateSubCategory (SubCategory subCategory) throws PMSException;

   public void deleteSubCategory (SubCategory subCategory) throws PMSException;

}
