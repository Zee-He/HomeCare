package com.nuist.hospitalcare.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nuist.hospitalcare.dao.PurchasedServiceRepository;
import com.nuist.hospitalcare.entity.PurchasedService;
import com.nuist.hospitalcare.entity.PurchasedServiceKey;
import com.nuist.hospitalcare.service.PurchasedServiceService;

/**
 * 顾客购买服务记录 业务逻辑层接口实现PurchasedServiceServiceImpl
 * 
 * @author 97784
 *
 */
@Service
public class PurchasedServiceServiceImpl implements PurchasedServiceService {

	@Autowired
	private PurchasedServiceRepository purchasedServiceRepository;

	@Override
	public boolean insert(PurchasedService purchasedService) {
		PurchasedServiceKey purchasedServiceKey = new PurchasedServiceKey(purchasedService.getCid(),
				purchasedService.getServiceId(), purchasedService.getPdate());
		if (purchasedServiceRepository.existsById(purchasedServiceKey)) {
//			System.out.println(11);
			return false;
		}
		try {
			purchasedServiceRepository.save(purchasedService);
			return true;
		} catch (Exception e) {
//			System.out.println(22);
			return false;
		}
	}

	@Override
	public boolean deleteAllByCid(Integer cid) {
		try {
			purchasedServiceRepository.deleteAllByCid(cid);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public boolean deleteAllByServiceId(Integer serviceId) {
		try {
			purchasedServiceRepository.deleteAllByServiceId(serviceId);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean delete(PurchasedServiceKey purchasedServiceKey) {
		if (!purchasedServiceRepository.existsById(purchasedServiceKey)) {
			return false;
		}
		try {
			purchasedServiceRepository.deleteById(purchasedServiceKey);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Page<PurchasedService> findByCidServiceId(Integer cid, Integer serviceId, Pageable pageable) {
		if (cid != null && cid < 1) {
			cid = null;
		}
		if (serviceId != null && serviceId < 1) {
			serviceId = null;
		}
		return purchasedServiceRepository.findByCidServiceId(cid, serviceId, pageable);
	}

	@Override
	public Page<PurchasedService> findAll(Pageable pageable) {
		return purchasedServiceRepository.findAll(pageable);
	}

}
