package com.nuist.hospitalcare.dao;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.nuist.hospitalcare.entity.BedRelationship;
import com.nuist.hospitalcare.entity.BedRelationshipKey;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class BedRelationshipJpaDaoTest {
	@Autowired
	private BedRelationshipRepository bedRelationshipRepository;
	
	@Test
	public void test_selectById() {
		BedRelationshipKey bedRelationshipKey = new BedRelationshipKey(new Integer(1), new Integer(1003));
		Optional<BedRelationship> bedRelationshipOptional = bedRelationshipRepository.findById(bedRelationshipKey);
		
		assertEquals(bedRelationshipOptional.get().getBid().intValue(), 1003);
		System.out.println(bedRelationshipOptional);
		log.info("测试通过");
	}

}
