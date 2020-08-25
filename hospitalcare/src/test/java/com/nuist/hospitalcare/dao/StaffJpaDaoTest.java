package com.nuist.hospitalcare.dao;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.nuist.hospitalcare.entity.Staff;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class StaffJpaDaoTest {
	@Autowired
	private StaffRepository staffRepository;
	@Test
	public void test_selectById() {
		 Optional<Staff> StaffOptional = staffRepository.findById(new Integer(1));
		assertEquals(StaffOptional.get().getEid().intValue(), 1);
		System.out.println(StaffOptional);
		log.info("测试通过");
		
		Page<Staff> staffPage =staffRepository.findByNameLike("j", PageRequest.of(0, 10));
		System.out.println("数量：" + staffPage.getContent()+"//");
		log.info("测试2通过");
	}

}
