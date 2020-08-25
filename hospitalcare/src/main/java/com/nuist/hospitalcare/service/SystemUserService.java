package com.nuist.hospitalcare.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nuist.hospitalcare.entity.SystemUser;

/**
 * 本系统用户控制服务
 * @author BuluGuy
 */
public interface SystemUserService {
	/**
	 * 新增系统用户
	 * @param systemUser 系统用户信息
	 * @return
	 */
	public boolean insert(SystemUser systemUser);
	
	/**
	 * 更新系统用户信息
	 * @param systemUser 系统用户信息
	 * @return
	 */
	public boolean update(SystemUser systemUser);
	
	/**
	 * 根据员工编号删除系统用户信息
	 * @param id 员工编号
	 * @return
	 */
	public boolean deleteById(Integer id);
	
	/**
	 * 查询用户
	 * @param id 用户员工编号
	 * @return
	 */
	public SystemUser selectById(Integer id);
	
	/**
	 * 分页查询系统用户
	 * @param pageable
	 * @return
	 */
	public Page<SystemUser> selectAllInPage(Pageable pageable);
	
	/**
	 * 系统用户登录
	 * @param eid 员工编号
	 * @param password 密码
	 * @return
	 */
	public SystemUser login(Integer eid, String password);
	
}
