package com.nuist.hospitalcare.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.alibaba.fastjson.JSON;
import com.nuist.hospitalcare.bean.ResultBean;
import com.nuist.hospitalcare.config.Audience;
import com.nuist.hospitalcare.util.JWTTokenUtil;

/**
 * 登录拦截器
 */
@Component
public class LoginInterceptor implements HandlerInterceptor{
	
	@Autowired
	private Audience audience;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		// 使用JWT
		if (HttpMethod.OPTIONS.toString().equals(request.getMethod())) {
			return true;
		}
		
		final String token = request.getHeader(JWTTokenUtil.AUTH_HEAD_KEY);
		try {
			if (null != token && !token.isEmpty() && !JWTTokenUtil.isExpiration(token, audience.getBase64Secret())) {
				return true;
			}
		} catch (Exception e) {
			
		}
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.write(JSON.toJSONString(new ResultBean(5009, false, "登录已过期", null)));
		writer.flush();
		return false;
	}

}
