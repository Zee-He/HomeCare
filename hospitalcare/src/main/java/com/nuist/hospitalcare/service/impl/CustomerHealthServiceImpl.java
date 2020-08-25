package com.nuist.hospitalcare.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nuist.hospitalcare.dao.CustomerHealthRepository;
import com.nuist.hospitalcare.entity.CustomerHealth;
import com.nuist.hospitalcare.service.CustomerHealthService;

/**
 * 健康档案管理业务逻辑层接口实现CustomerHealthServiceImpl
 * @author 97784
 *
 */
@Service
public class CustomerHealthServiceImpl implements CustomerHealthService {

	@Autowired
	private CustomerHealthRepository customerHealthRepository;
	
	@Override
	public boolean insert(CustomerHealth customerHealth) {
		if(customerHealthRepository.existsById(customerHealth)) {
			return false;
		}
		try {
			customerHealthRepository.save(customerHealth);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteByCid(Integer cid) {
		try {
			customerHealthRepository.deleteByCid(cid);;
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean delete(CustomerHealth customerHealth) {
		if(!customerHealthRepository.existsById(customerHealth)) {
			return false;
		}
		try {
			customerHealthRepository.deleteById(customerHealth);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Page<CustomerHealth> findByCid(Integer cid, Pageable pageable) {
		if(cid!=null&&cid<1) {
			cid=null;
		}
		return customerHealthRepository.findByCid(cid, pageable);
	}

	@Override
	public Page<CustomerHealth> findAll(Pageable pageable) {
		return customerHealthRepository.findAll(pageable);
	}

}
