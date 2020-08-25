package com.nuist.hospitalcare.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.nuist.hospitalcare.entity.Customer;

import lombok.extern.slf4j.Slf4j;

/**
 * 客户信息服务类测试
 */
@SpringBootTest
@Slf4j
public class CustomerServiceTest {
	@Autowired
	private CustomerService customerService;
	
	/**
	 * 测试分页查询所有
	 */
	@Test
	public void test_findAll() {
		List<Customer> customers = customerService.selectAllInPage(PageRequest.of(0, 5)).getContent();
		System.out.println(customers);
		assertEquals(customers.size(), 5);
		log.info("测试通过");
	}
	
	/**
	 * 测试分页条件查询
	 */
	@Test
	public void test_findByName() {
		Page<Customer> customers = customerService.findByNameInPage("U7DPMAUVFDJS3", PageRequest.of(0, 5));
		System.out.println(customers.getTotalPages());
		System.out.println(customers.getNumber());
		System.out.println(customers.getSize());
		System.out.println(customers.getContent());
		log.info("测试通过");
	}
	
	/**
	 * 测试非法插入
	 */
	@Test
	public void test_errorInsert() {
		boolean flag = customerService.insert(new Customer(1, "tt", 50, "男", "123123123412341234", "12312312345", "cesvs"));
		assertEquals(flag, false);
		log.info("测试通过");
	}
}
