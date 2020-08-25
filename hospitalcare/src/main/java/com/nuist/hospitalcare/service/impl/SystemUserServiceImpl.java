package com.nuist.hospitalcare.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nuist.hospitalcare.dao.StaffRepository;
import com.nuist.hospitalcare.dao.SystemUserRepository;
import com.nuist.hospitalcare.entity.SystemUser;
import com.nuist.hospitalcare.service.SystemUserService;

/**
 * 系统用户服务实现类
 */
@Service
public class SystemUserServiceImpl implements SystemUserService {
	
	@Autowired
	private SystemUserRepository systemUserRepository;
	@Autowired
	private StaffRepository staffRepository;

	@Override
	public boolean insert(SystemUser systemUser) {
		// 检测员工编号合法性
		if (systemUser.getEid() == null || !staffRepository.existsById(systemUser.getEid())) {
			return false;
		}
		
		try {
			systemUserRepository.save(systemUser);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean update(SystemUser systemUser) {
		try {
			systemUserRepository.save(systemUser);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteById(Integer id) {
		try {
			systemUserRepository.deleteByEid(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public SystemUser selectById(Integer id) {
		return systemUserRepository.findByEid(id);
	}

	@Override
	public Page<SystemUser> selectAllInPage(Pageable pageable) {
		return systemUserRepository.findAll(pageable);
	}

	@Override
	public SystemUser login(Integer eid, String password) {
		if (StringUtils.isAnyBlank(password)) {
			return null;
		}
		return systemUserRepository.findByEidAndPassword(eid, password);
	}

}
