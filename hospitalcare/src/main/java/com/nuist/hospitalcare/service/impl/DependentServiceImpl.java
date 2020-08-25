package com.nuist.hospitalcare.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nuist.hospitalcare.dao.DependentRepository;
import com.nuist.hospitalcare.entity.Dependent;
import com.nuist.hospitalcare.service.DependentService;

/**
 * 家属信息业务逻辑层接口实现
 * @author 97784
 *
 */
@Service
public class DependentServiceImpl implements DependentService {

	@Autowired
	private DependentRepository dependentRepository;
	
	@Override
	public boolean insert(Dependent dependent) {
		if(dependentRepository.existsById(dependent)) {
			return false;
		}
		try {
			dependentRepository.save(dependent);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean update(Dependent dependent) {
		try {
			dependentRepository.save(dependent);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteByCid(Integer cid) {
		try {
			dependentRepository.deleteByCid(cid);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean delete(Dependent dependent) {
		if(!dependentRepository.existsById(dependent)) {
			return false;
		}
		try {
			dependentRepository.deleteById(dependent);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Page<Dependent> findByCid(Integer cid, Pageable pageable) {
		if(cid!=null&&cid<1) {
			cid=null;
		}
		return dependentRepository.findByCid(cid, pageable);
	}

	@Override
	public Page<Dependent> findAll(Pageable pageable) {
		return dependentRepository.findAll(pageable);
	}

}
