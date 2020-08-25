package com.nuist.hospitalcare.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nuist.hospitalcare.entity.Service;

/**
 * 服务管理业务逻辑层接口ServiceService
 * @author 97784
 *
 */
public interface ServiceService {
	/**
	 * 添加服务
	 * @param service 服务信息
	 * @return
	 */
	boolean insert(Service service);
	
	/**
	 * 更新服务
	 * @param service 服务信息
	 * @return
	 */
	boolean update(Service service);
	
	/**
	 * 删除服务
	 * @param serviceId 服务编号
	 * @return
	 */
	boolean delete(Integer serviceId);
	
	/**
	 * 根据id查询
	 * @param serviceId 服务编号
	 * @return
	 */
	Service findByServiceId(Integer serviceId);
	
	/**
	 * 根据条件分页查询服务信息
	 * @param name 服务名称
	 * @param pageable 分页规则
	 * @return
	 */
	public Page<Service> findByName(String serviceName, Pageable pageable);

	/**
	 * 分页查询所有服务信息
	 * @param pageable 分页规则
	 * @return
	 */
	public Page<Service> findAll(Pageable pageable);
	
}
