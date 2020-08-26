package com.nuist.hospitalcare.service.impl;

import com.nuist.hospitalcare.dao.CheckOutRecordRepository;
import com.nuist.hospitalcare.entity.CheckOutRecord;
import com.nuist.hospitalcare.service.CheckOutRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CheckOutRecordServiceImpl implements CheckOutRecordService {

    @Autowired
    private CheckOutRecordRepository checkoutRecordRepository;

    @Override
    public boolean insert(CheckOutRecord checkoutRecord) {
        if (checkoutRecord.getCid()==null) {
            return false;
        }
        try {
            checkoutRecordRepository.save(checkoutRecord);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean update(CheckOutRecord checkoutRecord) {
        try {
            checkoutRecordRepository.save(checkoutRecord);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean delete(CheckOutRecord checkoutRecord) {
        if (checkoutRecord.getCid()==null) {
            return false;
        }
        try {
            checkoutRecordRepository.deleteById(checkoutRecord);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Page<CheckOutRecord> selectAll(Pageable pageable) {
        return checkoutRecordRepository.findAll(pageable);
    }

    @Override
    public Page<CheckOutRecord> findByCidAndBidAndCheckoutDate(Integer cid, Integer bid, Date checkoutDate, Pageable pageable) {
    	if (cid != null && cid < 1) {
			cid = null;
		}
    	
    	if (bid != null && bid < 1) {
    		bid = null;
		}
    	
    	if (cid == null && bid == null && checkoutDate == null) {
    		return checkoutRecordRepository.findAll(pageable);
		}
        return checkoutRecordRepository.findByCidOrBidOrCheckoutDate(cid, bid, checkoutDate, pageable);
    }
}
