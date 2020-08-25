package com.nuist.hospitalcare.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nuist.hospitalcare.dao.BedRelationshipRepository;
import com.nuist.hospitalcare.entity.BedRelationship;
import com.nuist.hospitalcare.entity.BedRelationshipKey;
import com.nuist.hospitalcare.service.BedRelationshipService;

/**
 * 床铺关系管理业务层逻辑接口实现BedServiceImpl
 * @author ljt
 *
 */
@Service
public class BedRelationshipServiceImpl implements BedRelationshipService {

	@Autowired
	private BedRelationshipRepository  bedRelationshipRepository;

	@Override
	public boolean insert(BedRelationship bedRelationship) {
		BedRelationshipKey bedRelationshipKey = new BedRelationshipKey(bedRelationship.getCid(), bedRelationship.getBid());
		if (bedRelationshipRepository.existsById(bedRelationshipKey)) {
			return false;
		}
		try {
			bedRelationshipRepository.save(bedRelationship);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean delete(BedRelationshipKey bedRelationshipKey) {
		if (!bedRelationshipRepository.existsById(bedRelationshipKey)) {
			return false;
		}
		try {
			bedRelationshipRepository.deleteById(bedRelationshipKey);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<BedRelationship> findByCId(Integer cid) {
		return bedRelationshipRepository.findByCid(cid);
	}

	@Override
	public 	List<BedRelationship> findByBId(Integer bid) {
		return bedRelationshipRepository.findByCid(bid);
	}

	@Override
	public BedRelationship findById(BedRelationshipKey bedRelationshipKey) {
		Optional<BedRelationship> optional = bedRelationshipRepository.findById(bedRelationshipKey);
		return optional.get() ;
	}

	@Override
	public Page<BedRelationship> findAll(Pageable pageable) {
		return bedRelationshipRepository.findAll(pageable);
	}
	
	

}
