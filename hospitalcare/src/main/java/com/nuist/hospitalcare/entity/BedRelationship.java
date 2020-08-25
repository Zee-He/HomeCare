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
 * 客户与床位的所属关系
 */
@Entity
@Table(name = "bed_relationship")
@IdClass(BedRelationshipKey.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BedRelationship implements Serializable {
	private static final long serialVersionUID = -3138804401919314731L;

	/**
	 * 客户编号
	 */
	@Id
	private Integer cid;

	/**
	 * 床位编号
	 */
	@Id
    private Integer bid;

}