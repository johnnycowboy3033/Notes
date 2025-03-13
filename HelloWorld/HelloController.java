package gov.irs.protype.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import gov.irs.protype.doa.CustomerDOA;

@Controller
public class HelloController {

    @GetMapping("/hello")
    @ResponseBody
    public String sayHello() {
    	
    	CustomerDOA  customer = new CustomerDOA();
    	
    	String customer_name = customer.getCustomerById(1);
    	
        return "Hello, " + customer_name;
    }
}
