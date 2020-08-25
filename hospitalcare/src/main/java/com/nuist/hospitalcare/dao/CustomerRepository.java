package com.nuist.hospitalcare.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nuist.hospitalcare.entity.Customer;

/**
 * 
 * @author BuluGuy
 *
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	@Query(value = "from Customer c where c.name like %:name%")
	Page<Customer> findByNameLike(String name, Pageable pageable);
}
