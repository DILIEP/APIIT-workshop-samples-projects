package com.example.domain;

import java.util.List;

public class CustomerListResponse {

	private List<Customer> customersList;

	public List<Customer> getCustomersList() {
		return customersList;
	}

	public void setCustomersList(List<Customer> customersList) {
		this.customersList = customersList;
	}
}
