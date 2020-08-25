package com.nuist.hospitalcare.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;




/**
 * 服务信息实体
 */
@Entity
@Table(name = "service")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Service implements Serializable {
	private static final long serialVersionUID = -7450904966659443405L;

	/**
	 * 服务编号
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer serviceId;

	/**
	 * 服务名称
	 */
    @NotBlank(message = "服务名称不能为空")
    @Length(min = 2, message = "服务名称至少两个字符")
    private String serviceName;

    /**
     * 服务描述
     */
    private String serviceRemark;

    /**
     * 服务状态
     * 
     * 如启用、停用等
     */
    @NotBlank(message = "服务状态不能为空")
    private String serviceStatus;

    /**
     * 服务售价
     */
    private Float servicePrice;

    /**
     * 服务上架日期
     */
    private Date serviceDate;

    /**
     * 服务有效时间
     */
    private Long serviceValidTime;

}