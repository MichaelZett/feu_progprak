package hh.fernuni.rentamovie.customer.application;

import java.time.LocalDate;
import java.util.Collection;

import hh.fernuni.rentamovie.customer.domain.Customer;

public interface CustomerService {
	Customer createCustomer(String surename, String lastname, LocalDate birthday);

	static CustomerService getService() {
		return CustomerServiceImpl.getInstance();
	}

	Collection<Customer> readAllCustomers();

	void updateCustomers(Customer currentUser, String firstname, String lastname, LocalDate birthdate);
}
