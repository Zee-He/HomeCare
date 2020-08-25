package com.nuist.hospitalcare.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nuist.hospitalcare.bean.ResultBean;


/**
 * 全局异常控制器
 */
@ControllerAdvice(basePackages = {
	"com.nuist.springboot20810",
	"com.nuist.springboot20810.controller",
	"com.nuist.springboot20810.service.impl",
	"com.nuist.springboot20810.dao"
})
public class GlobalExceptionController {
	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	public ResultBean handler_message(RuntimeException ex) {
		return new ResultBean(5050, false, ex.getMessage(), ex);
	}
}
