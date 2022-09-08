package com.fanfanfan.yygh.user.client;

import com.fanfanfan.yygh.model.user.Patient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "service-user")
@Repository
public interface PatientFeignClient {
    //获取就诊人
    @GetMapping("/ucener/user-info/patient/auth/get/{id}")
    Patient getPatient(@PathVariable("id") Long id);
}