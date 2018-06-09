package com.cgs.pro94tek.healthcare.dataaccess.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.cgs.pro94tek.healthcare.bean.Category;
import com.cgs.pro94tek.healthcare.dataaccess.dao.ICategoryDAO;
import com.cgs.pro94tek.healthcare.dataaccess.manager.ICategoryDataAccessManager;
import com.cgs.pro94tek.healthcare.exeception.PMSException;

@Service ("categoryDataAccessManager")
public class CategoryDataAccessManagerImpl implements ICategoryDataAccessManager {

   @Autowired
   private ICategoryDAO categoryDAO;

   public Category getCategoryByName (String categoryName) throws PMSException {
      try {
         return categoryDAO.getCategoryByName(categoryName);
      } catch (DataAccessException dae) {
         throw new PMSException(1000, dae);
      }
   }
   
   
   public Category getCategoryById(String categoryId) throws PMSException {
	   try {
	         return categoryDAO.getCategoryById(categoryId);
	      } catch (DataAccessException dae) {
	         throw new PMSException(1000, dae);
	      }
	}
   

   public void createCategory (Category category) throws PMSException {
      try {
         categoryDAO.createCategory(category);
      } catch (DataAccessException dae) {
         throw new PMSException(1000, dae);
      }
   }

   public void updateCategory (Category category) throws PMSException {
      try {
         categoryDAO.updateCategory(category);
      } catch (DataAccessException dae) {
         throw new PMSException(1000, dae);
      }
   }

   public void deleteCategory (Category category) throws PMSException {
      try {
         categoryDAO.deleteCategory(category);
      } catch (DataAccessException dae) {
         throw new PMSException(1000, dae);
      }
   }




}
