package com.cgs.pro94tek.healthcare.helper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.cgs.pro94tek.healthcare.bean.Category;
import com.cgs.pro94tek.healthcare.exeception.PMSException;
import com.cgs.pro94tek.healthcare.modal.CategoryModal;

public class CategoryHelper {
	
	
	
	public CategoryModal createCategoryModal(Category category){
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy"); 
		CategoryModal categoryModal = new CategoryModal();
		categoryModal.setCategoryName(category.getCategoryName());
		categoryModal.setCreatedBy(category.getCreatedBy());
		categoryModal.setCreatedDate(df.format(category.getCreatedDate()));
		categoryModal.setDescription(category.getDescription());
		categoryModal.setId(category.getId());
		
		return categoryModal;
	}

	public Category createCategoryEntity(CategoryModal categoryModal) throws PMSException, ParseException{
		@SuppressWarnings("unused")
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
		Category category = new Category();
		category.setCategoryName(categoryModal.getCategoryName());
		category.setCreatedBy(categoryModal.getCreatedBy());
		
		category.setCreatedDate(new Date());
		category.setDescription(categoryModal.getDescription());
		//category.setId(categoryModal.getId());
		
		return category;
	}
}
