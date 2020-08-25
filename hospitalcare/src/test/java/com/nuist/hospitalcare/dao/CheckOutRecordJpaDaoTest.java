package com.nuist.hospitalcare.dao;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.nuist.hospitalcare.entity.CheckOutRecord;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class CheckOutRecordJpaDaoTest {
	@Autowired
	private CheckOutRecordRepository checkOutRecordRepository;
	
	@Test
	public void name() {
		Page<CheckOutRecord> checkPage = checkOutRecordRepository.findByCidAndBidAndCheckoutDate(5, 2, new Date(), PageRequest.of(0, 2));
		System.out.println(checkPage.getContent());
		log.info("测试通过");
	}
}
