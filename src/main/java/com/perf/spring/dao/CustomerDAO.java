/**
 * 
 */
package com.perf.spring.dao;

import com.perf.spring.model.Customer;

/**
 * @author valamburi.murugan
 *
 */
public interface CustomerDAO {

	/**
	 * 
	 * @param customer
	 *            create new Customer
	 * @return CUST_ID after creating
	 */
	public long createNewCustomer(Customer customer);

	/**
	 * @param custId
	 *            of the Customer
	 * @return Customer for the given CUST_ID
	 */
	public Customer getCustomerDetails(Long custId);

}
