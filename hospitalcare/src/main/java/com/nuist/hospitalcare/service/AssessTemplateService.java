package com.nuist.hospitalcare.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nuist.hospitalcare.entity.AssessTemplate;

/**
 * 评估模板信息管理业务层逻辑接口AssessTemplateService
 * @author ljt
 *
 */
public interface AssessTemplateService {
	
	/**
	 * 添加评估模板信息
	 */
	boolean insert(AssessTemplate assessTemplate);
	
	/**
	 * 更新评估模板信息
	 */
	boolean update(AssessTemplate assessTemplate);
	
	/**
	 * 删除评估模板信息
	 */
	boolean delete(Integer cid);
	
	/**
	 * 根据编号id查询评估模板信息
	 */
	AssessTemplate findById(Integer id, Pageable pageable);
	
	/**
	 * 根据模板内容模糊查询模板信息
	 */
	Page<AssessTemplate> findByContentLike(String content, Pageable pageable);
	
	/**
	 * 分页查询所有评估记录信息
	 */
	public Page<AssessTemplate> findAll(Pageable pageable);
	

}
