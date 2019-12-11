package com.cdk.assignment.exceptions;

public class InvalidAmountException extends Exception{
	
	   String str1;
	  
	  public InvalidAmountException(String str2) {
		str1=str2;
	   }
	   public String toString(){ 
		   return ("Invalid Purchase Amount : "+str1+" Entered") ;
	   }
}
