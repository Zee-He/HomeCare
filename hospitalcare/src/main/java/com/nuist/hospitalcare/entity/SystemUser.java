package com.nuist.hospitalcare.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 系统用户信息
 */
@Entity
@Table(name = "system_user_table")
@IdClass(SystemUser.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SystemUser implements Serializable {

	private static final long serialVersionUID = -7189237076165012540L;

	/**
	 * 员工编号
	 */
	@Id
	private Integer eid;

	/**
	 * 注册日期
	 */
    private Date registerDate;

    /**
     * 账户密码
     */
    private String password;
    
    /**
     * 用户类型,相当于职务
     * TODO 这是新增的字段，相应的数据库也需要增加字段user_type,类型为varchar(20) not null
     */
    private String userType;
    
    /**
     * 用户名，初始为员工姓名
     * 
     * TODO 这是新增字段
     */
    private String userName;
}