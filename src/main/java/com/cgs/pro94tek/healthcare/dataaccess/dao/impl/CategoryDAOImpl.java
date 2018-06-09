package com.cgs.pro94tek.healthcare.dataaccess.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.cgs.pro94tek.healthcare.bean.Category;
import com.cgs.pro94tek.healthcare.dataaccess.dao.ICategoryDAO;
import com.cgs.pro94tek.healthcare.dataaccess.dao.support.CustomHibernateDaoSupport;
import com.cgs.pro94tek.utils.PmsUtil;

@Repository("categoryDAO")
public class CategoryDAOImpl extends CustomHibernateDaoSupport implements ICategoryDAO {

   @SuppressWarnings ("unchecked")
   @Transactional
   public Category getCategoryByName (String categoryName) throws DataAccessException {
      Category category = null;
      String queryCategoryByName = "from Category where categoryName = :categoryName";
      Query query = getSession().createQuery(queryCategoryByName);
      query.setParameter("categoryName", categoryName);
      List<Category> categories = query.list();
      if (PmsUtil.isCollectionNotEmpty(categories)) {
         category = categories.get(0);
      }
      return category;
   }

   @SuppressWarnings ("unchecked")
   @Transactional
   public Category getCategoryById(String categoryId) throws DataAccessException {
	   Category category = null;
	      String queryCategoryById  = "from Category where id = :categoryId";
	      Query query = getSession().createQuery(queryCategoryById);
	      query.setParameter("categoryId", Long.parseLong(categoryId));
	      List<Category> categories = query.list();
	      if (PmsUtil.isCollectionNotEmpty(categories)) {
	         category = categories.get(0);
	      }
	      return category;
	}
   
   @Transactional
   public void createCategory (Category category) throws DataAccessException {
      getSession().save(category);
   }

   @Transactional
   public void updateCategory (Category category) throws DataAccessException {
      getSession().saveOrUpdate(category);
   }

   @Transactional
   public void deleteCategory (Category category) throws DataAccessException {
      getSession().delete(category);
   }




}
