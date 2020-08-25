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
public class CheckInRecordKey implements Serializable {
	private static final long serialVersionUID = -2829266548938471580L;

	private Integer cid;

    private Integer bid;
}