package com.nuist.hospitalcare.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.nuist.hospitalcare.entity.ServiceRelationship;
import com.nuist.hospitalcare.entity.ServiceRelationshipKey;
/**
 * 服务对象关系数据访问层接口ServiceRelationshipRepository
 * @author 97784
 *
 */
public interface ServiceRelationshipRepository extends JpaRepository<ServiceRelationship, ServiceRelationshipKey> {

	/**
	 * 删除该客户所有服务关系
	 * 
	 * @param cid
	 */
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(nativeQuery = true, value = "delete from service_relationship where cid=?1")
	void deleteAllByCid(Integer cid);

	/**
	 * 删除该员工所有服务关系
	 * 
	 * @param eid
	 */
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(nativeQuery = true, value = "delete from service_relationship where eid=?1")
	void deleteAllByEid(Integer eid);

	/**
	 * 根据客户id、员工id组合分页查询
	 * 
	 * @param cid
	 * @param eid
	 * @param pageable
	 * @return
	 */
	Page<ServiceRelationship> findByCidOrEid(Integer cid,  Integer eid, Pageable pageable);
}
