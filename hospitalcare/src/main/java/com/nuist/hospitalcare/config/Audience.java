package com.nuist.hospitalcare.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@SpringBootConfiguration
@ConfigurationProperties(prefix = "jwt")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Audience {
	private String clientid;
	private String base64Secret;
	private String name;
	private int expireSecond;
}
