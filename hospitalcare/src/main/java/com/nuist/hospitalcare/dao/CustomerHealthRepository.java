package com.nuist.hospitalcare.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import com.nuist.hospitalcare.entity.CustomerHealth;

/**
 * 健康档案管理数据访问层接口CustomerHealthRepository
 * @author 97784
 *
 */
public interface CustomerHealthRepository extends JpaRepository<CustomerHealth, CustomerHealth> {

	/**
	 *根据客户编号 删除该客户所有健康档案
	 * 
	 * @param cid
	 */
	@Modifying
	@Query(nativeQuery = true, value = "delete from customer_health where cid=?1")
	void deleteByCid(Integer cid);

	/**
	 * 根据客户编号 分页查询该客户的所有健康档案
	 * @param cid
	 * @return
	 */
	@Query(nativeQuery = true, value = "select * from customer_health where if(IFNULL(?1,'') !='',cid=?1,1=1)")
	Page<CustomerHealth> findByCid(@Param("cid")Integer cid,Pageable pageable);
}
