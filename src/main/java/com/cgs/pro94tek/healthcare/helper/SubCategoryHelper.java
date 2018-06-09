package com.cgs.pro94tek.healthcare.helper;

import com.cgs.pro94tek.healthcare.bean.SubCategory;
import com.cgs.pro94tek.healthcare.modal.SubCategoryModal;

public class SubCategoryHelper {
	
	
	public SubCategoryModal createSubCategoryModal(SubCategory subCategory){
		SubCategoryModal subCategoryModal = new SubCategoryModal();
		subCategoryModal.setCreatedBy(subCategory.getCreatedBy());
		subCategoryModal.setCreatedDate(subCategory.getCreatedDate());
		subCategoryModal.setDescription(subCategory.getDescription());
		subCategoryModal.setId(subCategory.getId());
		subCategoryModal.setSubCategoryName(subCategory.getSubCategoryName());
		
		
		return subCategoryModal;
	}

	public SubCategory createSubCategoryModal(SubCategoryModal subCategoryModal){
		SubCategory subCategory = new SubCategory();
		subCategory.setCreatedBy(subCategoryModal.getCreatedBy());
		subCategory.setCreatedDate(subCategoryModal.getCreatedDate());
		subCategory.setDescription(subCategoryModal.getDescription());
		subCategory.setId(subCategoryModal.getId());
		subCategory.setSubCategoryName(subCategoryModal.getSubCategoryName());
		
		
		return subCategory;
	}

}
