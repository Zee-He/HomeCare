package com.nuist.hospitalcare.service;

import java.sql.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nuist.hospitalcare.entity.AssessRecord;

/**
 * 评估记录信息管理业务层逻辑接口AssessRecordService
 * @author ljt
 *
 */
public interface AssessRecordService {
	
	/**
	 * 添加评估记录信息
	 */
	boolean insert(AssessRecord assessRecord);
	
	/**
	 * 更新评估记录信息
	 */
	boolean update(AssessRecord assessRecord);
	
	/**
	 * 删除某用户的评估记录信息
	 */
	boolean deleteByCid(Integer cid);
	
	/**
	 * 删除某用户的某次评估记录信息， 根据用户编号cid和时间
	 */
	boolean delete(Integer cid, Date date);
	
	/**
	 * 根据用户编号cid查询评估记录信息
	 */
	Page<AssessRecord> findByCId(Integer cid, Pageable pageable);
	
	/**
	 * 根据评估结果模糊查询评估记录信息
	 */
	Page<AssessRecord> findByResultLike(String content, Pageable pageable);
	
	/**
	 * 分页查询所有评估记录信息
	 */
	public Page<AssessRecord> findAll(Pageable pageable);
	
	/**
	 * 根据起始日期，截至日期、月份等查询评估记录信息
	 */
	public Page<AssessRecord> findByDate(Date begin, Date end);

}
