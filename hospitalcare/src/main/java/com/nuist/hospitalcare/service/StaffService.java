package com.nuist.hospitalcare.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nuist.hospitalcare.entity.Staff;

/**
 * 工作人员信息管理业务层逻辑接口BedService
 * @author ljt
 *
 */
public interface StaffService {
	
	/**
	 * 添加工作人员信息
	 */
	boolean insert(Staff staff);
	
	/**
	 * 更新工作人员信息
	 */
	boolean update(Staff staff);
	
	/**
	 * 删除工作人员信息
	 */
	boolean delete(Integer id);
	
	/**
	 * 根据id查询工作人员信息
	 */
	Staff findById(Integer id);
	
	/**
	 * 根据name模糊查询工作人员
	 */
	Page<Staff> findByNameLike(String name, Pageable pageable);
	
	/**
	 * 分页查询所有工作人员信息
	 */
	public Page<Staff> findAll(Pageable pageable);

}
