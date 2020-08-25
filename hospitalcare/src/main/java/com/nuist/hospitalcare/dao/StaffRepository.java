package com.nuist.hospitalcare.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.nuist.hospitalcare.entity.Staff;

public interface StaffRepository extends JpaRepository<Staff, Integer> {
	/**
	 * 根据条件分页查询工作人员信息
	 */
	@Query(nativeQuery = true,value = "select * from staff where if(?1 !='',name like concat('%',?1,'%'),1=1)")
	Page<Staff> findByNameLike(@Param("name")String name, Pageable pageable);

}
