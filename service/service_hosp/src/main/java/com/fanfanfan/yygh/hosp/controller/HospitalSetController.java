package com.fanfanfan.yygh.hosp.controller;


import com.fanfanfan.yygh.hosp.service.HospitalSetService;
import com.fanfanfan.yygh.model.hosp.HospitalSet;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 医院设置表 前端控制器
 * </p>
 *
 * @author fanfanfan
 * @since 2022-08-29
 */
@RestController
@Api(description = "医院设置接口")
@RequestMapping("/admin/hosp/hospital-set")
public class HospitalSetController {
    @Autowired
    private HospitalSetService hospitalSetService;
    @GetMapping("findAll")
    public List<HospitalSet> findAll() {
        List<HospitalSet> list = hospitalSetService.list();
        return list;
    }
    @DeleteMapping("{id}")
    public boolean removeById(@PathVariable String id){
        return hospitalSetService.removeById(id);
    }
}

