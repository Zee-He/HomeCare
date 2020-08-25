package com.nuist.hospitalcare.service.impl;

import com.nuist.hospitalcare.dao.GoOutRecordRepository;
import com.nuist.hospitalcare.entity.GoOutRecord;
import com.nuist.hospitalcare.service.GoOutRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class GoOutRecordServiceImpl implements GoOutRecordService {

    @Autowired
    private GoOutRecordRepository goOutRecordRepository;

    @Override
    public boolean insert(GoOutRecord goOutRecord) {
        if (goOutRecord.getCid()==null) {
            return false;
        }
        try {
            goOutRecordRepository.save(goOutRecord);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean update(GoOutRecord goOutRecord) {
        try {

            goOutRecordRepository.save(goOutRecord);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean delete(GoOutRecord goOutRecord) {
        if (goOutRecord.getCid()==null) {
            return false;
        }
        try {
            goOutRecordRepository.deleteById(goOutRecord);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Page<GoOutRecord> selectAll(Pageable pageable) {
        return goOutRecordRepository.findAll(pageable);
    }

    @Override
    public Page<GoOutRecord> findByCidAndBidAndGoOutDateAndGoBackDate(Integer cid, Integer bid, Date goOutDate, Date goBackDate, Pageable pageable) {
        return goOutRecordRepository.findByCidAndBidAndGoOutDateAndGoBackDate(cid, bid,goOutDate,goBackDate, pageable);
    }
}
