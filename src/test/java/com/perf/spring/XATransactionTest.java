/**
 * 
 */
package com.perf.spring;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.perf.spring.dao.CustomerDAO;
import com.perf.spring.model.Customer;

/**
 * @author valamburi.murugan
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:Spring-Config.xml")
public class XATransactionTest {

	private static final Logger log = LoggerFactory.getLogger(XATransactionTest.class);

	@Autowired
	@Qualifier(value = "customerDAO1")
	private CustomerDAO customerDAO1;

	@Autowired
	@Qualifier(value = "customerDAO2")
	private CustomerDAO customerDAO2;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		log.debug("Test setUp");
	}

	@Transactional
	@Test
	public void persistCustomersWithTransaction() {

		long status = customerDAO1.createNewCustomer(new Customer(3L, "Ajay", 25));
		log.debug("status:: " + status);

		status = customerDAO2.createNewCustomer(new Customer(3L, "Ajay", 35));
		log.debug("status:: " + status);

	}

	@Test
	public void persistCustomersWithoutTransaction() {

		long status = customerDAO1.createNewCustomer(new Customer(3L, "Ajay", 25));
		log.debug("status:: " + status);

		status = customerDAO2.createNewCustomer(new Customer(3L, "Ajay", 35));
		log.debug("status:: " + status);

	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		log.debug("Test tearDown");
	}

}
