package com.nuist.hospitalcare.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nuist.hospitalcare.entity.SystemUser;

public interface SystemUserRepository extends JpaRepository<SystemUser, SystemUser> {
	
	public SystemUser findByEidAndPassword(Integer eid, String password);
	
	public SystemUser findByEid(Integer eid);
	
	public void deleteByEid(Integer eid);
}
