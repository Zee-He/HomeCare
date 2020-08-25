package com.nuist.hospitalcare.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nuist.hospitalcare.entity.Customer;

/**
 * 客户信息管理服务接口
 */
public interface CustomerService {
	/**
	 * 增加客户信息
	 * @param customer 客户信息
	 * @return
	 */
	public boolean insert(Customer customer);
	
	/**
	 * 更新客户信息
	 * @param customer 客户信息
	 * @return
	 */
	public boolean update(Customer customer);
	
	/**
	 * 通过客户编号删除客户信息
	 * @param id 客户编号
	 * @return
	 */
	public boolean deleteById(Integer id);
	
	/**
	 * 根据条件分页查询客户信息
	 * @param name 客户姓名
	 * @param pageable 分页规则
	 * @return
	 */
	public Page<Customer> findByNameInPage(String name, Pageable pageable);
	
	/**
	 * 分页查询所有客户信息
	 * @param pageable 分页规则
	 * @return
	 */
	public Page<Customer> selectAllInPage(Pageable pageable);
}
