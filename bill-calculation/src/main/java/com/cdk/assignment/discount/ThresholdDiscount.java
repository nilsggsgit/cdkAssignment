package com.cdk.assignment.discount;


public class ThresholdDiscount implements Discount {

	@Override
	public double applyDiscount(double totalAmount,double discPer) {
		
		double  s,amount;
        		
		
		//System.out.println("totalAmount= "+totalAmount);
	 
		//System.out.println("discount rate="+discPer);
	         
	    s=100-discPer;
	 
		amount= (s*totalAmount)/100;
	 
		//System.out.println("amount after discount="+amount);
		return amount;
	}	
}
	
