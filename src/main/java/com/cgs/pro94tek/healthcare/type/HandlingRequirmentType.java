package com.cgs.pro94tek.healthcare.type;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum HandlingRequirmentType implements IBaseEnumType{

   CLOD_STORAGE ("C"), HAZARDOUS_MATERIAL ("H");

   private String                                           value;
   private static String                                    name             = HandlingRequirmentType.class
                                                                                      .getSimpleName();
   private static final Map<String, HandlingRequirmentType> reverseLookupMap = new HashMap<String, HandlingRequirmentType>();

   static {
      for (HandlingRequirmentType handlingRequirmentType : EnumSet.allOf(HandlingRequirmentType.class)) {
         reverseLookupMap.put(handlingRequirmentType.value, handlingRequirmentType);
      }
   }

   HandlingRequirmentType (String value) {
      this.value = value;
   }

   public String getValue () {
      return this.value;
   }

   public static HandlingRequirmentType getType (String value) {
      return reverseLookupMap.get(value);
   }

   public String getDescription () {
      return EnumLookupHelper.getEnumLookupDescription(name, String.valueOf(this.value));
   }

}
