package com.nuist.hospitalcare.service;

import com.nuist.hospitalcare.entity.GoOutRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;

/**
 * 外出记录管理服务接口
 */
public interface GoOutRecordService {

    /**
     *增加外出记录
     * @param goOutRecord 外出记录
     * @return
     */
    boolean insert(GoOutRecord goOutRecord);

    /**
     *修改外出记录
     * @param goOutRecord 外出记录
     * @return
     */
    boolean update(GoOutRecord goOutRecord);

    /**
     * 删除外出记录
     * @param goOutRecord 外出记录
     * @return
     */
    boolean delete(GoOutRecord goOutRecord);

    /**
     * 分页查询所有客户信息
     * @param pageable 分页规则
     * @return
     */
    Page<GoOutRecord> selectAll(Pageable pageable);

    /**
     * 根据条件分页查询客户信息
     * @param cid 客户编号
     * @param bid 床位号
     * @param goOutDate 外出时间
     * @param goBackDate 返回时间
     * @param pageable 分页规则
     * @return
     */
    Page<GoOutRecord> findByCidAndBidAndGoOutDateAndGoBackDate(Integer cid, Integer bid, Date goOutDate, Date goBackDate,Pageable pageable);

}
