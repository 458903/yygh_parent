package com.fanfanfan.yygh.hosp.service;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fanfanfan.yygh.model.hosp.Hospital;
import com.fanfanfan.yygh.model.hosp.HospitalSet;

import java.util.Map;

public interface HospitalService {
    /**
     * 上传医院信息
     * @param paramMap
     */
    void save(Map<String, Object> paramMap);
    /**
     * 获取签名key
     * @param hoscode
     * @return
     */
  /*  String getSignKey(String hoscode);
    *//**
     * 查询医院
     * @param hoscode
     * @return
     *//*
    Hospital getByHoscode(String hoscode);*/
}
