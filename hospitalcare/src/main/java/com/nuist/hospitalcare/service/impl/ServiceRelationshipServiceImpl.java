package com.nuist.hospitalcare.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nuist.hospitalcare.dao.ServiceRelationshipRepository;
import com.nuist.hospitalcare.entity.ServiceRelationship;
import com.nuist.hospitalcare.entity.ServiceRelationshipKey;
import com.nuist.hospitalcare.service.ServiceRelationshipService;

/**
 * 服务关系业务逻辑层接口实现
 * @author 97784
 *
 */
@Service
public class ServiceRelationshipServiceImpl implements ServiceRelationshipService {

	@Autowired
	private ServiceRelationshipRepository serviceRelationshipRepository;
	
	@Override
	public boolean insert(ServiceRelationship serviceRelationship) {
		ServiceRelationshipKey serviceRelationshipKey=new ServiceRelationshipKey(serviceRelationship.getCid(), serviceRelationship.getEid());
		if (serviceRelationshipRepository.existsById(serviceRelationshipKey)){
			return false;
		}
		try {
			serviceRelationshipRepository.save(serviceRelationship);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	@Override
	@Transactional
	public boolean update(ServiceRelationshipKey oldRelationship, ServiceRelationship newRelationship) {
//		if (!serviceRelationshipRepository.existsById(serviceRelationshipKey)){
//			return false;
//		}
		// 确认旧关系的存在
		if (!serviceRelationshipRepository.existsById(oldRelationship)) {
			return false;
		}
		
		// 确认新关系不存在
		if (serviceRelationshipRepository.existsById(new ServiceRelationshipKey(newRelationship.getCid(), newRelationship.getEid()))) {
			return false;
		}
		
		try {
			// 首先删除旧关系
			serviceRelationshipRepository.deleteById(oldRelationship);
			// 尝试插入新关系
			serviceRelationshipRepository.save(newRelationship);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteAllByCid(Integer cid) {
		try {
			serviceRelationshipRepository.deleteAllByCid(cid);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteAllByEid(Integer eid) {
		try {
			serviceRelationshipRepository.deleteAllByEid(eid);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean delete(ServiceRelationshipKey serviceRelationshipKey) {
		if (!serviceRelationshipRepository.existsById(serviceRelationshipKey)){
			return false;
		}
		try {
			serviceRelationshipRepository.deleteById(serviceRelationshipKey);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	@Override
	public Page<ServiceRelationship> findByCidEid(Integer cid, Integer eid, Pageable pageable) {
		if(cid!=null&&cid<1) {
			cid=null;
		}
		if(eid!=null&&eid<1) {
			eid=null;
		}
		if (cid == null && eid == null) {
			return serviceRelationshipRepository.findAll(pageable);
		}
		return serviceRelationshipRepository.findByCidOrEid(cid, eid, pageable);
	}

	@Override
	public Page<ServiceRelationship> findAll(Pageable pageable) {
		return serviceRelationshipRepository.findAll(pageable);
	}


}
