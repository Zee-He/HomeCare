package com.nuist.hospitalcare.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nuist.hospitalcare.dao.BedRepository;
import com.nuist.hospitalcare.entity.Bed;
import com.nuist.hospitalcare.service.BedService;

/**
 * 床铺管理业务层逻辑接口实现BedServiceImpl
 * @author ljt
 *
 */
@Service
public class BedServiceImpl implements BedService {

	@Autowired
	private BedRepository bedRepository;
	
	@Override
	public boolean insert(Bed bed) {
		if (bedRepository.existsById(bed.getBid())) {
			return false;
		}
		try {
			bedRepository.save(bed);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean update(Bed bed) {
		try {
			bedRepository.save(bed);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean delete(Integer bid) {
		if (!bedRepository.existsById(bid)) {
			return false;
		}
		try {
			bedRepository.deleteById(bid);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Bed findByBedId(Integer bid) {
		Optional<Bed> service=bedRepository.findById(bid);
		return service.get();
	}

	@Override
	public Page<Bed> findAll(Pageable pageable) {
		return bedRepository.findAll(pageable);
	}

}
