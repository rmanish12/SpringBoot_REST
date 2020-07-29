package com.restapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.entity.Customer;
import com.restapi.exception.NoSuchCustomerFound;
import com.restapi.repository.CustomerRepository;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepo;
	
	@Override
	public List<Customer> fetchCustomers() {
		return customerRepo.fetchCustomers();
	}

	@Override
	public String createCustomer(Customer customer) {
		return customerRepo.createCustomer(customer);
	}

	@Override
	public Customer updateCustomer(String username, Customer customer) {
		return customerRepo.updateCustomer(username, customer);
	}

	@Override
	public String deleteCustomer(String userName) throws NoSuchCustomerFound {
		return customerRepo.deleteCustomer(userName);
	}

	@Override
	public Customer getCustomerById(String username) {
		return customerRepo.getCustomerById(username);
	}

}
