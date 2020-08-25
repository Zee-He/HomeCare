package com.nuist.hospitalcare.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.filter.FormContentFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import com.nuist.hospitalcare.converter.MyDateConverter;
import com.nuist.hospitalcare.interceptor.LoginInterceptor;


@SpringBootConfiguration
public class HospitalCareConfig extends WebMvcConfigurationSupport {

	@Autowired
	private MyDateConverter myDateConverter;
	@Autowired
	private LoginInterceptor loginInterceptor;
	
	/**
	 * 添加拦截器
	 */
	@Override
	protected void addInterceptors(InterceptorRegistry registry) {
		// 注册拦截器
		registry.addInterceptor(loginInterceptor)
			// 拦截请求
			.addPathPatterns("/**")
			// 例外请求
			.excludePathPatterns(
					"/js/**","/css/**","/images/**", "/static/**",
					"/webjars/**", 
					"/user/login", "/user/logout",
					"/swagger-ui.html/**","/v2/**","/swagger-resources/**",
					"/druid/**");
	}
	
	/**
	 * 解决PUT请求无法获取数据
	 * @return
	 */
	@Bean
	public FormContentFilter httpPutFormContentFilter() {
		return new FormContentFilter();
	}
	
	/**
	 * 注册日期转换器
	 */
	@Override
	protected void addFormatters(FormatterRegistry registry) {
		registry.addConverter(myDateConverter);
		super.addFormatters(registry);
	}

	/**
	 * 资源映射
	 */
	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**").addResourceLocations("classpath:/META-INF/resources/")
				.addResourceLocations("classpath:/resources/").addResourceLocations("classpath:/public/")
				.addResourceLocations("classpath:/static/").addResourceLocations("classpath:/templates/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("/webjars/").resourceChain(false);
		super.addResourceHandlers(registry);
	}

	@Override
	protected void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("*").allowCredentials(true)
		.allowedMethods("GET","POST","PUT","DELETE","PATCH","OPTIONS","HEAD").allowedHeaders("*").maxAge(3600*48);
		super.addCorsMappings(registry);
	}
	
	
}
