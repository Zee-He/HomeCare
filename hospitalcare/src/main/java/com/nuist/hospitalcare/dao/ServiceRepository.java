package com.nuist.hospitalcare.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.nuist.hospitalcare.entity.Service;

/**
 * 服务管理数据访问层ServiceRepository
 * @author 97784
 *
 */
public interface ServiceRepository extends JpaRepository<Service, Integer> {
	/**
	 * 根据条件分页查询服务信息
	 * @param name 服务名称
	 * @param pageable 分页规则
	 * @return
	 */
	@Query(nativeQuery = true,value = "select * from service where if(?1 !='',service_name like concat('%',?1,'%'),1=1)")
	Page<Service> findByNameLike(@Param("serviceName")String serviceName, Pageable pageable);
}
