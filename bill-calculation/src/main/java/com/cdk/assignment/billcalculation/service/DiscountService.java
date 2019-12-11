package com.cdk.assignment.billcalculation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cdk.assignment.discount.ThresholdDiscount;

@Service
public class DiscountService {
    
   private static final String DEFAULT_FILE = "discount-slabs.txt";
	
   public double calculateBillAmt(double purchaseAmt) {
	   		double rate=0;
            FileLineReaderService reader = new FileLineReaderService(DEFAULT_FILE);
            List<String> inputLines = reader.readLines();
            boolean discountFound=Boolean.FALSE;
            for(String line:inputLines) {
            	//System.out.println(" "+line);
            	String[] linesSpilt=line.split(" ");
            	//System.out.println(linesSpilt[0]+ " "+linesSpilt[1]);
            	String[] range=linesSpilt[0].split("-");
            	//System.out.println(range[0]+ " "+range[1]);
            	
            
             if(purchaseAmt>=Double.parseDouble(range[0]) && "above".equalsIgnoreCase(range[1])){
            	System.out.println("Discount percentage is "+linesSpilt[1]+"%");
            	rate=Double.parseDouble(linesSpilt[1]);
            	discountFound=Boolean.TRUE;
        		break;
            }
            else if(purchaseAmt>=Double.parseDouble(range[0]) && purchaseAmt<=Double.parseDouble(range[1])) {
	       		if("Nil".equalsIgnoreCase(linesSpilt[1])) {
	       			System.out.println("Discount percentage is 0%");
	       			rate=0;
	       		}
	       		else{
	       			System.out.println("Discount percentage is "+linesSpilt[1]+"%");
	       			rate=Double.parseDouble(linesSpilt[1]);
	       		}
	       		discountFound=Boolean.TRUE;
	       		break;
       	}
          }	
            if(!discountFound) {
            	System.out.println(" Discount percentage is 0%");
            	rate=0;
            }
            
           return new DiscountService().calDiscount(purchaseAmt,rate);
   }
	
    private double calDiscount(double purchaseAmt,double rate) {
    	
        	return new ThresholdDiscount().applyDiscount(purchaseAmt,rate);
         }

   
}
