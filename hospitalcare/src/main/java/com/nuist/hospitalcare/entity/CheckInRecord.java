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
 * 客户入住记录
 */
@Entity
@Table(name = "check_in_record")
@IdClass(CheckInRecord.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CheckInRecord implements Serializable {
	private static final long serialVersionUID = -7908726993561458468L;

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
	
    /**
     * 入住日期
     */
    private Date checkinDate;

}