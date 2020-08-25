package com.nuist.hospitalcare.bean;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 统一返回数据类型ResultBean：通过bean可以获取是否成功，详细信息，具体编码，数据（字符串，实体对象，实体对象集合.....）
 * @author 97784
 *
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResultBean implements Serializable{

	private Integer code;//可以定义枚举类型表示各种编码  200成功  其他失败
	private boolean successed;//true成功，false失败
	private String message;//详细信息
	private Object data;//数据
	
	private static final long serialVersionUID = -1189109843163899847L;
}
