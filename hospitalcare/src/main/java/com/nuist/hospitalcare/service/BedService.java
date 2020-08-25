package com.nuist.hospitalcare.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nuist.hospitalcare.entity.Bed;

/**
 * 床铺管理业务层逻辑接口BedService
 * @author ljt
 *
 */
public interface BedService {
	/**
	 * 添加床铺
	 */
	boolean insert(Bed Bed);
	
	/**
	 * 更新床铺
	 */
	boolean update(Bed Bed);
	
	/**
	 * 删除床铺
	 */
	boolean delete(Integer bid);
	
	/**
	 * 根据id查询床铺
	 */
	Bed findByBedId(Integer bid);
	

	/**
	 * 分页查询所有床铺信息
	 */
	public Page<Bed> findAll(Pageable pageable);

}
