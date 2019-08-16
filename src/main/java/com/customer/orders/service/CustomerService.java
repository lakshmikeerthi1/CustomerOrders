package com.customer.orders.service;

import java.util.List;

import com.customer.orders.bean.Customer;

public interface CustomerService {
	public void createCustomer(Customer Customer);
	public List<Customer> getCustomer();
	public Customer findById(int id);
	public void update(Customer Customer);
	public void deleteCustomerById(int id);
	//public void updatePartially(Customer Customer, int id);
}
