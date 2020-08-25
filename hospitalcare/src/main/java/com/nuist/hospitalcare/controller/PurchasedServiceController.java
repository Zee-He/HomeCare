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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nuist.hospitalcare.bean.ResultBean;
import com.nuist.hospitalcare.entity.PurchasedService;
import com.nuist.hospitalcare.entity.PurchasedServiceKey;
import com.nuist.hospitalcare.service.PurchasedServiceService;

/**
 * 客户购买服务记录控制器
 * @author 97784
 *
 */
@RestController
@RequestMapping(value = "purchasedservice")// 所有具有前缀purchasedservice均路由到此控制器
public class PurchasedServiceController {

	//private static final int PAGE_SIZE=10;//分页查询每页大小
	@Autowired
	private PurchasedServiceService purchasedServiceService;
	
	/**
	 * 购买服务、添加购买记录
	 * @param purchasedService 购买记录
	 * @param bindingResult 
	 * @return
	 */
	@PostMapping(value = "insert")
	public ResultBean insert(@Validated PurchasedService purchasedService,BindingResult bindingResult) {
//		System.out.println(purchasedService);
		if (bindingResult.hasErrors()) {
			StringBuffer msgBuffer= new StringBuffer();
			for (FieldError iterable_element : bindingResult.getFieldErrors()) {
				msgBuffer.append(iterable_element.getField()+":"+iterable_element.getDefaultMessage()+"\n");
			}	
			return new ResultBean(5006, false,msgBuffer.toString(), null);
		}
		boolean flag=purchasedServiceService.insert(purchasedService);
		if(flag) {
			return new ResultBean(200,true,"购买成功","");
		}else {
			return new ResultBean(5001,false,"购买失败","");
		}
	}
	
	/**
	 * 根据客户编号删除该客户的全部购买记录
	 * @param cid
	 * @return
	 */
	@DeleteMapping(value = "deleteallbycid/{cid}")
	public ResultBean deleteAllByCid(@PathVariable("cid")Integer cid) {
		boolean flag=purchasedServiceService.deleteAllByCid(cid);
		if(flag) {
			return new ResultBean(200,true,"删除成功","");
		}else {
			return new ResultBean(5001,false,"删除失败","");
		}
	}
	
	/**
	 * 根据服务编号删除该服务的全部购买记录
	 * @param serviceId
	 * @return
	 */
	@DeleteMapping(value = "deleteallbyserviceid/{serviceId}")
	public ResultBean deleteByServiceId(@PathVariable("serviceId")Integer serviceId) {
		boolean flag=purchasedServiceService.deleteAllByServiceId(serviceId);
		if(flag) {
			return new ResultBean(200,true,"删除成功","");
		}else {
			return new ResultBean(5001,false,"删除失败","");
		}
	}
	
	/**
	 * 根据主键删除指定购买记录
	 * @return
	 */
	@DeleteMapping(value = "delete")
	public ResultBean delete(PurchasedServiceKey purchasedServiceKey) {
		System.out.println(purchasedServiceKey);
		boolean flag=purchasedServiceService.delete(purchasedServiceKey);
		if(flag) {
			return new ResultBean(200,true,"删除成功","");
		}else {
			return new ResultBean(5001,false,"删除失败","");
		}
	}
	
	/**
	 * 根据客户编号，服务编号组合 分页查询服务购买记录
	 * @param cid
	 * @param serviceId
	 * @param page
	 * @return
	 */
	@PostMapping(value = "findbycidserviceid")
	public ResultBean findByCidServiceId(Integer cid,Integer serviceId,Integer page,Integer limit) {
		page=page-1;
		Page<PurchasedService> purchasedServicePage=purchasedServiceService.findByCidServiceId(cid, serviceId, PageRequest.of(page, limit));
		return new ResultBean(200,true,"查询成功",purchasedServicePage);
	}
	
	/**
	 * 分页查询服务购买记录
	 * @param page 页号
	 * @return
	 */
	@GetMapping(value = "findall")
	public ResultBean findAll(Integer page,Integer limit) {
		page=page-1;
		Page<PurchasedService> purchasedServicePage=purchasedServiceService.findAll(PageRequest.of(page, limit));
		return new ResultBean(200,true,"分页查询成功",purchasedServicePage);
	}
}
