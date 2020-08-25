package com.nuist.hospitalcare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nuist.hospitalcare.bean.ResultBean;
import com.nuist.hospitalcare.entity.Staff;
import com.nuist.hospitalcare.service.StaffService;

/**
 * 工作人员信息控制器StaffController
 * @author ljt
 *
 */
@RestController
@RequestMapping(value = "staff")// 所有具有前缀bed均路由到此控制器
public class StaffController {
	private static final int PAGE_SIZE=10;//分页查询每页大小
	@Autowired
	private StaffService staffService;
	
	/**
	 * 添加工作人员信息
	 */
	@PutMapping(value = "insert")
	public ResultBean insert(@Validated Staff staff, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			StringBuffer msgBuffer= new StringBuffer();
			for (FieldError iterable_element : bindingResult.getFieldErrors()) {
				msgBuffer.append(iterable_element.getField()+":"+iterable_element.getDefaultMessage()+"\n");
			}	
			return new ResultBean(5006, false,msgBuffer.toString(), null);
		}
		boolean flag=staffService.insert(staff);
		if(flag) {
			return new ResultBean(200,true,"添加在工作人员信息成功","");
		}else {	
			return new ResultBean(5000,false,"添加工作人员信息失败","");
		}
	}
	
	/**
	 * 更新工作人员信息
	 */
	@PutMapping(value = "update/{id}")
	public ResultBean update(@PathVariable("id")Integer id,@Validated Staff staff,BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			StringBuffer msgBuffer= new StringBuffer();
			for (FieldError iterable_element : bindingResult.getFieldErrors()) {
				msgBuffer.append(iterable_element.getField()+":"+iterable_element.getDefaultMessage()+"\n");
			}
			return new ResultBean(5006, false,msgBuffer.toString(), null);
		}
		boolean flag=staffService.update(staff);
		if(flag) {
			return new ResultBean(200,true,"更新工作人员信息成功","");
		}else {
			return new ResultBean(5000,false,"更新工作人员信息失败","");
		}
	}
	
	/**
	 * 根据编号查询信息
	 */
	@GetMapping("findbyid/{id}")
	public ResultBean findById(@PathVariable("id")Integer id) {
		Staff staff = staffService.findById(id);
		return new ResultBean(200, true, "查询床铺成功", staff);
	}
	
	/**
	 * 分页查询全部工作人员信息
	 */
	@GetMapping("findall/{page}")
	public ResultBean findAll(@PathVariable("page")Integer page) {
		Page<Staff> staffPage = staffService.findAll(PageRequest.of(page, PAGE_SIZE));
		return new ResultBean(200, true, "分页查询工作人员成功", staffPage);
	}
	
	/**
	 * 根据工作人员姓名模糊查询
	 */
	@GetMapping("findbyname/{name}")
	public ResultBean findByNameLike(@PathVariable("name")String name) {
		Page<Staff> staffPage = staffService.findByNameLike(name, PageRequest.of(0, PAGE_SIZE));
		return new ResultBean(200, true, "根据姓名模糊查询工作人员成功", staffPage);
	}
	
	/**
	 * 删除工作人员信息
	 */
	@DeleteMapping("delete/{id}")
	public ResultBean delete(@PathVariable("id")Integer id) {
		boolean flag = staffService.delete(id);
		if (flag) {
			return new ResultBean(200, true, "删除工作人员成功", "");
		} else {
			return new ResultBean(5000, false, "删除工作人员失败", "");
		}
	}
}
