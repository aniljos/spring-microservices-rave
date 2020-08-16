package com.ms.customerservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class CustomerController {
	
	@Autowired
	private CustomerRepository repository;
	
	@Autowired
	private Environment env;
	
	@Autowired
	private PageConfig pageConfig;

	@GetMapping("/customers/{id}")
	public Customer findById(@PathVariable int id) {
		
		Customer customer = repository.findById(id).get();
		customer.setPortNumber(env.getProperty("local.server.port"));
		return customer;
	}
	
	@GetMapping("/pageconfig")
	public String getPageConfig() {
		
		//return String.format("PageSize: %s, StartIndex: %s", env.getProperty("app.customer.pageSize"), env.getProperty("app.customer.startIndex"));
		return String.format("PageSize: %s, StartIndex: %s", pageConfig.getPageSize(), pageConfig.getStartIndex());
		
	}
}


























