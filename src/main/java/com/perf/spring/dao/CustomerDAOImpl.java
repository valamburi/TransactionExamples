/**
 * 
 */
package com.perf.spring.dao;

import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import com.perf.spring.dao.CustomerDAO;
import com.perf.spring.model.Customer;

import org.slf4j.Logger;

/**
 * @author valamburi.murugan
 *
 */
public class CustomerDAOImpl implements CustomerDAO {

	private static final Logger log = LoggerFactory.getLogger(CustomerDAOImpl.class);

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	private static final String QUERY_NEW_CUSTOMER = "INSERT INTO PERFPOC.CUSTOMER (CUST_ID, NAME, AGE) VALUES (?, ?, ?)";
	private static final String QUERY_CUSTOMER_BY_ID = "SELECT CUST_ID, NAME, AGE FROM PERFPOC.CUSTOMER WHERE CUST_ID = ?";

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.perf.spring.dao.CustomerDAO#createNewCustomer(com.perf.spring.model.
	 * Customer)
	 */
	public long createNewCustomer(Customer customer) {
		log.debug("createNewCustomer():: customer={}", customer);

		int status = jdbcTemplate.update(QUERY_NEW_CUSTOMER,
				new Object[] { customer.getCustId(), customer.getName(), customer.getAge() });

		log.debug("createNewCustomer():: Affected Rows={}", status);
		return status;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.perf.spring.dao.CustomerDAO#getCustomerDetails(java.lang.Long)
	 */
	public Customer getCustomerDetails(Long custId) {
		log.debug("getCustomerDetails():: custId={}", custId);

		Customer customer = (Customer) jdbcTemplate.queryForObject(QUERY_CUSTOMER_BY_ID, new Object[] { custId },
				Customer.class);

		log.debug("getCustomerDetails():: customer={}", customer);
		return customer;
	}

}
