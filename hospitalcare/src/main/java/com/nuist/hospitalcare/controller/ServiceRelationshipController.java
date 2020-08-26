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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.nuist.hospitalcare.bean.ResultBean;
import com.nuist.hospitalcare.entity.ServiceRelationship;
import com.nuist.hospitalcare.entity.ServiceRelationshipKey;
import com.nuist.hospitalcare.service.ServiceRelationshipService;

@RestController
@RequestMapping(value = "servicerelationship")// 所有具有前缀servicerelationship均路由到此控制器
public class ServiceRelationshipController {

	//private static final int PAGE_SIZE=10;//分页查询每页大小
	@Autowired
	private ServiceRelationshipService serviceRelationshipService;
	
	/**
	 * 添加服务关系
	 * @param serviceRelationship 服务关系
	 * @param bindingResult 
	 * @return
	 */
	@PostMapping(value = "insert")
	public ResultBean insert(@Validated ServiceRelationship serviceRelationship,BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			StringBuffer msgBuffer= new StringBuffer();
			for (FieldError iterable_element : bindingResult.getFieldErrors()) {
				msgBuffer.append(iterable_element.getField()+":"+iterable_element.getDefaultMessage()+"\n");
			}	
			return new ResultBean(5006, false,msgBuffer.toString(), null);
		}
		boolean flag=serviceRelationshipService.insert(serviceRelationship);
		if(flag) {
			return new ResultBean(200,true,"添加成功","");
		}else {
			return new ResultBean(5002,false,"添加失败","");
		}
	}
	
	/**
	 *修改服务关系
	 * @param serviceRelationship 服务关系
	 * @param bindingResult 
	 * @return
	 */
	@PutMapping(value = "update")
	public ResultBean update(String update) {
		JSONObject t = JSON.parseObject(update);
		System.out.println(t);
		ServiceRelationshipKey oldRelationship = JSON.parseObject(t.getString("old"), ServiceRelationshipKey.class);
		ServiceRelationship newRelationship = JSON.parseObject(t.getString("new"), ServiceRelationship.class);
		
		boolean flag=serviceRelationshipService.update(oldRelationship, newRelationship);
		if(flag) {
			return new ResultBean(200,true,"修改成功","");
		}else {
			return new ResultBean(200,false,"修改失败","");
		}
	}
	
	/**
	 * 根据客户编号删除该客户的全部服务关系
	 * @param cid
	 * @return
	 */
	@DeleteMapping(value = "deleteallbycid/{cid}")
	public ResultBean deleteAllByCid(@PathVariable("cid")Integer cid) {
		boolean flag=serviceRelationshipService.deleteAllByCid(cid);
		if(flag) {
			return new ResultBean(200,true,"删除成功","");
		}else {
			return new ResultBean(5002,false,"删除失败","");
		}
	}
	
	/**
	 * 根据员工编号删除该员工的全部服务关系
	 * @param eid
	 * @return
	 */
	@DeleteMapping(value = "deleteallbyeid/{eid}")
	public ResultBean deleteAllByEid(@PathVariable("eid")Integer eid) {
		boolean flag=serviceRelationshipService.deleteAllByEid(eid);
		if(flag) {
			return new ResultBean(200,true,"删除成功","");
		}else {
			return new ResultBean(5002,false,"删除失败","");
		}
	}
	
	/**
	 * 根据主键删除指定服务关系
	 * @return
	 */
	@DeleteMapping(value = "delete")
	public ResultBean delete(ServiceRelationshipKey serviceRelationshipKey) {
		boolean flag=serviceRelationshipService.delete(serviceRelationshipKey);
		if(flag) {
			return new ResultBean(200,true,"删除成功","");
		}else {
			return new ResultBean(5002,false,"删除失败","");
		}
	}
	
	/**
	 * 根据客户编号cid、员工编号eid 组合分页查询服务关系
	 * @param cid
	 * @param eid
	 * @param page
	 * @return
	 */
	@GetMapping(value = "findbycideid")
	public ResultBean findByCidServiceId(Integer cid,Integer eid,Integer page,Integer limit) {
		page=page-1;
		Page<ServiceRelationship> serviceRelationshipPage=serviceRelationshipService.findByCidEid(cid, eid, PageRequest.of(page, limit));
		return new ResultBean(200,true,"查询成功",serviceRelationshipPage);
	}
	
	/**
	 * 分页查询所有服务关系
	 * @param page 页号
	 * @return
	 */
	@GetMapping(value = "findall")
	public ResultBean findAll(Integer page,Integer limit) {
		page=page-1;
		Page<ServiceRelationship> serviceRelationshipPage=serviceRelationshipService.findAll(PageRequest.of(page, limit));
		return new ResultBean(200,true,"分页查询成功",serviceRelationshipPage);
	}
}
