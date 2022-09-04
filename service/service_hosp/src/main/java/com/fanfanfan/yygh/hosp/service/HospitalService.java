package com.fanfanfan.yygh.hosp.service;


import com.fanfanfan.yygh.model.hosp.Hospital;

import java.util.Map;

public interface HospitalService {
    /**
     * 上传医院信息
     *
     * @param paramMap
     */
    void save(Map<String, Object> paramMap);
    /**
     * 查询医院
     * @param hoscode
     * @return
     */
    Hospital getByHoscode(String hoscode);
}
