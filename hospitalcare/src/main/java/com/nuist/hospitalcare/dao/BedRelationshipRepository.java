package com.nuist.hospitalcare.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import com.nuist.hospitalcare.entity.BedRelationship;
import com.nuist.hospitalcare.entity.BedRelationshipKey;

public interface BedRelationshipRepository extends JpaRepository<BedRelationship, BedRelationshipKey> {
	/**
	 * 根据cid进行查询
	 */
	List<BedRelationship> findByBid(Integer bid);
	
	/**
	 * 根据bid进行查询
	 */
	List<BedRelationship> findByCid(Integer bid);
	
	/**
	 * 删除客户对应的床铺，后续需要进行对应床铺状态的修改
	 */
	@Modifying
	@Query(nativeQuery = true, value = "delete from bed_relationship where cid=?1")
	void deleteByCid(Integer cid);
}
