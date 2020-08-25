package com.nuist.hospitalcare.dao;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.nuist.hospitalcare.entity.AssessRecord;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class AssessRecordJpaDaoTest {
	@Autowired
	private AssessRecordRepository assessRecordRepository;
	
	@Test
	public void test_selectById() {
		Integer id = 1;
		Page<AssessRecord> page = assessRecordRepository.findByCid(id, PageRequest.of(0, 10));
		
		System.out.println("输出----："+page.getContent());
		log.info("测试通过");
	}

}
