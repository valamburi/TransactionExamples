/**
 * 
 */
package com.perf.spring.service.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.AfterTransaction;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.transaction.annotation.Transactional;

import com.perf.spring.model.Customer;
import com.perf.spring.service.CustomerService;

/**
 * @author valamburi.murugan
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:Spring-Config.xml")
public class CustomerServiceImplTest {

	private static final Logger log = LoggerFactory.getLogger(CustomerServiceImplTest.class);

	@Autowired
	private CustomerService customerService;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		log.debug("Test setUp");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		log.debug("Test tearDown");
	}

	@Ignore
	@Test
	public void testPersistCustomers() {
		log.debug("testPersistCustomers");

		customerService.persistCustomers();

		// log.debug("status:: " + status);
	}

	/**
	 * Tests that the size and first record match what is expected before the
	 * transaction.
	 */
	@BeforeTransaction
	public void beforeTransaction() {
		// testPerson(true, LAST_NAME);
	}

	@Test
	@Transactional
	public void testPersistCustomersWithParams() {
		log.debug("testPersistCustomersWithParams");

		Customer customer1 = new Customer(3L, "Ajay", 25);
		Customer customer2 = new Customer(3L, "Ajay", 35);

		customerService.persistCustomers(customer1, customer2);

		// log.debug("status:: " + status);
	}

	/**
	 * Tests that the size and first record match what is expected after the
	 * transaction.
	 */
	@AfterTransaction
	public void afterTransaction() {
		// testPerson(false, LAST_NAME);
	}

	/**
	 * Tests person table.
	 */
	// protected void testPerson(boolean beforeTransaction, String
	// matchLastName) {
	// List<Map<String, Object>> lPersonMaps = jdbcTemplate.queryForList("SELECT
	// * FROM PERSON");
	//
	// assertNotNull("Person list is null.", lPersonMaps);
	// assertEquals("Number of persons should be " + SIZE + ".", SIZE,
	// lPersonMaps.size());
	//
	// Map<String, Object> hPerson = lPersonMaps.get(0);
	//
	// logger.debug((beforeTransaction ? "Before" : "After") + " transaction. "
	// + hPerson.toString());
	//
	// Integer id = (Integer) hPerson.get("ID");
	// String firstName = (String) hPerson.get("FIRST_NAME");
	// String lastName = (String) hPerson.get("LAST_NAME");
	//
	// if (ID.equals(id)) {
	// assertEquals("Person first name should be " + FIRST_NAME + ".",
	// FIRST_NAME, firstName);
	// assertEquals("Person last name should be " + matchLastName + ".",
	// matchLastName, lastName);
	// }
	// }

}
