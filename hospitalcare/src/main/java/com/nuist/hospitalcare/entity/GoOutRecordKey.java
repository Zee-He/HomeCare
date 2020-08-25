package com.nuist.hospitalcare.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GoOutRecordKey implements Serializable {
	private static final long serialVersionUID = -3672342455137777844L;

	private Integer cid;

    private Integer bid;

}