package com.nuist.hospitalcare.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



/**
 * 员工信息
 */
@Entity
@Table(name = "staff")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Staff implements Serializable {
	private static final long serialVersionUID = -6401388772573034462L;

	/**
	 * 员工编号
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer eid;

	/**
	 * 员工姓名
	 */
    private String name;

    /**
     * 员工年龄
     */
    private Integer age;

    /**
     * 员工性别
     */
    private String sex;

    /**
     * 员工身份证号
     */
    @Length(max = 18,min = 18)
    @Column(columnDefinition = "char", length = 18)
    private String pid;

    /**
     * 员工联系电话
     */
    @Column(columnDefinition = "char", length = 11)
    private String telephone;

    /**
     * 员工联系地址
     */
    private String address;

    /**
     * 员工入职日期
     */
    private Date edate;
}