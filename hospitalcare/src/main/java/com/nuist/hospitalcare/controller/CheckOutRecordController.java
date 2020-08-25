package com.nuist.hospitalcare.controller;

import com.nuist.hospitalcare.bean.ResultBean;
import com.nuist.hospitalcare.entity.CheckOutRecord;
import com.nuist.hospitalcare.service.CheckOutRecordService;
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
@RequestMapping("checkoutRecord")
public class CheckOutRecordController {
    @Autowired
    private CheckOutRecordService checkOutRecordService;

    /**
     * 新增退住记录
     *
     * @param checkOutRecord
     * @param bindingResult
     * @return
     */
    @PutMapping("insert")
    public ResultBean insert(@Validated CheckOutRecord checkOutRecord, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuffer msgBuffer = new StringBuffer();
            for (FieldError iterable_element : bindingResult.getFieldErrors()) {
                msgBuffer.append(iterable_element.getField() + ":" + iterable_element.getDefaultMessage() + "\n");
            }
            return new ResultBean(5006, false, msgBuffer.toString(), null);
        }
        boolean flag = checkOutRecordService.insert(checkOutRecord);
        if (flag) {
            return new ResultBean(200, true, "新增退住记录成功", "");
        } else {
            return new ResultBean(500, false, "新增退住记录失败", "");
        }

    }

    /**
     * 修改退住记录
     *
     * @param checkOutRecord
     * @param bindingResult
     * @return
     */
    @PutMapping("update")
    public ResultBean update(@Validated CheckOutRecord checkOutRecord, BindingResult bindingResult) {
        System.out.println(checkOutRecord);
        if (bindingResult.hasErrors()) {
            StringBuffer msgBuffer = new StringBuffer();
            for (FieldError iterable_element : bindingResult.getFieldErrors()) {
                msgBuffer.append(iterable_element.getField() + ":" + iterable_element.getDefaultMessage() + "\n");
            }
            return new ResultBean(5006, false, msgBuffer.toString(), null);
        }
        boolean flag = checkOutRecordService.update(checkOutRecord);
        if (flag) {
            return new ResultBean(200, true, "修改退住记录成功", "");
        } else {
            return new ResultBean(500, false, "修改退住记录失败", "");
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
        Page<CheckOutRecord> checkOutRecordsPage = checkOutRecordService.selectAll(PageRequest.of(page, limit));
        return new ResultBean(200, true, "查询所有退住记录成功", checkOutRecordsPage);
    }

    /**
     * 根据条件查询退住记录
     *
     * @param cid
     * @param bid
     * @param checkoutDate
     * @param page
     * @return
     */
    @PostMapping("findbycondition")
    public ResultBean findByCondition(Integer cid, Integer bid,Date checkoutDate,Integer page) {
        page=page-1;
        Page<CheckOutRecord> checkOutRecordsPage = checkOutRecordService.findByCidAndBidAndCheckoutDate(cid, bid, checkoutDate, PageRequest.of(page, 10));
        return new ResultBean(200, true, "查询退住记录成功", checkOutRecordsPage);
    }
    /**
     * 删除用户信息
     *
     * @param checkOutRecord
     * @return
     */
    @DeleteMapping("delete")
    public ResultBean delete(@Validated CheckOutRecord checkOutRecord, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuffer msgBuffer = new StringBuffer();
            for (FieldError iterable_element : bindingResult.getFieldErrors()) {
                msgBuffer.append(iterable_element.getField() + ":" + iterable_element.getDefaultMessage() + "\n");
            }
            return new ResultBean(5006, false, msgBuffer.toString(), null);
        }
        System.out.println(checkOutRecord);
        boolean flag = checkOutRecordService.delete(checkOutRecord);
        if (flag) {
            return new ResultBean(200, true, "删除成功", "");
        } else {
            return new ResultBean(500, false, "删除失败", "");
        }
    }
}
