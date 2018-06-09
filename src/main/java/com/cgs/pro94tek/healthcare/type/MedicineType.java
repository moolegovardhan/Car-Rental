package com.cgs.pro94tek.healthcare.type;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum MedicineType implements IBaseEnumType {

   SYRUP ("S"), TABLET ("T");

   private String value;
   private static String name = MedicineType.class.getSimpleName();
   private static final Map<String, MedicineType> reverseLookupMap = new HashMap<String, MedicineType>();

   static {
      for (MedicineType medicineType : EnumSet.allOf(MedicineType.class)) {
         reverseLookupMap.put(medicineType.value, medicineType);
      }
   }

   MedicineType (String value) {
      this.value = value;
   }

   public String getValue () {
      return this.value;
   }

   public static MedicineType getType (String value) {
      return reverseLookupMap.get(value);
   }

   public String getDescription () {
      return EnumLookupHelper.getEnumLookupDescription(name, String.valueOf(this.value));
   }

}
