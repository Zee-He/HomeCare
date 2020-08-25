package com.nuist.hospitalcare.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.nuist.hospitalcare.entity.PurchasedService;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class PurchasedServiceJpaDaoTest {
	@Autowired
	private PurchasedServiceRepository purchasedServiceRepository;
	
	
	@Test
	public void test_select() {
		Page<PurchasedService> servicePage = purchasedServiceRepository.findByCidServiceId(7, 1, PageRequest.of(0, 10));
		
		System.out.println(servicePage.getContent());
		log.info("测试通过");
	}
}
