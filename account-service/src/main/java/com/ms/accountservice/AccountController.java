package com.ms.accountservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping
public class AccountController {

	@Autowired
	private AccountRepository repository;
	
	@Autowired
	private CustomerServiceProxy customerServiceProxy;
	
	@GetMapping("/accounts/{id}")
	public Account fetchById(@PathVariable int id) {
		
		Account account = repository.findById(id).get();
		
		String url = "http://localhost:9010/customers/" + account.getCustId();
		RestTemplate restTemplate = new RestTemplate();
		CustomerData customerData =  restTemplate.getForObject(url, CustomerData.class);
		account.setCustomer(customerData);
		
		return account;
	}
	
	@GetMapping("/accounts-feigh/{id}")
	public Account fetchByIdUsingFeigh(@PathVariable int id) {
		
		Account account = repository.findById(id).get();
		
		CustomerData customerData = customerServiceProxy.findById(account.getCustId());
		account.setCustomer(customerData);
		
		return account;
	}
	
}
