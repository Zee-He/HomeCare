package com.nuist.hospitalcare.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nuist.hospitalcare.entity.PurchasedService;
import com.nuist.hospitalcare.entity.PurchasedServiceKey;

/**
 * 客户已购服务记录业务逻辑层接口PurchasedServiceService
 * @author 97784
 *
 */
public interface PurchasedServiceService {
	/**
	 * 添加已购服务记录
	 * @param purchasedService 已购服务记录
	 * @return
	 */
	boolean insert(PurchasedService purchasedService);
		
	/**
	 * 根据客户编号删除该客户的全部购买记录
	 * @param cid 客户编号
	 * @return
	 */
	boolean deleteAllByCid(Integer cid);
	
	/**
	 * 根据服务编号删除该服务的全部购买记录
	 * @param serviceId 服务编号
	 * @return
	 */
	boolean deleteAllByServiceId(Integer serviceId);
	
	/**
	 *根据主键 删除已购服务记录
	 * @param purchasedServiceKey 已购服务记录主键
	 * @return
	 */
	boolean delete(PurchasedServiceKey purchasedServiceKey);
	
	/**
	 * 根据客户编号，服务编号 组合分页查询已购服务记录
	 * @param cid 客户编号
	 * @param serviceId 服务编号
	 * @param pageable 分页规则
	 * @return
	 */
	public Page<PurchasedService> findByCidServiceId(Integer cid,Integer serviceId, Pageable pageable);

	/**
	 * 分页查询所有已购服务记录
	 * @param pageable 分页规则
	 * @return
	 */
	public Page<PurchasedService> findAll(Pageable pageable);
}
