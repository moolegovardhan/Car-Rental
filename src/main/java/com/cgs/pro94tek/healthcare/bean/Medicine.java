package com.cgs.pro94tek.healthcare.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.cgs.pro94tek.healthcare.type.HandlingRequirmentType;
import com.cgs.pro94tek.healthcare.type.MedicineType;



@Entity
@Table (name = "medicine", uniqueConstraints = { @UniqueConstraint (columnNames = "id"),
         @UniqueConstraint (columnNames = "medicine_name") })
public class Medicine {

   private Long                   id;
   private String                 name;
   private String                 category;
   private String                 subCategory;
   private String                 unitMeasure;
   private String                 description;
   private String                 udc;
   private Long                   nationalDrugCouncilNumber;
   private String                 Tags;
   private boolean                status = false;
   private String                 chemicalCombinations;
   private HandlingRequirmentType handlingRequirmentType;
   private String                 brandName;
   private String                 manufacturerName;
   private String                 manufacturerCode;
   private MedicineType           medicineType;
   private String                 imagePath;

   @Id
   @GeneratedValue (strategy = GenerationType.AUTO, generator = "ID_seq")
   @SequenceGenerator (sequenceName = "medicine_id_seq", name = "ID_seq")
   @Column (name = "id", nullable = false, unique = true)
   public Long getId () {
      return id;
   }

   public void setId (Long id) {
      this.id = id;
   }

   @Column (name = "medicine_name", nullable = false, unique = true)
   public String getName () {
      return name;
   }

   public void setName (String name) {
      this.name = name;
   }

   @Column (name = "category", nullable = false)
   public String getCategory () {
      return category;
   }

   public void setCategory (String category) {
      this.category = category;
   }

   @Column (name = "sub_category", nullable = false)
   public String getSubCategory () {
      return subCategory;
   }

   public void setSubCategory (String subCategory) {
      this.subCategory = subCategory;
   }

   @Column (name = "unit_measure", nullable = false)
   public String getUnitMeasure () {
      return unitMeasure;
   }

   public void setUnitMeasure (String unitMeasure) {
      this.unitMeasure = unitMeasure;
   }

   @Column (name = "description", nullable = true)
   public String getDescription () {
      return description;
   }

   public void setDescription (String description) {
      this.description = description;
   }

   @Column (name = "udc", nullable = true)
   public String getUdc () {
      return udc;
   }

   public void setUdc (String udc) {
      this.udc = udc;
   }

   @Column (name = "national_drug_council_number", nullable = false)
   public Long getNationalDrugCouncilNumber () {
      return nationalDrugCouncilNumber;
   }

   public void setNationalDrugCouncilNumber (Long nationalDrugCouncilNumber) {
      this.nationalDrugCouncilNumber = nationalDrugCouncilNumber;
   }

   @Column (name = "tags", nullable = true)
   public String getTags () {
      return Tags;
   }

   public void setTags (String tags) {
      Tags = tags;
   }

   @Column (name = "status", nullable = true)
   public boolean isStatus () {
      return status;
   }

   public void setStatus (boolean status) {
      this.status = status;
   }

   @Column (name = "chemical_combinations", nullable = false)
   public String getChemicalCombinations () {
      return chemicalCombinations;
   }

   public void setChemicalCombinations (String chemicalCombinations) {
      this.chemicalCombinations = chemicalCombinations;
   }

   @Column (name = "handling_requirment", nullable = false)
   public HandlingRequirmentType getHandlingRequirmentType () {
      return handlingRequirmentType;
   }

   public void setHandlingRequirmentType (HandlingRequirmentType handlingRequirmentType) {
      this.handlingRequirmentType = handlingRequirmentType;
   }

   @Column (name = "brand_name", nullable = true)
   public String getBrandName () {
      return brandName;
   }

   public void setBrandName (String brandName) {
      this.brandName = brandName;
   }

   @Column (name = "manufacturer_name", nullable = false)
   public String getManufacturerName () {
      return manufacturerName;
   }

   public void setManufacturerName (String manufacturerName) {
      this.manufacturerName = manufacturerName;
   }

   @Column (name = "manufacturer_code", nullable = false)
   public String getManufacturerCode () {
      return manufacturerCode;
   }

   public void setManufacturerCode (String manufacturerCode) {
      this.manufacturerCode = manufacturerCode;
   }

   @Column (name = "medicine_type", nullable = false)
   public MedicineType getMedicineType () {
      return medicineType;
   }

   public void setMedicineType (MedicineType medicineType) {
      this.medicineType = medicineType;
   }

   @Column (name = "image_path", nullable = true)
   public String getImagePath () {
      return imagePath;
   }

   public void setImagePath (String imagePath) {
      this.imagePath = imagePath;
   }

}
