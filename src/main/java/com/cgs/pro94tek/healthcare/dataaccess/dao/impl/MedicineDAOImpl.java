package com.cgs.pro94tek.healthcare.dataaccess.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.cgs.pro94tek.healthcare.bean.Medicine;
import com.cgs.pro94tek.healthcare.dataaccess.dao.IMedicineDAO;
import com.cgs.pro94tek.healthcare.dataaccess.dao.support.CustomHibernateDaoSupport;
import com.cgs.pro94tek.utils.PmsUtil;

@Repository ("medicineDAO")
public class MedicineDAOImpl extends CustomHibernateDaoSupport implements IMedicineDAO {

   public void createMedicine (Medicine medicine) throws DataAccessException {
      getSession().save(medicine);
   }

   public void updateMedicine (Medicine medicine) throws DataAccessException {
      getSession().update(medicine);
   }

   public void deleteMedicine (Medicine medicine) throws DataAccessException {
      getSession().delete(medicine);
   }

   @SuppressWarnings ("unchecked")
   public List<Medicine> getAllMedicinesByCategoryName (String categoryName) throws DataAccessException {
      String medicinesByCategoryName = "from Medicine where category = :categoryName";
      Query query = getSession().getNamedQuery(medicinesByCategoryName);
      query.setString("categoryName", categoryName);
      return query.list();
   }

   @SuppressWarnings ("unchecked")
   public Medicine getMedicineByName (String name) throws DataAccessException {
      Medicine medicine = null;
      String medicineByName = "from Medicine where name = :name";
      Query query = getSession().getNamedQuery(medicineByName);
      query.setString("name", name);
      List<Medicine> medicines = query.list();
      if (PmsUtil.isCollectionNotEmpty(medicines)) {
         medicine = medicines.get(0);
      }
      return medicine;
   }

   @SuppressWarnings ("unchecked")
   public List<Medicine> getAllMedicinesByChemicalCombination (String chemicalCombination) throws DataAccessException {
      String medicinesByChemicalCombination = "from Medicine where chemicalCombinations = :chemicalCombination";
      Query query = getSession().getNamedQuery(medicinesByChemicalCombination);
      query.setString("chemicalCombination", chemicalCombination);
      return query.list();
   }

   @SuppressWarnings ("unchecked")
   public List<Medicine> getAllMedicinesByManufacturerName (String manufacturerName) throws DataAccessException {
      String medicinesByManufacturerName = "from Medicine where manufacturerName = :manufacturerName";
      Query query = getSession().getNamedQuery(medicinesByManufacturerName);
      query.setString("manufacturerName", manufacturerName);
      return query.list();
   }

}
