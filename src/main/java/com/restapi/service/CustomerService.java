package com.restapi.service;

import java.util.List;

import com.restapi.entity.Customer;
import com.restapi.exception.NoSuchCustomerFound;

public interface CustomerService {

	public List<Customer> fetchCustomers();
	public String createCustomer(Customer customer);
	public Customer updateCustomer(String username, Customer customer);
	public String deleteCustomer(String userName) throws NoSuchCustomerFound;
	public Customer getCustomerById(String username);
	
}
