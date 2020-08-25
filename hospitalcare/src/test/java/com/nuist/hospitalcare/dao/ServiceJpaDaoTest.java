package com.nuist.hospitalcare.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.nuist.hospitalcare.entity.Service;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class ServiceJpaDaoTest {
	@Autowired
	private ServiceRepository serviceRepository;
	
	
	@Test
	public void test_select() {
		Integer id = 5;
		Optional<Service> service = serviceRepository.findById(id);
		assertEquals(service.get().getServiceId().intValue(), id.intValue());
		System.out.println(service);
		log.info("测试通过");
	}
}
