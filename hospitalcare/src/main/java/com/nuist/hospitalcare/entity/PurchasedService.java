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
 * 客户已购服务记录实体
 */
@Entity
@Table(name = "purchased_service")
@IdClass(PurchasedServiceKey.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PurchasedService implements Serializable {
	
	private static final long serialVersionUID = -5727770193102121838L;

	/**
	 * 客户编号
	 */
	@Id
	private Integer cid;

	/**
	 * 服务编号
	 */
	@Id
    private Integer serviceId;
	
	/**
	 * 购买日期时间
	 */
    private Date pdate;

}