package com.nuist.hospitalcare.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nuist.hospitalcare.entity.BedRelationship;
import com.nuist.hospitalcare.entity.BedRelationshipKey;

/**
 * 床铺关系列表管理业务层逻辑接口BedService
 * @author ljt
 *
 */
public interface BedRelationshipService {
	/**
	 * 添加床铺关系
	 */
	boolean insert(BedRelationship bedRelationship);
	
	
	/**
	 * 删除床铺关系
	 */
	boolean delete(BedRelationshipKey bedRelationshipKey);
	
	/**
	 * 根据cid查询床铺关系
	 */
	List<BedRelationship> findByCId(Integer cid);
	
	/**
	 * 根据bid查询床铺关系
	 */
	List<BedRelationship> findByBId(Integer bid);
	
	/**
	 * 根据bid查询床铺关系
	 */
	BedRelationship findById(BedRelationshipKey bedRelationshipKey);
	
	/**
	 * 分页查询所有床铺关系信息
	 */
	public Page<BedRelationship> findAll(Pageable pageable);

}
