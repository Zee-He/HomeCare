package com.nuist.hospitalcare.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class DependentJpaDaoTest2 {
	@Autowired
	private DependentRepository dependentRepository;
	
//	@Test
//	public void test_select() {
//		System.out.println(customerHealthRepository.findAll());
//		log.info("测试通过");
//	}
	
	@Test
	public void test_find() {
		Integer id=new Integer(1);
		System.out.println(dependentRepository.findByCid(id,PageRequest.of(0, 10)).getContent());
		log.info("测试通过");
	}
}
