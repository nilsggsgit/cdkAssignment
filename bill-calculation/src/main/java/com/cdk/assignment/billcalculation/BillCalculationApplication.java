package com.cdk.assignment.billcalculation;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cdk.assignment.billcalculation.service.DiscountService;
import com.cdk.assignment.exceptions.InvalidAmountException;


@SpringBootApplication
public class BillCalculationApplication implements CommandLineRunner {
	
	public static void main(String[] args) {
		//SpringApplication.run(BillCalculationApplication.class, args);
		
        SpringApplication app = new SpringApplication(BillCalculationApplication.class);
        //app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
	}

	    @Override
	    public void run(String... args) throws InvalidAmountException {

	        try{
	        	 if (args.length > 0 ) {
	        		  if(Double.parseDouble(args[0])>0) {
	        			  System.out.println("Final Bill amount : "+ new DiscountService().calculateBillAmt(Double.parseDouble(args[0])));
	        		  }
	        		  else{
	        			  throw new InvalidAmountException(args[0]);
	        		  }
	    		
	        	 }
	        } 
	        catch(NumberFormatException exp){
	    		System.out.println("Catch Block") ;
	    		throw new NumberFormatException("Invalid Purchase Amount : "+args[0]+" Entered");
	    		
	    	}
	    	catch(InvalidAmountException exp){
	    		System.out.println("Catch Block") ;
	    		System.out.println(exp) ;
	    	}
	       
	        
	    }
}
