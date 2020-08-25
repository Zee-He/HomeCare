package com.nuist.hospitalcare.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nuist.hospitalcare.entity.Dependent;


/**
 * 家属信息业务逻辑层接口
 * @author 97784
 *
 */
public interface DependentService {

	/**
	 * 添加家属信息
	 * @param dependent 家属信息
	 * @return
	 */
	boolean insert(Dependent dependent);
		
	/**
	 *修改家属信息
	 * @param dependent 家属信息
	 * @return
	 */
	boolean update(Dependent oldDependent,Dependent newDependent);
	
	/**
	 * 根据客户编号删除该客户的所有家属信息
	 * @param cid 客户编号
	 * @return
	 */
	boolean deleteAllByCid(Integer cid);
	
	/**
	 * 根据主键删除家属信息
	 * @param dependent 家属信息主键
	 * @return
	 */
	boolean delete(Dependent dependent);
	
	/**
	 * 根据客户编号分页查询该客户的家属信息
	 * @param cid 客户编号
	 * @param pageable 分页规则
	 * @return
	 */
	public Page<Dependent> findByCid(Integer cid, Pageable pageable);

	/**
	 * 分页查询所有健康档案
	 * @param pageable 分页规则
	 * @return
	 */
	public Page<Dependent> findAll(Pageable pageable);
}
