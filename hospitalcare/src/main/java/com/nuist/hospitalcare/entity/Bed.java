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
 * 床位信息
 */
@Entity
@Table(name = "bed")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Bed implements Serializable {
	private static final long serialVersionUID = 709918457021508880L;

	/**
	 * 床位编号
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bid;

	/**
	 * 床位所在楼层
	 */
    private Integer floor;

    /**
     * 床位所在房间号
     */
    private Integer room;

    /**
     * 床位状态
     */
    private String status;

    /**
     * 床位所在建筑
     */
    private String building;

}