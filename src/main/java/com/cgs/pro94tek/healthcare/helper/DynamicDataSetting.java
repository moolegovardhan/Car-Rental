package com.cgs.pro94tek.healthcare.helper;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.MessageDigest;

import com.cgs.pro94tek.healthcare.modal.UserModal;
import com.cgs.pro94tek.spring.model.User;

public class DynamicDataSetting {
	



	public void dynamicSetting(Object one,Object two){
		
		System.out.println("Fields 1 "+one.getClass().getDeclaredFields().length);
		System.out.println("Fields 2 "+two.getClass().getDeclaredFields().length);
		System.out.println("Methods 1 "+one.getClass().getMethods());
		System.out.println("Methods 2 "+two.getClass().getMethods());
		Method[] twoMethods = two.getClass().getMethods();
		Field[] fields = one.getClass().getFields();
		for(Method  method : twoMethods){
			//System.out.println("Method is : "+method);
			for(Field field : one.getClass().getDeclaredFields()){
				//System.out.println(onemethod.getName());
				//System.out.println(method.getName());
				
				String setMethodName = "set"+field+"()";
				String getMethodName = "get"+field+"()";
				System.out.println("setMethodName"+setMethodName);
				System.out.println("getMethodName"+getMethodName);
				//two.getMethod(setMethodName);
				System.out.println();
				
			}
		}
		System.out.println("Lengths.........."+fields.length);
		for(Field field : fields){
			
			System.out.println("Field is : "+field);
		}
	}
	
	private static String hashString(String message, String algorithm)
	        throws Exception {
	 
	    try {
	        MessageDigest digest = MessageDigest.getInstance(algorithm);
	        byte[] hashedBytes = digest.digest(message.getBytes("UTF-8"));
	 
	        return convertByteArrayToHexString(hashedBytes);
	    } catch (Exception ex) {
	        throw new Exception();
	    }
	}
	
	private static String convertByteArrayToHexString(byte[] arrayBytes) {
	    StringBuffer stringBuffer = new StringBuffer();
	    for (int i = 0; i < arrayBytes.length; i++) {
	        stringBuffer.append(Integer.toString((arrayBytes[i] & 0xff) + 0x100, 16)
	                .substring(1));
	    }
	    return stringBuffer.toString();
	}

	public static void main(String[] args) throws Exception {
		
		User user = new User();
		UserModal userModal = new UserModal();
		DynamicDataSetting dds = new DynamicDataSetting();
		System.out.println(dds.hashString("hanuman", "SHA-256"));
		//dds.dynamicSetting(userModal, user);
		

	}

}
