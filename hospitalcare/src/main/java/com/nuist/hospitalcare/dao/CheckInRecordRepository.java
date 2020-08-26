package com.nuist.hospitalcare.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.nuist.hospitalcare.entity.CheckInRecord;
import java.util.Date;

public interface CheckInRecordRepository extends JpaRepository<CheckInRecord, CheckInRecord> {
    Page<CheckInRecord> findByCidOrBidOrCheckinDate(Integer cid, Integer bid, Date checkinDate, Pageable pageable);
    
}
