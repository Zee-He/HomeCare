package com.nuist.hospitalcare.config;

import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.JdkRegexpMethodPointcut;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import com.alibaba.druid.support.spring.stat.DruidStatInterceptor;

@SpringBootConfiguration
public class DruidConfig {
	@Bean
	public DruidStatInterceptor druidStatInterceptor() {
		DruidStatInterceptor dsInterceptor = new DruidStatInterceptor();
		return dsInterceptor;
	}

	@Bean
	@Scope("prototype")
	public JdkRegexpMethodPointcut druidStatPointcut() {
		JdkRegexpMethodPointcut pointcut = new JdkRegexpMethodPointcut();
//		pointcut.setPattern("com.jdbc.dao.*");
		pointcut.setPatterns("com.nuist.hospitalcare.controller.*", "com.nuist.hospitalcare.service.impl.*",
				"com.nuist.hospitalcare.dao.*");
		return pointcut;
	}

	@Bean
	public DefaultPointcutAdvisor druidStatAdvisor(DruidStatInterceptor druidStatInterceptor,
			JdkRegexpMethodPointcut druidStatPointcut) {
		DefaultPointcutAdvisor defaultPointAdvisor = new DefaultPointcutAdvisor();
		defaultPointAdvisor.setPointcut(druidStatPointcut);
		defaultPointAdvisor.setAdvice(druidStatInterceptor);
		return defaultPointAdvisor;
	}

}
