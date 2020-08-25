package com.nuist.hospitalcare.entity;

import java.io.Serializable;
import java.util.Date;

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
 * 紧急事件信息
 */
@Entity
@Table(name = "emergency")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Emergency implements Serializable {
	private static final long serialVersionUID = 8449721445548121313L;

	/**
	 * 事件编号
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer eventId;

	/**
	 * 事件类型
	 */
    private String eventType;

    /**
     * 事件描述
     */
    private String eventRemark;

    /**
     * 事件发生日期
     */
    private Date eventDate;
}