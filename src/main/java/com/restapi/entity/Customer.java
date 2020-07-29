package com.restapi.entity;

public class Customer {
	
	private String username;
	private String firstName;
	private String lastName;
	private String password;
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String username, String firstName, String lastName, String password) {
		super();
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Customer [username=" + username + ", firstName=" + firstName + ", lastName=" + lastName + ", password="
				+ password + "]";
	}
	
}