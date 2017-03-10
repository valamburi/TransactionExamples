/**
 * 
 */
package com.perf.spring.service;

import com.perf.spring.model.Customer;

/**
 * @author valamburi.murugan
 *
 */
public interface CustomerService {
	
	public void persistCustomers();
	
	public void persistCustomers(Customer customer1, Customer customer2);

}
