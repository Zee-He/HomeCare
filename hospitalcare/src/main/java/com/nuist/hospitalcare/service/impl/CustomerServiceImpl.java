package com.nuist.hospitalcare.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nuist.hospitalcare.dao.CustomerRepository;
import com.nuist.hospitalcare.entity.Customer;
import com.nuist.hospitalcare.service.CustomerService;

/**
 * 客户信息管理实现类
 * @author BuluGuy
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public boolean insert(Customer customer) {
		if (customer.getCid() != null) {
			return false;
		}
		try {
			customerRepository.save(customer);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean update(Customer customer) {
		try {
			customerRepository.save(customer);
			return true;
		} catch (Exception e) {
			return false;
		}
	}


	@Override
	public Page<Customer> findByNameInPage(String name, Pageable pageable) {
		return customerRepository.findByNameLike(name, pageable);
	}

	@Override
	public Page<Customer> selectAllInPage(Pageable pageable) {
		return customerRepository.findAll(pageable);
	}

	@Override
	public boolean deleteById(Integer id) {
		if (!customerRepository.existsById(id)) {
			return false;
		}
		try {
			customerRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
