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

import com.nuist.hospitalcare.bean.ResultBean;
import com.nuist.hospitalcare.entity.Service;
import com.nuist.hospitalcare.service.ServiceService;
/**
 * 服务信息控制器 ServiceController
 * @author 97784
 *
 */
@RestController
@RequestMapping(value = "service")// 所有具有前缀service均路由到此控制器
public class ServiceController {
//	private static final int PAGE_SIZE=10;//分页查询每页大小
	@Autowired
	private ServiceService serviceService;

	/**
	 * 添加服务信息
	 * @param service 
	 * @param bindingResult
	 * @return
	 */
	@PostMapping(value = "insert")
	public ResultBean insert(@Validated Service service,BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			StringBuffer msgBuffer= new StringBuffer();
			for (FieldError iterable_element : bindingResult.getFieldErrors()) {
				msgBuffer.append(iterable_element.getField()+":"+iterable_element.getDefaultMessage()+"\n");
			}	
			return new ResultBean(5006, false,msgBuffer.toString(), null);
		}
		boolean flag=serviceService.insert(service);
		if(flag) {
			return new ResultBean(200,true,"添加服务信息成功","");
		}else {	
			return new ResultBean(5000,false,"添加服务信息失败","");
		}
	}
	
	/**
	 * 根据服务编号查询服务信息
	 * @param serviceId 服务编号
	 * @return
	 */
	@GetMapping("findbyserviceid/{serviceId}")
	public ResultBean findByServiceId(@PathVariable("serviceId")Integer serviceId) {
		Service service = serviceService.findByServiceId(serviceId);
		return new ResultBean(200, true, "查询成功", service);
	}
	/**
	 * 更新服务信息
	 * @param serviceId
	 * @param service 
	 * @param bindingResult
	 * @return
	 */
	@PutMapping(value = "update/{serviceId}")
	public ResultBean update(@PathVariable("serviceId")Integer serviceId,@Validated Service service,BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			StringBuffer msgBuffer= new StringBuffer();
			for (FieldError iterable_element : bindingResult.getFieldErrors()) {
				msgBuffer.append(iterable_element.getField()+":"+iterable_element.getDefaultMessage()+"\n");
			}
			return new ResultBean(5006, false,msgBuffer.toString(), null);
		}
		boolean flag=serviceService.update(service);
		if(flag) {
			return new ResultBean(200,true,"更新服务信息成功","");
		}else {
			return new ResultBean(5000,false,"更新服务信息失败","");
		}
	}
	
	/**
	 * 分页查询服务信息
	 * @param page 页号
	 * @return
	 */
	@GetMapping("findall")
	public ResultBean findAll(Integer page,Integer limit) {
		page=page-1;
		Page<Service> servicePage = serviceService.findAll(PageRequest.of(page, limit));
		return new ResultBean(200, true, "分页查询成功", servicePage);
	}
	
	/**
	 * 根据服务名称分页模糊查询服务信息
	 * @param serviceName 服务名称
	 * @param page 页号
	 * @return
	 */
	@PostMapping("findbyname")
	public ResultBean findByName(String serviceName, Integer page,Integer limit) {
		System.out.println(serviceName);
		System.out.println(page);
		System.out.println(limit);
		page=page-1;
		Page<Service> servicePage = serviceService.findByName(serviceName, PageRequest.of(page, limit));
		return new ResultBean(200, true, "查询成功", servicePage);
	}
	
	/**
	 * 删除服务信息
	 * @param serviceId 服务编号
	 * @return
	 */
	@DeleteMapping("delete/{serviceId}")
	public ResultBean delete(@PathVariable("serviceId")Integer serviceId) {
		boolean flag = serviceService.delete(serviceId);
		if (flag) {
			return new ResultBean(200, true, "删除成功", "");
		} else {
			return new ResultBean(5000, false, "删除失败", "");
		}
	}
}
