package com.example.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.domain.Customer;
import java.lang.String;
import java.util.List;

public interface CustomerRepository extends MongoRepository<Customer, String> {

	public List<Customer> findByFname(String fname);

	public List<Customer> findByFnameLike(String fname);

	@Query("{ basic : { $gte : ?0 } }")
	public List<Customer> findCustomersByBasicGreaterThan(Integer basic);

	@Query("{ basic : { $lte : ?0 } }")
	public List<Customer> findCustomersByBasicLessThan(Integer basic);

	@Query("{basic:{$gt:?0,$lt:?1}}")
	public List<Customer> findCustomersByBasicBetween(Integer lowerBound, Integer upperBound);
}
