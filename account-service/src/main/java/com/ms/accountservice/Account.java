package com.ms.accountservice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="accounts")
public class Account {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private double balance;
	
	@Column(name="cust_id")
	private int custId;
	
	@Transient
	private CustomerData customer;
	
	public Account() {
		
	}

	public Account(int id, double balance, int custId) {
		super();
		this.id = id;
		this.balance = balance;
		this.custId = custId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public CustomerData getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerData customer) {
		this.customer = customer;
	}
	
	
	
	
	
}


