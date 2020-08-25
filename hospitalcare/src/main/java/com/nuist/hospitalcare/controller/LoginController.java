package com.nuist.hospitalcare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.nuist.hospitalcare.bean.ResultBean;
import com.nuist.hospitalcare.config.Audience;
import com.nuist.hospitalcare.entity.SystemUser;
import com.nuist.hospitalcare.service.SystemUserService;
import com.nuist.hospitalcare.util.JWTTokenUtil;

/**
 * 登入登出控制器
 */
@RestController
@RequestMapping("user") // 任何前缀为user的url均将路由至此控制器
public class LoginController {
	@Autowired
	private SystemUserService systemUserService;
	@Autowired
	private Audience audience;
	
	
	/**
	 * 登录
	 * @param eid
	 * @param password
	 * @return
	 */
	@PostMapping("login")
	public ResultBean login(@RequestParam("eid")Integer eid, @RequestParam("password")String password) {
		SystemUser user = systemUserService.login(eid, password);
		if (null != user) {
			user.setPassword(null);
			String token = JWTTokenUtil.createJWT(user.getEid().toString(), user.getUserName(), audience);
			return new ResultBean(200, true, "登录成功", new JSONObject().fluentPut("token", token).fluentPut("user", user));
		} else {
			return new ResultBean(200, false, "登陆失败", null);
		}
	}
	
	
	/**
	 * 登出
	 * @return
	 */
	@GetMapping("logout")
	public ResultBean logout() {
		return new ResultBean(200, true, "注销成功", "");
	}
}
