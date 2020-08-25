package com.nuist.hospitalcare.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nuist.hospitalcare.entity.CustomerHealth;


/**
 * 健康档案管理业务逻辑层接口CustomerHealthService
 * @author 97784
 *
 */
public interface CustomerHealthService {

	/**
	 * 添加健康档案
	 * @param customerHealth 健康档案关系
	 * @return
	 */
	boolean insert(CustomerHealth customerHealth);
		
	/**
	 * 根据客户编号删除该客户的所有健康档案
	 * @param cid 客户编号
	 * @return
	 */
	boolean deleteAllByCid(Integer cid);
	
	/**
	 * 根据主键删除健康档案
	 * @param customerHealth 健康档案主键
	 * @return
	 */
	boolean delete(CustomerHealth customerHealth);
	
	/**
	 * 根据客户编号分页查询该客户的健康档案
	 * @param cid 客户编号
	 * @param pageable 分页规则
	 * @return
	 */
	public Page<CustomerHealth> findByCid(Integer cid, Pageable pageable);

	/**
	 * 分页查询所有健康档案
	 * @param pageable 分页规则
	 * @return
	 */
	public Page<CustomerHealth> findAll(Pageable pageable);
	
}
