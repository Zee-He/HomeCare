package com.nuist.hospitalcare.controller;

import java.util.List;

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
import com.nuist.hospitalcare.entity.BedRelationship;
import com.nuist.hospitalcare.entity.BedRelationshipKey;
import com.nuist.hospitalcare.service.BedRelationshipService;

/**
 * 床铺关系信息控制器BedController
 * @author ljt
 *
 */
@RestController
@RequestMapping(value = "bedr")// 所有具有前缀bed均路由到此控制器
public class BedRelationshipController {
	private static final int PAGE_SIZE=10;//分页查询每页大小
	@Autowired
	private BedRelationshipService bedRelationshipService;
	
	/**
	 * 添加床铺关系信息
	 */
	@PutMapping(value = "insert")
	public ResultBean insert(@Validated BedRelationship bedRelationship, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			StringBuffer msgBuffer= new StringBuffer();
			for (FieldError iterable_element : bindingResult.getFieldErrors()) {
				msgBuffer.append(iterable_element.getField()+":"+iterable_element.getDefaultMessage()+"\n");
			}	
			return new ResultBean(5006, false,msgBuffer.toString(), null);
		}
		boolean flag=bedRelationshipService.insert(bedRelationship);
		if(flag) {
			return new ResultBean(200,true,"添加床铺关系信息成功","");
		}else {	
			return new ResultBean(5000,false,"添加床铺关系信息失败","");
		}
	}
	
	/**
	 * 根据综合编号查询床铺关系信息
	 */
	@GetMapping("findbyid/{bedRelationshipKey}")
	public ResultBean findById(@PathVariable("bedRelationshipKey")BedRelationshipKey bedRelationshipKey) {
		BedRelationship bedRelationship = bedRelationshipService.findById(bedRelationshipKey);
		return new ResultBean(200, true, "查询床铺关系成功", bedRelationship);
	}
	
	/**
	 * 根据床铺编号查询床铺关系信息
	 */
	@GetMapping("findbybid/{bid}")
	public ResultBean findByBId(@PathVariable("bid")Integer bid) {
		List<BedRelationship> bedRelationship = bedRelationshipService.findByBId(bid);
		return new ResultBean(200, true, "根据客户编号查询床铺关系成功", bedRelationship);
	}
	
	
	/**
	 * 根据客户编号查询床铺关系信息
	 */
	@GetMapping("findbycid/{cid}")
	public ResultBean findByCId(@PathVariable("cid")Integer cid) {
		List<BedRelationship> bedRelationship = bedRelationshipService.findByCId(cid);
		return new ResultBean(200, true, "根据床铺编号查询床铺关系成功", bedRelationship);
	}
	
	/**
	 * 分页查询床铺关系信息
	 */
	@GetMapping("findall/{page}")
	public ResultBean findAll(@PathVariable("page")Integer page) {
		Page<BedRelationship> servicePage = bedRelationshipService.findAll(PageRequest.of(page, PAGE_SIZE));
		return new ResultBean(200, true, "分页查询床铺关系成功", servicePage);
	}
	
	/**
	 * 删除床铺关系信息
	 */
	@DeleteMapping("delete/{bedRelationshipKey}")
	public ResultBean delete(@PathVariable("bedRelationshipKey")BedRelationshipKey bedRelationshipKey) {
		boolean flag = bedRelationshipService.delete(bedRelationshipKey);
		if (flag) {
			return new ResultBean(200, true, "删除床铺关系成功", "");
		} else {
			return new ResultBean(5000, false, "删除床铺关系失败", "");
		}
	}
}
