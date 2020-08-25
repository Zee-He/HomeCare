package com.nuist.hospitalcare.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nuist.hospitalcare.dao.ServiceRepository;
import com.nuist.hospitalcare.entity.Service;
import com.nuist.hospitalcare.service.ServiceService;

/**
 * 服务管理业务逻辑层实现ServiceServiceImpl
 * @author 97784
 *
 */
@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService {

	@Autowired
	private ServiceRepository serviceRepository;
	
	@Override
	public boolean insert(Service service) {
		if (service.getServiceId()!=null) {
			return false;
		}
		try {
			serviceRepository.save(service);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean update(Service service) {
		try {
			serviceRepository.save(service);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean delete(Integer serviceId) {
		if (!serviceRepository.existsById(serviceId)) {
			return false;
		}
		try {
			serviceRepository.deleteById(serviceId);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Service findByServiceId(Integer serviceId) {
		Optional<Service> service=serviceRepository.findById(serviceId);
		return service.get();
	}

	@Override
	public Page<Service> findByName(String serviceName, Pageable pageable) {
		return serviceRepository.findByServiceNameContaining(serviceName, pageable);
	}

	@Override
	public Page<Service> findAll(Pageable pageable) {
		return serviceRepository.findAll(pageable);
	}

}
