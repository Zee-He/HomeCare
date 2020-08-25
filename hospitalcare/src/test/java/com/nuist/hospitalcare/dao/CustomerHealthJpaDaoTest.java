package com.nuist.hospitalcare.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class CustomerHealthJpaDaoTest {
	@Autowired
	private CustomerHealthRepository customerHealthRepository;
	
	@Test
	public void test_select() {
		System.out.println(customerHealthRepository.findAll());
		log.info("测试通过");
	}
}
