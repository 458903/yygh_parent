package com.fanfanfan.yygh.hosp.service.impl;
import com.alibaba.fastjson.JSONObject;
import com.fanfanfan.yygh.common.exception.YyghException;
import com.fanfanfan.yygh.hosp.repository.HospitalRepository;
import com.fanfanfan.yygh.hosp.service.HospitalService;
import com.fanfanfan.yygh.model.hosp.Hospital;
import com.fanfanfan.yygh.model.hosp.HospitalSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.Map;

@Service
public class HospitalServiceImpl implements HospitalService {
    @Autowired
    private HospitalRepository hospitalRepository;

    @Override
    public Hospital getByHoscode(String hoscode) {
        return hospitalRepository.getHospitalByHoscode(hoscode);
    }
    @Override
    public void save(Map<String, Object> paramMap) {
        Hospital hospital = JSONObject.parseObject(JSONObject.toJSONString(paramMap),Hospital.class);
        //判断是否存在
        Hospital targetHospital = hospitalRepository.getHospitalByHoscode(hospital.getHoscode());
        if(null != targetHospital) {
            hospital.setStatus(targetHospital.getStatus());
            hospital.setCreateTime(targetHospital.getCreateTime());
            hospital.setUpdateTime(new Date());
            hospital.setIsDeleted(targetHospital.getStatus());
            hospital.setId(targetHospital.getId()); //根据id更新
            hospitalRepository.save(hospital);
        } else {//0：未上线 1：已上线
            hospital.setStatus(0);
            hospital.setCreateTime(new Date());
            hospital.setUpdateTime(new Date());
            hospital.setIsDeleted(0);
            hospitalRepository.save(hospital);
        }
    }



}