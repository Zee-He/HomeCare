package com.nuist.hospitalcare.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.nuist.hospitalcare.entity.CheckOutRecord;
import java.util.Date;

public interface CheckOutRecordRepository extends JpaRepository<CheckOutRecord, CheckOutRecord> {
    Page<CheckOutRecord> findByCidAndBidAndCheckoutDate(Integer cid, Integer bid, Date checkoutDate, Pageable pageable);
}
