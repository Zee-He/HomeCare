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
import com.nuist.hospitalcare.entity.Bed;
import com.nuist.hospitalcare.service.BedService;

/**
 * 床铺信息控制器BedController
 * @author ljt
 *
 */
@RestController
@RequestMapping(value = "bed")// 所有具有前缀bed均路由到此控制器
public class BedController {
	private static final int PAGE_SIZE=10;//分页查询每页大小
	@Autowired
	private BedService bedService;
	
	/**
	 * 添加床铺信息
	 */
	@PutMapping(value = "insert")
	public ResultBean insert(@Validated Bed bed, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			StringBuffer msgBuffer= new StringBuffer();
			for (FieldError iterable_element : bindingResult.getFieldErrors()) {
				msgBuffer.append(iterable_element.getField()+":"+iterable_element.getDefaultMessage()+"\n");
			}	
			return new ResultBean(5006, false,msgBuffer.toString(), null);
		}
		boolean flag=bedService.insert(bed);
		if(flag) {
			return new ResultBean(200,true,"添加床铺信息成功","");
		}else {	
			return new ResultBean(5000,false,"添加床铺信息失败","");
		}
	}
	
	/**
	 * 更新床铺信息
	 */
	@PutMapping(value = "update/{bedId}")
	public ResultBean update(@PathVariable("bedId")Integer serviceId,@Validated Bed bed,BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			StringBuffer msgBuffer= new StringBuffer();
			for (FieldError iterable_element : bindingResult.getFieldErrors()) {
				msgBuffer.append(iterable_element.getField()+":"+iterable_element.getDefaultMessage()+"\n");
			}
			return new ResultBean(5006, false,msgBuffer.toString(), null);
		}
		boolean flag=bedService.update(bed);
		if(flag) {
			return new ResultBean(200,true,"更新床铺信息成功","");
		}else {
			return new ResultBean(5000,false,"更新床铺信息失败","");
		}
	}
	
	/**
	 * 根据床铺编号查询信息
	 */
	@GetMapping("findbyid/{bedId}")
	public ResultBean findById(@PathVariable("bedId")Integer bedId) {
		Bed bed = bedService.findByBedId(bedId);
		return new ResultBean(200, true, "查询床铺成功", bed);
	}
	
	/**
	 * 分页查询床铺信息
	 */
	@GetMapping("findall/{page}")
	public ResultBean findAll(@PathVariable("page")Integer page) {
		Page<Bed> servicePage = bedService.findAll(PageRequest.of(page, PAGE_SIZE));
		return new ResultBean(200, true, "分页查询床铺成功", servicePage);
	}
	
	/**
	 * 删除床铺信息
	 */
	@DeleteMapping("delete/{bedId}")
	public ResultBean delete(@PathVariable("bedId")Integer bedId) {
		boolean flag = bedService.delete(bedId);
		if (flag) {
			return new ResultBean(200, true, "删除床铺成功", "");
		} else {
			return new ResultBean(5000, false, "删除床铺失败", "");
		}
	}
}
