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
 * 客户退住记录
 */
@Entity
@Table(name = "check_out_record")
@IdClass(CheckOutRecord.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CheckOutRecord implements Serializable {
	private static final long serialVersionUID = 5977434049767815332L;

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
     * 退住日期
     */
    private Date checkoutDate;

}