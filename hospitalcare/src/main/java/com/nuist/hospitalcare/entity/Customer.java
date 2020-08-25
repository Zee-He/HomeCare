package com.nuist.hospitalcare.entity;

import java.io.Serializable;

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
 * 客户信息
 */
@Entity
@Table(name = "customer")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer implements Serializable {
	private static final long serialVersionUID = -6500729416684714352L;

	/**
	 * 客户编号
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cid;

	/**
	 * 客户姓名
	 */
    private String name;

    /**
     * 客户年龄
     */
    private Integer age;

    /**
     * 客户性别
     */
    private String sex;

    /**
     * 客户身份证号
     */
    @Length(max = 18,min = 18)
    @Column(columnDefinition = "char", length = 18)
    private String pid;

    /**
     * 客户联系电话
     */
    @Length(max = 11,min = 11)
    @Column(columnDefinition = "char", length = 11)
    private String telephone;

    /**
     * 客户联系地址
     */
    private String address;

}