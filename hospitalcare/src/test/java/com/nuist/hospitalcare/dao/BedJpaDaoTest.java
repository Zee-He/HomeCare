package com.nuist.hospitalcare.dao;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.nuist.hospitalcare.entity.Bed;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class BedJpaDaoTest {
	@Autowired
	private BedRepository bedRepository;
	
	@Test
	public void test_selectById() {
		Integer id = 1001;
		Optional<Bed> bedPage = bedRepository.findById(id);
		
		assertEquals(bedPage.get().getBid().intValue(), 1001);
		System.out.println(bedPage);
		log.info("测试通过");
	}

}
