package com.nuist.hospitalcare.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 服务对象关系主键
 * @author 97784
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServiceRelationshipKey implements Serializable {
	private static final long serialVersionUID = 5716156006310259760L;

    private Integer cid;
    
    private Integer eid;
}