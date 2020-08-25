package com.nuist.hospitalcare.dao;

import org.apache.ibatis.annotations.Param;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.nuist.hospitalcare.entity.PurchasedService;
import com.nuist.hospitalcare.entity.PurchasedServiceKey;

/**
 * 客户已购服务记录数据访问层接口PurchasedServiceRepository
 * 
 * @author 97784
 *
 */

public interface PurchasedServiceRepository extends JpaRepository<PurchasedService, PurchasedServiceKey> {
	/**
	 * 删除该客户所有购买记录
	 * 
	 * @param cid
	 */
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(nativeQuery = true, value = "delete from purchased_service where cid=?1")
	void deleteAllByCid(Integer cid);

	/**
	 * 删除该服务所有购买记录
	 * 
	 * @param serviceId
	 */
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(nativeQuery = true, value = "delete from purchased_service where service_id=?1")
	void deleteAllByServiceId(Integer serviceId);

	/**
	 * 根据客户、服务组合分页查询
	 * 
	 * @param cid
	 * @param serviceId
	 * @param pageable
	 * @return
	 */
	@Query(nativeQuery = true, value = "select * from purchased_service where if(IFNULL(?1,'') !='',cid=?1,1=1) and if(IFNULL(?2,'') !='',service_id=?2,1=1)")
	Page<PurchasedService> findByCidServiceId(@Param("cid") Integer cid, @Param("serviceId") Integer serviceId,
			Pageable pageable);
}
