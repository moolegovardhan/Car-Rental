package com.cgs.pro94tek.healthcare.dataaccess.manager;

import com.cgs.pro94tek.healthcare.bean.Category;
import com.cgs.pro94tek.healthcare.exeception.PMSException;

public interface ICategoryDataAccessManager {

   public Category getCategoryByName (String categoryName) throws PMSException;
   
   public Category getCategoryById (String categoryId) throws PMSException;

   public void createCategory (Category category) throws PMSException;

   public void updateCategory (Category category) throws PMSException;

   public void deleteCategory (Category category) throws PMSException;

}
