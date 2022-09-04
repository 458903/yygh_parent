package com.fanfanfan.yygh.hosp.controller;

import com.fanfanfan.yygh.common.exception.YyghException;
import com.fanfanfan.yygh.hosp.bean.Result;
import com.fanfanfan.yygh.hosp.repository.HospitalRepository;
import com.fanfanfan.yygh.hosp.service.HospitalSetService;
import com.fanfanfan.yygh.hosp.utils.MD5;
import com.fanfanfan.yygh.hosp.service.HospitalService;
import com.fanfanfan.yygh.hosp.utils.HttpRequestHelper;
import com.fanfanfan.yygh.model.hosp.Hospital;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Api(tags = "医院管理API接口")
@RestController
@RequestMapping("/api/hosp")
public class ApiController {


    @Autowired
    private HospitalService hospitalService;

    @Autowired
    private HospitalSetService hospitalSetService;

    @ApiOperation(value = "上传医院")
    @PostMapping("saveHospital")
    public Result saveHospital(HttpServletRequest request) {
        Map<String, Object> paramMap = HttpRequestHelper.switchMap(request.getParameterMap());

        hospitalService.save(paramMap);
        return Result.ok();
    }
    }

/*    @ApiOperation(value = "获取医院信息")
    @PostMapping("hospital/show")
    public Result hospital(HttpServletRequest request) {
        Map<String, Object> paramMap = HttpRequestHelper.switchMap(request.getParameterMap());
        //必须参数校验
        String hoscode = (String)paramMap.get("hoscode");
        if(StringUtils.isEmpty(hoscode)) {
            throw new YyghException(20001,"失败");
        }
        //签名校验 略
        Hospital hospital = hospitalService.getByHoscode(hoscode);
        return Result.ok(hospital);
    }*/
