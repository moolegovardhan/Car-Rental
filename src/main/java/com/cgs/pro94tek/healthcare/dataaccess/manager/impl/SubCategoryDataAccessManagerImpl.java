package com.cgs.pro94tek.healthcare.dataaccess.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.cgs.pro94tek.healthcare.bean.SubCategory;
import com.cgs.pro94tek.healthcare.dataaccess.dao.ISubCategoryDAO;
import com.cgs.pro94tek.healthcare.dataaccess.manager.ISubCategoryDataAccessManager;
import com.cgs.pro94tek.healthcare.exeception.PMSException;

@Service ("subCategoryDataAccessManagerImpl")
public class SubCategoryDataAccessManagerImpl implements ISubCategoryDataAccessManager {

   @Autowired
   private ISubCategoryDAO subCategoryDAO;

   public SubCategory getSubCategoryByName (String subCategoryName) throws PMSException {
      try {
         return subCategoryDAO.getSubCategoryByName(subCategoryName);
      } catch (DataAccessException dae) {
         throw new PMSException(1000, dae);
      }

   }

   public SubCategory getSubCategoryByCategoryId (Long categoryId) throws PMSException {
      try {
         return subCategoryDAO.getSubCategoryByCategoryId(categoryId);
      } catch (DataAccessException dae) {
         throw new PMSException(1000, dae);
      }

   }

   public void createSubCategory (SubCategory subCategory) throws PMSException {
      try {
         subCategoryDAO.createSubCategory(subCategory);
      } catch (DataAccessException dae) {
         throw new PMSException(1000, dae);
      }

   }

   public void updateSubCategory (SubCategory subCategory) throws PMSException {
      try {
         subCategoryDAO.updateSubCategory(subCategory);
      } catch (DataAccessException dae) {
         throw new PMSException(1000, dae);
      }

   }

   public void deleteSubCategory (SubCategory subCategory) throws PMSException {
      try {
         subCategoryDAO.deleteSubCategory(subCategory);
      } catch (DataAccessException dae) {
         throw new PMSException(1000, dae);
      }

   }

}
