package com.nuist.hospitalcare.service;

import com.nuist.hospitalcare.entity.CheckOutRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;

/**
 * 外出记录管理服务接口
 */
public interface CheckOutRecordService {

    /**
     *增加外出记录
     * @param checkOutRecord 外出记录
     * @return
     */
    boolean insert(CheckOutRecord checkOutRecord);

    /**
     *修改外出记录
     * @param checkOutRecord 外出记录
     * @return
     */
    boolean update(CheckOutRecord checkOutRecord);

    /**
     * 删除外出记录
     * @param checkOutRecord 外出记录
     * @return
     */
    boolean delete(CheckOutRecord checkOutRecord);

    /**
     * 分页查询所有客户信息
     * @param pageable 分页规则
     * @return
     */
    Page<CheckOutRecord> selectAll(Pageable pageable);

    /**
     * 根据条件分页查询客户信息
     * @param cid 客户编号
     * @param bid 床位号
     * @param checkoutDate 外出时间
     * @param pageable 分页规则
     * @return
     */
    Page<CheckOutRecord> findByCidAndBidAndCheckoutDate(Integer cid, Integer bid, Date checkoutDate, Pageable pageable);

}
