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
 * 外出记录
 */
@Entity
@Table(name = "go_out_record")
@IdClass(GoOutRecord.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GoOutRecord implements Serializable {
	
	private static final long serialVersionUID = 6400545875509769327L;

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
     * 外出时间
     */
    private Date goOutDate;

    /**
     * 预定返回时间
     */
    private Date goBackDate;

}