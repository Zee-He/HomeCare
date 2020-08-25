package com.nuist.hospitalcare.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 客户健康档案信息
 */
@Entity
@Table(name = "customer_health")
@IdClass(CustomerHealth.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerHealth implements Serializable {
	private static final long serialVersionUID = -5987401683483102366L;

	/**
	 * 客户编号
	 */
	@Id
	@NotBlank(message = "客户编号不能为空")
	private Integer cid;

	/**
	 * 健康档案创建日期
	 */
	@NotBlank(message = "创建不能为空")
    private Date healthRecordDate;

    /**
     * 健康档案
     */
	@NotBlank(message = "健康档案不能为空")
    private String healthRecord;

}