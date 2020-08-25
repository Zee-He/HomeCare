package com.nuist.hospitalcare.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 评估记录
 */
@Entity
@Table(name = "assess_record")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AssessRecord implements Serializable {

	private static final long serialVersionUID = 1378073904541766984L;
	
	/**
	 * 客户编号
	 */
	private Integer cid;

	/**
	 * 评估模板编号
	 */
    private Integer templateId;
	
	/**
	 * 评估日期
	 */
    @Id
	private Date assessDate;

	/**
	 * 评估结果
	 */
    private String assessResult;
}