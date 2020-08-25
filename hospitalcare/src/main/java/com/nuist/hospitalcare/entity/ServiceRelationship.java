package com.nuist.hospitalcare.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



/**
 * 服务对象关系
 * 
 * 表示员工与客户之间的服务关系
 */
@Entity
@Table(name = "service_relationship")
@IdClass(ServiceRelationshipKey.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServiceRelationship implements Serializable {
	private static final long serialVersionUID = 5716156006310259760L;

	/**
	 * 客户编号
	 */
	@Id
    private Integer cid;
	
	/**
	 * 员工编号
	 */
	@Id
	private Integer eid;
}