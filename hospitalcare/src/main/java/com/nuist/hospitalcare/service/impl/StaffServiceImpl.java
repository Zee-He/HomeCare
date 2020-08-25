package com.nuist.hospitalcare.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nuist.hospitalcare.dao.StaffRepository;
import com.nuist.hospitalcare.entity.Staff;
import com.nuist.hospitalcare.service.StaffService;

/**
 * 工作人员信息管理业务层逻辑接口实现StaffServiceImpl
 * @author ljt
 *
 */
@Service
public class StaffServiceImpl implements StaffService {

	@Autowired
	private StaffRepository staffRepository;
	
	@Override
	public boolean insert(Staff staff) {
		if (staffRepository.existsById(staff.getEid())) {
			return false;
		}
		try {
			staffRepository.save(staff);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean update(Staff staff) {
		try {
			staffRepository.save(staff);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean delete(Integer id) {
		if (!staffRepository.existsById(id)) {
			return false;
		}
		try {
			staffRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Staff findById(Integer id) {
		Optional<Staff> optional=staffRepository.findById(id);
		return optional.get();
	}

	@Override
	public Page<Staff> findByNameLike(String name, Pageable pageable) {
		return staffRepository.findByNameLike(name, pageable);
	}

	@Override
	public Page<Staff> findAll(Pageable pageable) {
		return staffRepository.findAll(pageable);
	}

}
