package com.nuist.hospitalcare.dao;

import java.sql.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.nuist.hospitalcare.entity.AssessRecord;


public interface AssessRecordRepository extends JpaRepository<AssessRecord, Integer> {
	/**
	 * 根据评估结果进行模糊查询
	 */
	@Query(nativeQuery = true, value = "select * from assess_record where if(?1 !='', assess_result like concat('%', ?1 ,'%'), 1=1)")
	Page<AssessRecord> findByResultLike(String content, Pageable pageable);
	
	/**
	 * 根据用户编号删除所有评估记录
	 */
	@Query(nativeQuery = true, value = "select * from assess_record where if(?1 !='', cid=?1, 1=1)")
	boolean deleteByCid(Integer cid);
	
	/**
	 * 根据用户编号和时间删除所有评估记录
	 */
	@Query(nativeQuery = true, value = "select * from assess_record where if(?1 !='', cid=?1, 1=1)"
			+ "and  if(?2 !='', assess_date=?2, 1=1)")
	boolean deleteByCid_Date(Integer cid, Date date);
	
	Page<AssessRecord> findByCid(Integer cid, Pageable pageable);
}
