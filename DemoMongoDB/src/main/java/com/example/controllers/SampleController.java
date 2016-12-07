package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.domain.Customer;
import com.example.domain.CustomerListResponse;
import com.example.repository.CustomerRepository;

@Controller
public class SampleController {

	@Autowired
	CustomerRepository customerRepository;

	@RequestMapping(value = "/lc", method = RequestMethod.GET)
	public @ResponseBody CustomerListResponse listCustomer() {
		System.out.println("listCustomer.....");

		//////////////////////////////////////////////////////////////////////
		if (customerRepository != null) {
			System.out.println("customerRepository != null ....");
		}

		List<Customer> customersList = customerRepository.findAll();
		System.out.println("List size ... " + customersList.size());

		if (customersList != null) {
			for (Customer customer : customersList) {
				System.out.println(customer.getFname() + " - " + customer.getMname() + " - " + customer.getLname()
						+ " - " + customer.getBasic());
			}
		}

		List<Customer> customersList2 = customerRepository.findByFname("vidya2");
		System.out.println("List2 size ... " + customersList2.size());

		if (customersList2 != null) {
			for (Customer customer : customersList2) {
				System.out.println(customer.getFname() + " - " + customer.getMname() + " - " + customer.getLname()
						+ " - " + customer.getBasic());
			}
		}

		List<Customer> customersList3 = customerRepository.findCustomersByBasicGreaterThan(new Integer(30000));
		System.out.println("List3 size ... " + customersList3.size());

		if (customersList3 != null) {
			for (Customer customer : customersList3) {
				System.out.println(customer.getFname() + " - " + customer.getMname() + " - " + customer.getLname()
						+ " - " + customer.getBasic());
			}
		}

		List<Customer> customersList4 = customerRepository.findCustomersByBasicLessThan(new Integer(30000));
		System.out.println("List4 size ... " + customersList3.size());

		if (customersList4 != null) {
			for (Customer customer : customersList4) {
				System.out.println(customer.getFname() + " - " + customer.getMname() + " - " + customer.getLname()
						+ " - " + customer.getBasic());
			}
		}

		List<Customer> customersList5 = customerRepository.findByFname(null);
		System.out.println("List5 size ... " + customersList5.size());

		if (customersList5 != null) {
			for (Customer customer : customersList5) {
				System.out.println(customer.getFname() + " - " + customer.getMname() + " - " + customer.getLname()
						+ " - " + customer.getBasic());
			}
		}

		//////////////////////////////////////////////////////////////////////

		CustomerListResponse customerListResponse = new CustomerListResponse();
		customerListResponse.setCustomersList(customersList);
		return customerListResponse;
	}

	@RequestMapping(value = "/lc/{customerId}", method = RequestMethod.GET)
	public @ResponseBody Customer findCustomerById(@PathVariable(name = "customerId") String customerId) {
		System.out.println("-------findCustomerById ------ " + customerId);
		Customer customer = customerRepository.findOne(customerId);
		System.out.println("------- " + customer.getFname() + " - " + customer.getMname() + " - " + customer.getLname()
				+ " - " + customer.getBasic());
		return customer;
	}

	@RequestMapping(value = "/lc/fname/{fname}", method = RequestMethod.GET)
	public @ResponseBody List<Customer> findByFnameLike(@PathVariable(name = "fname", required = true) String fname) {
		System.out.println("----*---findByFnameLike ------ " + fname);
		List<Customer> customersList = customerRepository.findByFnameLike(fname);
		System.out.println("----*--- " + customersList.size());
		for (Customer customer : customersList) {
			System.out.println("----*---- " + customer.getFname() + " - " + customer.getMname() + " - "
					+ customer.getLname() + " - " + customer.getBasic());
		}
		return customersList;
	}

	@RequestMapping(value = "/lc/lowerbound/{lowerBound}/upperbound/{upperBound}", method = RequestMethod.GET)
	public @ResponseBody List<Customer> findCustomersByBasicBetween(
			@PathVariable(name = "lowerBound", required = true) Integer lowerBound,
			@PathVariable(name = "upperBound", required = true) Integer upperBound) {
		System.out.println("----#---findCustomersByBasicBetween ------ " + lowerBound + " - " + upperBound);
		List<Customer> customersList = customerRepository.findCustomersByBasicBetween(lowerBound, upperBound);
		System.out.println("----#--- " + customersList.size());
		for (Customer customer : customersList) {
			System.out.println("----#---- " + customer.getFname() + " - " + customer.getMname() + " - "
					+ customer.getLname() + " - " + customer.getBasic());
		}
		return customersList;
	}

}
