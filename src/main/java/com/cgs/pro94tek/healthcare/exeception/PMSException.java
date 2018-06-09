package com.cgs.pro94tek.healthcare.exeception;

public class PMSException extends java.lang.Exception {

 
	private static final long serialVersionUID = -8913174190447692187L;

	
   public int code = 10000;

   

   public PMSException (int exceptionCode, String message) {
      super(message);
      this.code = exceptionCode;
   }

   public PMSException (int exceptionCode, String message, Throwable cause) {
      super(message, cause);
      this.code = exceptionCode;
   }

   public PMSException (int exceptionCode, Throwable cause) {
      super(cause);
      this.code = exceptionCode;
   }

   public int getCode () {
      return this.code;
   }

}
