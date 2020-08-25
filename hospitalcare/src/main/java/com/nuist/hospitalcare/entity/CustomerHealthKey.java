package com.nuist.hospitalcare.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerHealthKey implements Serializable{
	
	private static final long serialVersionUID = 1983923245430649798L;

	Integer cid;
	
	Date healthRecordDate;
}
