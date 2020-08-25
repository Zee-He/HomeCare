package com.nuist.hospitalcare.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nuist.hospitalcare.entity.Bed;

/**
 * 床铺管理数据访问层ServiceRepository
 * @author ljt
 *
 */
public interface BedRepository extends JpaRepository<Bed, Integer> {

}
