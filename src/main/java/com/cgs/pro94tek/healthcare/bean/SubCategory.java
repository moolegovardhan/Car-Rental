package com.cgs.pro94tek.healthcare.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table (name = "sub_category", uniqueConstraints = { @UniqueConstraint (columnNames = "id"),
		@UniqueConstraint (columnNames = "sub_category_name") })
public class SubCategory {

	private Long     id;
	private String   subCategoryName;
	private String   description;
	private String   createdBy;
	private Date     createdDate;
	private Category category;

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO, generator = "ID_seq")
	@SequenceGenerator (sequenceName = "subcat_id_seq", name = "ID_seq")
	@Column (name = "id", unique = true, nullable = false)
	public Long getId () {
		return id;
	}

	public void setId (Long id) {
		this.id = id;
	}

	@Column (name = "sub_category_name", unique = true, nullable = false)
	public String getSubCategoryName () {
		return subCategoryName;
	}

	public void setSubCategoryName (String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}

	@Column (name = "description", nullable = true)
	public String getDescription () {
		return description;
	}

	public void setDescription (String description) {
		this.description = description;
	}

	@Column (name = "created_by", nullable = false)
	public String getCreatedBy () {
		return createdBy;
	}

	public void setCreatedBy (String createdBy) {
		this.createdBy = createdBy;
	}

	@Column (name = "created_date", nullable = false)
	public Date getCreatedDate () {
		return createdDate;
	}

	public void setCreatedDate (Date createdDate) {
		this.createdDate = createdDate;
	}

	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn (name = "category_id")
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}








}
