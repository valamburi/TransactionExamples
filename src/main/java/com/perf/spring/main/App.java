package com.perf.spring.main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.perf.spring.dao.CustomerDAO;
import com.perf.spring.model.Customer;

/**
 * Hello world!
 *
 */
public class App {

	private static final Logger logger = LogManager.getLogger(App.class);

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("Spring-Config.xml");

		CustomerDAO customerDAO1 = (CustomerDAO) ctx.getBean("customerDAO1");
		CustomerDAO customerDAO2 = (CustomerDAO) ctx.getBean("customerDAO2");

		// Customer customer = customerDAO1.getCustomerDetails(1L);

		long status = customerDAO2.createNewCustomer(new Customer(1L, "Amit", 35));
		System.out.println(status);

		/*
		 * int status=dao.updateEmployee(new Employee(102,"Sonoo",15000));
		 * System.out.println(status);
		 */

		/*
		 * Employee e=new Employee(); e.setId(102); int
		 * status=dao.deleteEmployee(e); System.out.println(status);
		 */

	}

}
