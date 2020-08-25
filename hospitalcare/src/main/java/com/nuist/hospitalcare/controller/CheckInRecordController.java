package com.nuist.hospitalcare.controller;

import com.nuist.hospitalcare.bean.ResultBean;
import com.nuist.hospitalcare.entity.CheckInRecord;
import com.nuist.hospitalcare.service.CheckInRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * 退住记录控制器
 */
@RestController
@RequestMapping("checkinRecord")
public class CheckInRecordController {
    @Autowired
    private CheckInRecordService checkInRecordService;

    /**
     * 新增退住记录
     *
     * @param checkInRecord
     * @param bindingResult
     * @return
     */
    @PutMapping("insert")
    public ResultBean insert(@Validated CheckInRecord checkInRecord, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuffer msgBuffer = new StringBuffer();
            for (FieldError iterable_element : bindingResult.getFieldErrors()) {
                msgBuffer.append(iterable_element.getField() + ":" + iterable_element.getDefaultMessage() + "\n");
            }
            return new ResultBean(5006, false, msgBuffer.toString(), null);
        }
        boolean flag = checkInRecordService.insert(checkInRecord);
        if (flag) {
            return new ResultBean(200, true, "新增入住记录成功", "");
        } else {
            return new ResultBean(500, false, "新增入住记录失败", "");
        }

    }

    /**
     * 修改退住记录
     *
     * @param checkInRecord
     * @param bindingResult
     * @return
     */
    @PutMapping("update")
    public ResultBean update(@Validated CheckInRecord checkInRecord, BindingResult bindingResult) {
        System.out.println(checkInRecord);
        if (bindingResult.hasErrors()) {
            StringBuffer msgBuffer = new StringBuffer();
            for (FieldError iterable_element : bindingResult.getFieldErrors()) {
                msgBuffer.append(iterable_element.getField() + ":" + iterable_element.getDefaultMessage() + "\n");
            }
            return new ResultBean(5006, false, msgBuffer.toString(), null);
        }
        boolean flag = checkInRecordService.update(checkInRecord);
        if (flag) {
            return new ResultBean(200, true, "修改入住记录成功", "");
        } else {
            return new ResultBean(500, false, "修改入住记录失败", "");
        }
    }

    /**
     * 分页查询用户信息
     *
     * @param page 页数
     * @return
     */
    @PostMapping("findall")
    public ResultBean findAll(Integer page,Integer limit) {
        page=page-1;
        Page<CheckInRecord> checkInRecordsPage = checkInRecordService.selectAll(PageRequest.of(page, limit));
        return new ResultBean(200, true, "查询所有入住记录成功", checkInRecordsPage);
    }

    /**
     * 根据条件查询退住记录
     *
     * @param cid
     * @param bid
     * @param checkinDate
     * @param page
     * @return
     */
    @PostMapping("findbycondition")
    public ResultBean findByCondition(Integer cid, Integer bid, Date checkinDate, Integer page) {
        page=page-1;
        Page<CheckInRecord> checkInRecordsPage = checkInRecordService.findByCidAndBidAndCheckinDate(cid, bid, checkinDate, PageRequest.of(page, 10));
        return new ResultBean(200, true, "查询入住记录成功", checkInRecordsPage);
    }
    /**
     * 删除用户信息
     *
     * @param checkInRecord
     * @return
     */
    @DeleteMapping("delete")
    public ResultBean delete(@Validated CheckInRecord checkInRecord, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuffer msgBuffer = new StringBuffer();
            for (FieldError iterable_element : bindingResult.getFieldErrors()) {
                msgBuffer.append(iterable_element.getField() + ":" + iterable_element.getDefaultMessage() + "\n");
            }
            return new ResultBean(5006, false, msgBuffer.toString(), null);
        }
        System.out.println(checkInRecord);
        boolean flag = checkInRecordService.delete(checkInRecord);
        if (flag) {
            return new ResultBean(200, true, "删除成功", "");
        } else {
            return new ResultBean(500, false, "删除失败", "");
        }
    }
}
