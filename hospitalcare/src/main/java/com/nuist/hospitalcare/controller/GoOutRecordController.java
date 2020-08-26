package com.nuist.hospitalcare.controller;

import com.nuist.hospitalcare.bean.ResultBean;
import com.nuist.hospitalcare.entity.GoOutRecord;
import com.nuist.hospitalcare.service.GoOutRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * 外出记录控制器
 */
@RestController
@RequestMapping("goOutRecord")
public class GoOutRecordController {
    @Autowired
    private GoOutRecordService goOutRecordService;

    /**
     * 新增外出记录
     *
     * @param goOutRecord
     * @param bindingResult
     * @return
     */
    @PostMapping("insert")
    public ResultBean insert(@Validated GoOutRecord goOutRecord, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuffer msgBuffer = new StringBuffer();
            for (FieldError iterable_element : bindingResult.getFieldErrors()) {
                msgBuffer.append(iterable_element.getField() + ":" + iterable_element.getDefaultMessage() + "\n");
            }
            return new ResultBean(5006, false, msgBuffer.toString(), null);
        }
        boolean flag = goOutRecordService.insert(goOutRecord);
        if (flag) {
            return new ResultBean(200, true, "新增外出记录成功", "");
        } else {
            return new ResultBean(500, false, "新增外出记录失败", "");
        }

    }

    /**
     * 修改外出记录
     *
     * @param goOutRecord
     * @param bindingResult
     * @return
     */
    @PutMapping("update")
    public ResultBean update(@Validated GoOutRecord goOutRecord, BindingResult bindingResult) {
        System.out.println(goOutRecord);
        if (bindingResult.hasErrors()) {
            StringBuffer msgBuffer = new StringBuffer();
            for (FieldError iterable_element : bindingResult.getFieldErrors()) {
                msgBuffer.append(iterable_element.getField() + ":" + iterable_element.getDefaultMessage() + "\n");
            }
            return new ResultBean(5006, false, msgBuffer.toString(), null);
        }
        boolean flag = goOutRecordService.update(goOutRecord);
        if (flag) {
            return new ResultBean(200, true, "修改外出记录成功", "");
        } else {
            return new ResultBean(500, false, "修改外出记录失败", "");
        }
    }

    /**
     * 分页查询用户信息
     *
     * @param page 页数
     * @return
     */
    @GetMapping("findall")
    public ResultBean findAll(Integer page,Integer limit) {
        page=page-1;
        Page<GoOutRecord> goOutRecordsPage = goOutRecordService.selectAll(PageRequest.of(page, limit));
        return new ResultBean(200, true, "查询所有外出记录成功", goOutRecordsPage);
    }

    /**
     * 根据条件查询外出记录
     *
     * @param cid
     * @param bid
     * @param goOutDate
     * @param goBackDate
     * @param page
     * @return
     */
    @GetMapping("findbycondition")
    public ResultBean findByCondition(Integer cid, Integer bid, Date goOutDate, Date goBackDate, Integer page) {
        page=page-1;
        Page<GoOutRecord> goOutRecordsPage = goOutRecordService.findByCidAndBidAndGoOutDateAndGoBackDate(cid, bid, goOutDate, goBackDate, PageRequest.of(page, 10));
        return new ResultBean(200, true, "查询外出记录成功", goOutRecordsPage);
    }

    /**
     * 删除用户信息
     *
     * @param goOutRecord
     * @return
     */
    @DeleteMapping("delete")
    public ResultBean delete(@Validated GoOutRecord goOutRecord, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuffer msgBuffer = new StringBuffer();
            for (FieldError iterable_element : bindingResult.getFieldErrors()) {
                msgBuffer.append(iterable_element.getField() + ":" + iterable_element.getDefaultMessage() + "\n");
            }
            return new ResultBean(5006, false, msgBuffer.toString(), null);
        }
        System.out.println(goOutRecord);
        boolean flag = goOutRecordService.delete(goOutRecord);
        if (flag) {
            return new ResultBean(200, true, "删除成功", "");
        } else {
            return new ResultBean(500, false, "删除失败", "");
        }
    }
}
