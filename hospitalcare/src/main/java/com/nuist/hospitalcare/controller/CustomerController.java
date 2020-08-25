package com.nuist.hospitalcare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nuist.hospitalcare.bean.ResultBean;
import com.nuist.hospitalcare.entity.Customer;
import com.nuist.hospitalcare.service.CustomerService;

/**
 * 客户信息控制器
 * 
 * @author BuluGuy
 */
@RestController
@RequestMapping("customer") // 所有具有前缀customer均路由到此控制器
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	/**
	 * 新增客户信息
	 * 
	 * @param customer
	 * @param bindingResult
	 * @return
	 */
	@PutMapping("insert")
	public ResultBean insert(@Validated Customer customer, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			StringBuffer msgBuffer = new StringBuffer();
			for (FieldError iterable_element : bindingResult.getFieldErrors()) {
				msgBuffer.append(iterable_element.getField() + ":" + iterable_element.getDefaultMessage() + "\n");
			}
			return new ResultBean(5006, false, msgBuffer.toString(), null);
		}
		boolean flag = customerService.insert(customer);
		if (flag) {
			return new ResultBean(200, true, "新增客户信息成功", "");
		} else {
			return new ResultBean(200, false, "新增客户信息失败", "");
		}

	}

	/**
	 * 更新用户信息
	 * 
	 * @param customer
	 * @param bindingResult
	 * @return
	 */
	@PutMapping("update/{id}")
	public ResultBean update(@Validated Customer customer, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			StringBuffer msgBuffer = new StringBuffer();
			for (FieldError iterable_element : bindingResult.getFieldErrors()) {
				msgBuffer.append(iterable_element.getField() + ":" + iterable_element.getDefaultMessage() + "\n");
			}
			return new ResultBean(5006, false, msgBuffer.toString(), null);
		}
		boolean flag = customerService.update(customer);
		if (flag) {
			return new ResultBean(200, true, "修改客户信息成功", "");
		} else {
			return new ResultBean(200, false, "修改客户信息失败", "");
		}
	}

	/**
	 * 分页查询用户信息
	 * 
	 * @param page 页数
	 * @return
	 */
	@PostMapping("findall")
	public ResultBean findAll(Integer page, Integer limit) {
		// 前端传过来的起始数字为1
		page = page - 1;
		Page<Customer> customerPage = customerService.selectAllInPage(PageRequest.of(page, limit, Sort.by("cid")));
		return new ResultBean(200, true, "", customerPage);
	}

	/**
	 * 根据条件分页查询用户信息
	 * 
	 * @param name 姓名
	 * @param page 页数
	 * @return
	 */
	@PostMapping("findbyname")
	public ResultBean findByName(String name, Integer page, Integer limit) {
		page = page - 1;
		Page<Customer> customerPage = customerService.findByNameInPage(name, PageRequest.of(page, limit, Sort.by("cid")));
		return new ResultBean(200, true, "", customerPage);
	}

	/**
	 * 删除用户信息
	 * 
	 * @param cid 用户编号
	 * @return
	 */
	@DeleteMapping("delete/{id}")
	public ResultBean delete(@PathVariable("id") Integer cid) {
		boolean flag = customerService.deleteById(cid);
		if (flag) {
			return new ResultBean(200, true, "删除成功", "");
		} else {
			return new ResultBean(200, false, "删除失败", "");
		}
	}

}
