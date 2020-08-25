package com.nuist.hospitalcare.service;

import com.nuist.hospitalcare.entity.CheckInRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;

/**
 * 外出记录管理服务接口
 */
public interface CheckInRecordService {

    /**
     *增加外出记录
     * @param checkInRecord 外出记录
     * @return
     */
    boolean insert(CheckInRecord checkInRecord);

    /**
     *修改外出记录
     * @param checkInRecord 外出记录
     * @return
     */
    boolean update(CheckInRecord checkInRecord);

    /**
     * 删除外出记录
     * @param checkInRecord 外出记录
     * @return
     */
    boolean delete(CheckInRecord checkInRecord);

    /**
     * 分页查询所有客户信息
     * @param pageable 分页规则
     * @return
     */
    Page<CheckInRecord> selectAll(Pageable pageable);

    /**
     * 根据条件分页查询客户信息
     * @param cid 客户编号
     * @param bid 床位号
     * @param checkinDate 外出时间
     * @param pageable 分页规则
     * @return
     */
    Page<CheckInRecord> findByCidAndBidAndCheckinDate(Integer cid, Integer bid, Date checkinDate, Pageable pageable);

}
