package com.cgs.pro94tek.healthcare.dataaccess.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgs.pro94tek.healthcare.bean.Medicine;
import com.cgs.pro94tek.healthcare.dataaccess.dao.IMedicineDAO;
import com.cgs.pro94tek.healthcare.dataaccess.manager.IMedicineDataAccessManager;
import com.cgs.pro94tek.healthcare.exeception.PMSException;

@Service ("medicineDataAccessManager")
public class MedicineDataAccessManagerImpl implements IMedicineDataAccessManager {

   @Autowired
   private IMedicineDAO medicineDAO;

   public void createMedicine (Medicine medicine) throws PMSException {
      medicineDAO.createMedicine(medicine);
   }

   public void updateMedicine (Medicine medicine) throws PMSException {
      medicineDAO.updateMedicine(medicine);
   }

   public void deleteMedicine (Medicine medicine) throws PMSException {
      medicineDAO.deleteMedicine(medicine);
   }

   public List<Medicine> getAllMedicinesByCategoryName (String categoryName) throws PMSException {
      return medicineDAO.getAllMedicinesByCategoryName(categoryName);
   }

   public Medicine getMedicineByName (String name) throws PMSException {
      return medicineDAO.getMedicineByName(name);
   }

   public List<Medicine> getAllMedicinesByChemicalCombination (String chemicalCombination) throws PMSException {
      return medicineDAO.getAllMedicinesByChemicalCombination(chemicalCombination);
   }

   public List<Medicine> getAllMedicinesByManufacturerName (String manufacturerName) throws PMSException {
      return medicineDAO.getAllMedicinesByManufacturerName(manufacturerName);
   }

}
