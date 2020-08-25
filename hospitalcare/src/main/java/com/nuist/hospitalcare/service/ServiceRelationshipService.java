package com.nuist.hospitalcare.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nuist.hospitalcare.entity.ServiceRelationship;
import com.nuist.hospitalcare.entity.ServiceRelationshipKey;


/**
 * 服务对象关系业务逻辑层接口ServiceRelationshipService
 * @author 97784
 *
 */
public interface ServiceRelationshipService {
	/**
	 * 设置服务对象
	 * @param serviceRelationship 服务关系
	 * @return
	 */
	boolean insert(ServiceRelationship serviceRelationship);
		
	/**
	 * 根据客户编号删除该客户的所有服务关系
	 * @param cid 客户编号
	 * @return
	 */
	boolean deleteByCid(Integer cid);
	
	/**
	 * 根据员工编号删除该员工的所有服务关系
	 * @param eid 服务编号
	 * @return
	 */
	boolean deleteByEid(Integer eid);
	
	/**
	 * 根据主键删除服务关系
	 * @param serviceRelationshipKey 服务关系主键
	 * @return
	 */
	boolean delete(ServiceRelationshipKey serviceRelationshipKey);
	
	/**
	 * 修改服务关系
	 * @param ServiceRelationship 服务关系
	 * @return
	 */
	boolean update(ServiceRelationship ServiceRelationship);
	
	/**
	 * 根据客户编号，服务编号 组合分页查询已购服务记录
	 * @param cid 客户编号
	 * @param eid 服务编号
	 * @param pageable 分页规则
	 * @return
	 */
	public Page<ServiceRelationship> findByCidEid(Integer cid,Integer eid, Pageable pageable);

	/**
	 * 分页查询所有服务关系
	 * @param pageable 分页规则
	 * @return
	 */
	public Page<ServiceRelationship> findAll(Pageable pageable);
}
