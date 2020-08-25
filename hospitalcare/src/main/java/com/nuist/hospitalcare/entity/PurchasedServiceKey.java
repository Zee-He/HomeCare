package com.nuist.hospitalcare.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 已购服务实体主键
 * @author 97784
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PurchasedServiceKey implements Serializable {
	private static final long serialVersionUID = 6351466239130574542L;

	private Integer cid;

    private Integer serviceId;
    
    private Date pdate;

}