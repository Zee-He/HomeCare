package com.nuist.hospitalcare.service.impl;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nuist.hospitalcare.dao.AssessRecordRepository;
import com.nuist.hospitalcare.entity.AssessRecord;
import com.nuist.hospitalcare.service.AssessRecordService;

/**
 * 评估记录信息管理业务层逻辑接口实现AssessRecordServiceImpl
 * @author ljt
 *
 */
@Service
public class AssessRecordServiceImpl implements AssessRecordService {

	@Autowired
	private AssessRecordRepository assessRecordRepository;
	
	@Override
	public boolean insert(AssessRecord assessRecord) {
		try {
			assessRecordRepository.save(assessRecord);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean update(AssessRecord assessRecord) {
		try {
			assessRecordRepository.save(assessRecord);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteByCid(Integer cid) {
		try {
			return assessRecordRepository.deleteByCid(cid);
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean delete(Integer cid, Date date) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Page<AssessRecord> findByCId(Integer cid, Pageable pageable) {
		return assessRecordRepository.findByCid(cid, pageable);
	}

	@Override
	public Page<AssessRecord> findByResultLike(String content, Pageable pageable) {
		return assessRecordRepository.findByResultLike(content, pageable);
	}

	@Override
	public Page<AssessRecord> findAll(Pageable pageable) {
		return assessRecordRepository.findAll(pageable);
	}

	@Override
	public Page<AssessRecord> findByDate(Date begin, Date end) {
		// TODO Auto-generated method stub
		return null;
	}

}
