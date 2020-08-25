package com.nuist.hospitalcare.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
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
	Page<Service> findByServiceNameContaining(String serviceName, Pageable pageable);
}
