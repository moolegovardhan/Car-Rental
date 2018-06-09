package com.cgs.pro94tek.healthcare.dataaccess.dao;

import org.springframework.dao.DataAccessException;

import com.cgs.pro94tek.healthcare.bean.Category;


public interface ICategoryDAO {
   
   public Category getCategoryByName(String categoryName) throws DataAccessException;
   
   public Category getCategoryById(String categoryId) throws DataAccessException;
   
   public void createCategory(Category category)throws DataAccessException;
   
   public void updateCategory(Category category)throws DataAccessException;
   
   public void deleteCategory(Category category)throws DataAccessException;
}
