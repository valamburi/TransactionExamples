/**
 * 
 */
package com.perf.spring.dao.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

import com.perf.spring.dao.CustomerDAO;
import com.perf.spring.model.Customer;

/**
 * @author valamburi.murugan
 *
 */
public class CustomerDAOImpl implements CustomerDAO {

	private static final Logger logger = LogManager.getLogger(CustomerDAOImpl.class);

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	private static final String QUERY_NEW_CUSTOMER = "INSERT INTO CUSTOMER (CUST_ID, NAME, AGE) VALUES (?, ?, ?)";
	private static final String QUERY_CUSTOMER_BY_ID = "SELECT CUST_ID, NAME, AGE FROM CUSTOMER WHERE CUST_ID = ?";

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.perf.spring.dao.CustomerDAO#createNewCustomer(com.perf.spring.model.
	 * Customer)
	 */
	public long createNewCustomer(Customer customer) {
		logger.debug("createNewCustomer():: customer={}", customer);

		int status = jdbcTemplate.update(QUERY_NEW_CUSTOMER,
				new Object[] { customer.getCustId(), customer.getName(), customer.getAge() });

		logger.debug("createNewCustomer():: Affected Rows={}", status);
		return status;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.perf.spring.dao.CustomerDAO#getCustomerDetails(java.lang.Long)
	 */
	public Customer getCustomerDetails(Long custId) {
		logger.debug("getCustomerDetails():: custId={}", custId);

		Customer customer = (Customer) jdbcTemplate.queryForObject(QUERY_CUSTOMER_BY_ID, new Object[] { custId },
				Customer.class);

		logger.debug("getCustomerDetails():: customer={}", customer);
		return customer;
	}

}
