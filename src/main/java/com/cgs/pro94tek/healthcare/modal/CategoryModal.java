package com.cgs.pro94tek.healthcare.modal;

import java.util.List;

public class CategoryModal {

	
	
	   private Long             id;
	   private String           categoryName;
	   private String           description;
	   private String           createdBy;
	   private String             createdDate;
	   private List<SubCategoryModal> subCategories;
	   
	   
	   
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public List<SubCategoryModal> getSubCategories() {
		return subCategories;
	}
	public void setSubCategories(List<SubCategoryModal> subCategories) {
		this.subCategories = subCategories;
	}
	   
	   
	
}
