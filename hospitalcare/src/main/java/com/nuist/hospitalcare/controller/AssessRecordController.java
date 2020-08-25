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
import com.nuist.hospitalcare.entity.AssessRecord;
import com.nuist.hospitalcare.service.AssessRecordService;

/**
 * 评估记录信息控制器AssessRecordController
 * @author ljt
 *
 */
@RestController
@RequestMapping(value = "assessr")// 所有具有前缀bed均路由到此控制器
public class AssessRecordController {
	private static final int PAGE_SIZE=10;//分页查询每页大小
	@Autowired
	private AssessRecordService assessRecordService;
	
	/**
	 * 添加评估记录信息
	 */
	@PutMapping(value = "insert")
	public ResultBean insert(@Validated AssessRecord assessRecord, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			StringBuffer msgBuffer= new StringBuffer();
			for (FieldError iterable_element : bindingResult.getFieldErrors()) {
				msgBuffer.append(iterable_element.getField()+":"+iterable_element.getDefaultMessage()+"\n");
			}	
			return new ResultBean(5006, false,msgBuffer.toString(), null);
		}
		boolean flag=assessRecordService.insert(assessRecord);
		if(flag) {
			return new ResultBean(200,true,"添加评估记录信息成功","");
		}else {	
			return new ResultBean(5000,false,"添加评估记录信息失败","");
		}
	}
	
	/**
	 * 更新评估记录信息
	 */
	@PutMapping(value = "update/{id}")
	public ResultBean update(@PathVariable("id")Integer id,@Validated AssessRecord assessRecord,BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			StringBuffer msgBuffer= new StringBuffer();
			for (FieldError iterable_element : bindingResult.getFieldErrors()) {
				msgBuffer.append(iterable_element.getField()+":"+iterable_element.getDefaultMessage()+"\n");
			}
			return new ResultBean(5006, false,msgBuffer.toString(), null);
		}
		boolean flag=assessRecordService.update(assessRecord);
		if(flag) {
			return new ResultBean(200,true,"更新评估记录信息成功","");
		}else {
			return new ResultBean(5000,false,"更新评估记录信息失败","");
		}
	}
	
	/**
	 * 根据用户编号查询评估记录信息
	 */
	@GetMapping("findbyid/{id}")
	public ResultBean findById(@PathVariable("id")Integer id) {
		Page< AssessRecord> pages = assessRecordService.findByCId(id, PageRequest.of(0, PAGE_SIZE));
		return new ResultBean(200, true, "查询评估记录信息成功", pages);
	}
	
	/**
	 * 分页查询评估记录信息信息
	 */
	@GetMapping("findall/{page}")
	public ResultBean findAll(@PathVariable("page")Integer page) {
		Page<AssessRecord> servicePage = assessRecordService.findAll(PageRequest.of(page, PAGE_SIZE));
		return new ResultBean(200, true, "分页查询评估记录信息成功", servicePage);
	}
	
	/**
	 * 根据用户评估记录结果模糊查询评估记录信息
	 */
	@GetMapping("findbyresult/{result}")
	public ResultBean findByResult(@PathVariable("result")String result) {
		Page< AssessRecord> pages = assessRecordService.findByResultLike(result, PageRequest.of(0, PAGE_SIZE));
		return new ResultBean(200, true, "模糊查询评估记录信息成功", pages);
	}
	
	/**
	 * 根据用户编号删除该用户的评估记录信息信息
	 */
	@DeleteMapping("delete/{id}")
	public ResultBean delete(@PathVariable("id")Integer id) {
		boolean flag = assessRecordService.deleteByCid(id);
		if (flag) {
			return new ResultBean(200, true, "删除评估记录信息成功", "");
		} else {
			return new ResultBean(5000, false, "删除评估记录信息失败", "");
		}
	}
}
