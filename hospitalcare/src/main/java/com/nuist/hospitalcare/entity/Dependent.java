package com.nuist.hospitalcare.entity;

import java.io.Serializable;

import javax.persistence.Column;
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
 * 家属信息
 */
@Entity
@Table(name = "dependent")
@IdClass(Dependent.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Dependent implements Serializable {
	private static final long serialVersionUID = 1082577934700642390L;

	/**
	 * 客户编号
	 */
	@Id
	private Integer cid;

	/**
	 * 家属姓名
	 */
	@NotBlank(message = "家属姓名不能为空")
    private String dependentName;

    /**
     * 家属与客户的关系
     */
    private String relationship;

    /**
     * 家属联系电话
     */
    @NotBlank(message = "家属联系电话不能为空")
    @Column(columnDefinition = "char", length = 11)
    private String dependentTelephone;

}