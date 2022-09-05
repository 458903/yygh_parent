package com.fanfanfan.yygh.hosp.service;


import com.fanfanfan.yygh.model.hosp.Hospital;
import com.fanfanfan.yygh.vo.hosp.HospitalQueryVo;
import org.springframework.data.domain.Page;

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
    /**
     * 分页查询
     * @param page 当前页码
     * @param limit 每页记录数
     * @param hospitalQueryVo 查询条件
     */
    Page<Hospital> selectPage(Integer page, Integer limit, HospitalQueryVo hospitalQueryVo);
}
