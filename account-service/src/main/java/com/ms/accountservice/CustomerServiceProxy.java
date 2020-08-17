package com.ms.accountservice;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


//@FeignClient(name="customer-service",url="localhost:9010")
//@FeignClient(name="customer-service")
@FeignClient(name="zuul-api-gateway")
@RibbonClient(name="customer-service")
public interface CustomerServiceProxy {

	
	@GetMapping("/customer-service/customers/{id}")
	public CustomerData findById(@PathVariable int id);
	
	
}
