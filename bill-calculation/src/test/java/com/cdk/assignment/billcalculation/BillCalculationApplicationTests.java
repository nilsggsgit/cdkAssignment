package com.cdk.assignment.billcalculation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

import com.cdk.assignment.billcalculation.service.DiscountService;


@SpringBootTest
@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = CommandLineRunner.class))
class BillCalculationApplicationTests {

	
	@Autowired
	BillCalculationApplication helloService;
	
	@Test
    void firstTestCase() throws Exception {
        assertEquals(5000, new DiscountService().calculateBillAmt(5000));
        
    }
	
	@Test
    void secontTestCase() throws Exception {
		
        assertEquals(9500, new DiscountService().calculateBillAmt(10000));
       
    }
	
	@Test
    void thirdGetCase() throws Exception {
		
        assertEquals(13500, new DiscountService().calculateBillAmt(15000));
    }
	
	 


}
