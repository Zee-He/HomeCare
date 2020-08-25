package com.nuist.hospitalcare.dao;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.nuist.hospitalcare.entity.AssessTemplate;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class AssessTemplateJpaDaoTest {
	@Autowired
	private AssessTemplateRepository assessTemplateRepository;
	
	@Test
	public void test_selectById() {
		Integer id = 1;
		Optional<AssessTemplate> optional = assessTemplateRepository.findById(id);
		
		assertEquals(optional.get().getTemplateId().intValue(), 1);
		System.out.println(optional);
		log.info("测试通过");
	}

}
