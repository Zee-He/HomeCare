package com.nuist.hospitalcare.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.nuist.hospitalcare.entity.Dependent;
/**
 * 家属信息数据访问层接口DependentRepository
 * @author 97784
 *
 */
public interface DependentRepository extends JpaRepository<Dependent, Dependent> {
	
	/**
	 *根据客户编号 删除该客户所有家属信息
	 * 
	 * @param cid
	 */
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(nativeQuery = true, value = "delete from dependent where cid=?1")
	void deleteAllByCid(Integer cid);

	/**
	  *根据客户编号 分页查询该客户的所有家属信息
	 * @param cid
	 * @param pageable
	 * @return
	 */
	@Query(nativeQuery = true, value = "select * from dependent where if(IFNULL(?1,'') !='',cid=?1,1=1)")
	Page<Dependent> findByCid(@Param("cid")Integer cid,Pageable pageable);
	
}
