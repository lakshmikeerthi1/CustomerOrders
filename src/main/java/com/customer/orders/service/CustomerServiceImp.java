package com.customer.orders.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.customer.orders.bean.Customer;

@Service
public class CustomerServiceImp implements CustomerService {

	private static List<Customer> customers;

	static {
		customers = dummyCustomers();
	}

	public List<Customer> getCustomer() {
		// TODO Auto-generated method stub
		return customers;
	}

	public Customer findById(int id) {
		// TODO Auto-generated method stub
		for (Customer Customer : customers) {
			if (Customer.getOrderRef() == id) {
				return Customer;
			}
		}
		return null;
	}

	public void createCustomer(Customer Customer) {
		// TODO Auto-generated method stub
		customers.add(Customer);
	}

	public void deleteCustomerById(int id) {
		// TODO Auto-generated method stub
		Iterator<Customer> it = customers.iterator();
		while (it.hasNext()) {
			Customer Customer = (Customer) it.next();
			if (Customer.getOrderRef() == id) {
				it.remove();
			}
		}
	}

	/*
	 * public void updatePartially(Customer currentCustomer, int id) { for (Customer
	 * Customer : Customers) { if (Customer.getOrderRef() == id) { if (currentCustomer.getCountry()
	 * != null) { Customer.setId(id); Customer.setCountry(currentCustomer.getCountry()); }
	 * Customer.setName(Customer.getName()); update(Customer); } }
	 * 
	 * }
	 */
	public void update(Customer Customer) {
		// TODO Auto-generated method stub
		int index = customers.indexOf(Customer);
		customers.set(index, Customer);
	}

	private static List<Customer> dummyCustomers() {
		// TODO Auto-generated method stub
		List<Customer> orders = new ArrayList<Customer>();
		orders.add(new Customer(1221, "Order1", 4));
		orders.add(new Customer(1222, "Order2", 5));
		orders.add(new Customer(1223, "Order3", 6));
		orders.add(new Customer(1224, "Order4", 7));
		return orders;
	}

}
