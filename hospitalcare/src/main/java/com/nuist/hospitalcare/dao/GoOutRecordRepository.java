package com.nuist.hospitalcare.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.nuist.hospitalcare.entity.GoOutRecord;
import java.util.Date;

public interface GoOutRecordRepository extends JpaRepository<GoOutRecord, GoOutRecord> {
    Page<GoOutRecord> findByCidAndBidAndGoOutDateAndGoBackDate(Integer cid, Integer bid, Date goOutDate, Date goBackDate, Pageable pageable);
}
