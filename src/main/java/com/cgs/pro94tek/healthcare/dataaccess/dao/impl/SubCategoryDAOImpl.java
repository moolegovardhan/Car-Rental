package com.cgs.pro94tek.healthcare.dataaccess.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.cgs.pro94tek.healthcare.bean.SubCategory;
import com.cgs.pro94tek.healthcare.dataaccess.dao.ISubCategoryDAO;
import com.cgs.pro94tek.healthcare.dataaccess.dao.support.CustomHibernateDaoSupport;
import com.cgs.pro94tek.utils.PmsUtil;

@Repository("subCategoryDAO")
public class SubCategoryDAOImpl extends CustomHibernateDaoSupport implements ISubCategoryDAO {

   @SuppressWarnings ("unchecked")
   public SubCategory getSubCategoryByName (String subCategoryName) throws DataAccessException {
      SubCategory subCategory = null;
      String subCategoryNamequery = "from SubCategory where subCategoryName= :subCategoryName";
      Query query = getSession().getNamedQuery(subCategoryNamequery);
      query.setString("subCategoryName", subCategoryName);
      List<SubCategory> subCategories = query.list();
      if (PmsUtil.isCollectionNotEmpty(subCategories)) {
         subCategory = subCategories.get(0);
      }
      return subCategory;
   }

   public SubCategory getSubCategoryByCategoryId (Long categoryId) throws DataAccessException {
      // SubCategory subCategory = null;
      // String categoryIdquery=" from SubCategory where ";
      return null;
   }

   public void createSubCategory (SubCategory subCategory) throws DataAccessException {
      getSession().save(subCategory);
   }

   public void updateSubCategory (SubCategory subCategory) throws DataAccessException {
      getSession().update(subCategory);
   }

   public void deleteSubCategory (SubCategory subCategory) throws DataAccessException {
      getSession().delete(subCategory);
   }

}
