package com.restapi.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.restapi.entity.Customer;
import com.restapi.exception.NoSuchCustomerFound;

@Repository("customerRepository")
public class CustomerRepositoryImpl implements CustomerRepository {
	
	List<Customer> customers = new ArrayList<>();

	@Override
	public List<Customer> fetchCustomers() {
		return customers;
	}

	@Override
	public String createCustomer(Customer customer) {
		
		customers.add(customer);
		
		return "Customer created successfully";
	}

	@Override
	public Customer updateCustomer(String username, Customer customer) {
		
		Customer customerToUpdate = null;
		
		for(Customer c: customers) {
			if(c.getUsername().equals(username)) {
				customerToUpdate = c;
				break;
			}
		}
		
		customerToUpdate.setFirstName(customer.getFirstName());
		customerToUpdate.setLastName(customer.getLastName());
		customerToUpdate.setPassword(customer.getPassword());
		customerToUpdate.setUsername(customer.getUsername());
		
		
		
		return customerToUpdate;
	}

	@Override
	public String deleteCustomer(String userName) throws NoSuchCustomerFound {
		
		Customer customer = null;
		
		for(Customer c: customers) {
			if(c.getUsername().equals(userName)) {
				customer = c;
			}
		}
		
		if(customer == null) {
			throw new NoSuchCustomerFound("No such customer found");
		}
		
		customers.remove(customer);
		
		return "Customer has been successfully deleted";
	}

	@Override
	public Customer getCustomerById(String username) {
		
		Customer customer = null;
		
		for(Customer c: customers) {
			if(c.getUsername().equals(username)) {
				customer = c;
			}
		}
		
		System.out.println("customer: " + customer);
		
		return customer;
	}

}
