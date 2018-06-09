package com.cgs.pro94tek.healthcare.type;

import java.util.Map;


public class EnumLookupHelper {
   
   /**
    * key - concatenation of enum type class name and value, ~#~ as the separator
    * value - description fetched from DB [ENUM_LOOKUP table]
    */
   private static Map<String, String> enumLookupDescriptionMap;
   private static String              enumTypeValueSeparator;

   private EnumLookupHelper () {

   }

   public static void setEnumLookupDescriptionMap (Map<String, String> enumLookupDescriptionMap) {
      EnumLookupHelper.enumLookupDescriptionMap = enumLookupDescriptionMap;
   }

   public static Map<String, String> getEnumLookupDescriptionMap () {
      return enumLookupDescriptionMap;
   }

   public static String getEnumLookupDescription (String type, String value) {
      return getEnumLookupDescriptionMap().get(type + enumTypeValueSeparator + value);
   }

   public static String getEnumTypeValueSeparator () {
      return enumTypeValueSeparator;
   }

   public static void setEnumTypeValueSeparator (String enumTypeValueSeparator) {
      EnumLookupHelper.enumTypeValueSeparator = enumTypeValueSeparator;
   }


}
