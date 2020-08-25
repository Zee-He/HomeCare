package com.nuist.hospitalcare.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.nuist.hospitalcare.entity.SystemUser;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class SystemUserServiceTest {
	@Autowired
	private SystemUserService systemUserService;

	@Test
	public void test_login() {
		SystemUser staff = systemUserService.login(7, "QVW8LG884SRL1WXHCTY5");
		System.out.println(staff);
		assertEquals(staff.getUserName(), "RWJXYGGRSAFR42I1FD8X");
		log.info("测试通过");
	}
}
