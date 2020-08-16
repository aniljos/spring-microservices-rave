package com.ms.accountservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


//@FeignClient(name="customer-service",url="localhost:9010")
@FeignClient(name="customer-service")
public interface CustomerServiceProxy {

	
	@GetMapping("/customers/{id}")
	public CustomerData findById(@PathVariable int id);
	
	
}
