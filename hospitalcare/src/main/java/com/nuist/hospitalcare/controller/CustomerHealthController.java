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
import com.nuist.hospitalcare.entity.CustomerHealth;
import com.nuist.hospitalcare.service.CustomerHealthService;

/**
 * 健康档案控制器
 * @author 97784
 *
 */
@RestController
@RequestMapping(value = "customerhealth") // 所有具有前缀customerhealth均路由到此控制器
public class CustomerHealthController {
	//private static final int PAGE_SIZE=10;//分页查询每页大小
	@Autowired
	private CustomerHealthService customerHealthService;
	
	/**
	 * 添加健康档案
	 * @param customerHealth 健康档案
	 * @param bindingResult 
	 * @return
	 */
	@PostMapping(value = "insert")
	public ResultBean insert(@Validated CustomerHealth customerHealth,BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			StringBuffer msgBuffer= new StringBuffer();
			for (FieldError iterable_element : bindingResult.getFieldErrors()) {
				msgBuffer.append(iterable_element.getField()+":"+iterable_element.getDefaultMessage()+"\n");
			}	
			return new ResultBean(5006, false,msgBuffer.toString(), null);
		}
		boolean flag=customerHealthService.insert(customerHealth);
		if(flag) {
			return new ResultBean(200,true,"添加成功","");
		}else {
			return new ResultBean(5003,false,"添加失败","");
		}
	}
	
	/**
	 * 根据客户编号删除该客户的全部健康档案
	 * @param cid
	 * @return
	 */
	@DeleteMapping(value = "deleteallbycid/{cid}")
	public ResultBean deleteAllByCid(@PathVariable("cid")Integer cid) {
		boolean flag=customerHealthService.deleteAllByCid(cid);
		if(flag) {
			return new ResultBean(200,true,"删除成功","");
		}else {
			return new ResultBean(5003,false,"删除失败","");
		}
	}
	
	
	/**
	 * 根据主键删除指定健康档案
	 * @return
	 */
	@DeleteMapping(value = "delete")
	public ResultBean delete(CustomerHealth CustomerHealth) {
		boolean flag=customerHealthService.delete(CustomerHealth);
		if(flag) {
			return new ResultBean(200,true,"删除成功","");
		}else {
			return new ResultBean(5003,false,"删除失败","");
		}
	}
	
	/**
	 * 根据客户编号cid，分页查询该客户的全部健康 
	 * @param page 页号
	 * @return
	 */
	@PostMapping(value = "findbycid")
	public ResultBean findByCid(Integer cid,Integer page,Integer limit) {
		page=page-1;
		Page<CustomerHealth> customerHealthPage=customerHealthService.findByCid(cid, PageRequest.of(page, limit));
		return new ResultBean(200,true,"查询成功",customerHealthPage);
	}
	
	/**
	 * 分页查询所有健康档案
	 * @param page 页号
	 * @return
	 */
	@GetMapping(value = "findall")
	public ResultBean findAll(Integer page,Integer limit) {
		page=page-1;
		Page<CustomerHealth> customerHealthPage=customerHealthService.findAll(PageRequest.of(page, limit));
		return new ResultBean(200,true,"分页查询成功",customerHealthPage);
	}
}
