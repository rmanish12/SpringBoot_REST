package com.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.entity.Customer;
import com.restapi.exception.NoSuchCustomerFound;
import com.restapi.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
//	@GetMapping
//	public ResponseEntity<List<Customer>> fetchCustomer() {
//		List<Customer> customers = customerService.fetchCustomers();
//		
//		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
//	}
	
	@GetMapping(produces="application/json")
	public ResponseEntity<Customer> getCustomerById(@RequestParam("username") String username) {
		System.out.println("Username: " + username);
		Customer customer = customerService.getCustomerById(username);
		
		if(customer==null) {
			return new ResponseEntity<Customer>(customer, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}
	
	@GetMapping
	public List<Customer> fetchCustomer() {
		return customerService.fetchCustomers();
	}
	
	
	// using ResponseEntity
	@PostMapping
	public ResponseEntity<String> createCustomer(@RequestBody Customer customer) {
		String userCreated = customerService.createCustomer(customer);
		
		return new ResponseEntity<String>(userCreated, HttpStatus.OK);
	}
	
	@PutMapping(value = "/{username}", consumes="application/json")
	public ResponseEntity<Customer> updateCustomer(@PathVariable String username, @RequestBody Customer customer) {
		
		Customer updatedCustomer = customerService.updateCustomer(username, customer);
		
		return new ResponseEntity<Customer>(updatedCustomer, HttpStatus.OK);
	}
	
	@DeleteMapping("/{username}")
	public ResponseEntity<String> deleteCustomer(@PathVariable String username) throws NoSuchCustomerFound {
		
		String deleteCustomer = customerService.deleteCustomer(username);
		
		if(deleteCustomer.equals("No such customer found")) {
			return new ResponseEntity<String>(deleteCustomer, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<String>(deleteCustomer, HttpStatus.OK);
	}
	
}
