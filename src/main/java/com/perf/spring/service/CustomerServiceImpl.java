/**
 * 
 */
package com.perf.spring.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.perf.spring.dao.CustomerDAO;
import com.perf.spring.model.Customer;
import com.perf.spring.service.CustomerService;

/**
 * @author valamburi.murugan
 *
 */
@Service(value = "CustomerServiceImpl")
public class CustomerServiceImpl implements CustomerService {

	private static final Logger log = LoggerFactory.getLogger(CustomerServiceImpl.class);

	@Autowired
	@Qualifier(value = "customerDAO1")
	private CustomerDAO customerDAO1;

	@Autowired
	@Qualifier(value = "customerDAO2")
	private CustomerDAO customerDAO2;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.perf.spring.service.CustomerService#persistCustomers()
	 */
	@Transactional
	public void persistCustomers() {

		long status = customerDAO1.createNewCustomer(new Customer(2L, "Ajay", 25));
		log.debug("status:: " + status);

		status = customerDAO2.createNewCustomer(new Customer(2L, "Ajay", 35));
		log.debug("status:: " + status);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.perf.spring.service.CustomerService#persistCustomers(com.perf.spring.
	 * model.Customer, com.perf.spring.model.Customer)
	 */
	// @Transactional
	public void persistCustomers(Customer customer1, Customer customer2) {
		log.debug("persistCustomers: customer1=[{}]; customer2=[{}]", customer1, customer2);

		long status = customerDAO1.createNewCustomer(customer1);
		log.debug("status:: " + status);

		status = customerDAO2.createNewCustomer(customer2);
		log.debug("status:: " + status);

	}

}
