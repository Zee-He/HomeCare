package com.nuist.hospitalcare.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 评估模板
 */
@Entity
@Table(name = "assess_template")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AssessTemplate implements Serializable {
	private static final long serialVersionUID = -980023569972560836L;

	/**
	 * 评估模板编号
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer templateId;

	/**
	 * 评估模板内容
	 */
    private String templateContent;
}