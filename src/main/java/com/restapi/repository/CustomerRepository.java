package com.restapi.repository;

import java.util.List;

import com.restapi.entity.Customer;
import com.restapi.exception.NoSuchCustomerFound;

public interface CustomerRepository {

	public List<Customer> fetchCustomers();
	public String createCustomer(Customer customer);
	public Customer updateCustomer(String username, Customer customer);
	public String deleteCustomer(String userName) throws NoSuchCustomerFound;
	public Customer getCustomerById(String username);
	
}
