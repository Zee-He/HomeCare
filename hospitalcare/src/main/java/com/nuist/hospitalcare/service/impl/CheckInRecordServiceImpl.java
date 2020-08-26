package com.nuist.hospitalcare.service.impl;

import com.nuist.hospitalcare.dao.CheckInRecordRepository;
import com.nuist.hospitalcare.entity.CheckInRecord;
import com.nuist.hospitalcare.service.CheckInRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CheckInRecordServiceImpl implements CheckInRecordService {

    @Autowired
    private CheckInRecordRepository checkinRecordRepository;

    @Override
    public boolean insert(CheckInRecord checkinRecord) {
        if (checkinRecord.getCid()==null) {
            return false;
        }
        try {
            checkinRecordRepository.save(checkinRecord);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean update(CheckInRecord checkinRecord) {
        try {
            checkinRecordRepository.save(checkinRecord);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean delete(CheckInRecord checkinRecord) {
        if (checkinRecord.getCid()==null) {
            return false;
        }
        try {
            checkinRecordRepository.deleteById(checkinRecord);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Page<CheckInRecord> selectAll(Pageable pageable) {
        return checkinRecordRepository.findAll(pageable);
    }

    @Override
    public Page<CheckInRecord> findByCidAndBidAndCheckinDate(Integer cid, Integer bid, Date checkinDate, Pageable pageable) {
    	if (cid != null && cid < 1) {
			cid = null;
		}
    	
    	if (bid != null && bid < 1) {
    		bid = null;
		}
    	
    	if (cid == null && bid == null && checkinDate == null) {
			return checkinRecordRepository.findAll(pageable);
		}
    	
        return checkinRecordRepository.findByCidOrBidOrCheckinDate(cid, bid, checkinDate, pageable);
    }
}
