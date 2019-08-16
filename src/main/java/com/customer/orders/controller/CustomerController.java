package com.customer.orders.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.customer.orders.bean.Customer;
import com.customer.orders.service.CustomerService;

@RestController
@RequestMapping(value={"/customer"})
public class CustomerController {

	@Autowired
	CustomerService customerService;
	

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> getcustomerById(@PathVariable("id") int id) {
        Customer customer = customerService.findById(id);
        if (customer == null) {
            return new ResponseEntity<Customer>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Customer>(customer, HttpStatus.OK);
    }
    
	 @PostMapping(value="/create",headers="Accept=application/json")
	 public ResponseEntity<Void> createcustomer(@RequestBody Customer customer, UriComponentsBuilder ucBuilder){
	     customerService.createCustomer(customer);
	     HttpHeaders headers = new HttpHeaders();
	     headers.setLocation(ucBuilder.path("/customer/{id}").buildAndExpand(customer.getOrderRef()).toUri());
	     return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	 }

	 @GetMapping(value="/get", headers="Accept=application/json")
	 public List<Customer> getAllcustomer() {	 
	  List<Customer> tasks=customerService.getCustomer();
	  return tasks;
	
	 }

	@PutMapping(value="/update", headers="Accept=application/json")
	public ResponseEntity<String> updatecustomer(@RequestBody Customer currentcustomer)
	{
	Customer customer = customerService.findById(currentcustomer.getOrderRef());
	if (customer==null) {
		return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
	}
	customer.setOrderRef(currentcustomer.getOrderRef());
	customer.setOrderName(currentcustomer.getOrderName());
	customer.setNoOfOrders(currentcustomer.getNoOfOrders());
	customerService.update(customer);
	return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{id}", headers ="Accept=application/json")
	public ResponseEntity<Customer> deletecustomer(@PathVariable("id") int id){
		Customer customer = customerService.findById(id);
		if (customer == null) {
			return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		}
		customerService.deleteCustomerById(id);
		return new ResponseEntity<Customer>(HttpStatus.NO_CONTENT);
	}
	
	
}
