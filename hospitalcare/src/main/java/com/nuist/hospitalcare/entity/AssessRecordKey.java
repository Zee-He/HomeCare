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
public class AssessRecordKey implements Serializable {
	private static final long serialVersionUID = -437833627286797714L;

	private Integer cid;

    private Integer templateId;
}