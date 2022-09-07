package com.fanfanfan.cmsservice.controller;

import com.fanfanfan.cmsservice.service.MsmService;

import com.fanfanfan.yygh.common.result.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/apim/msm")
public class MsmController {
    @Autowired
    private MsmService msmService;
    @GetMapping(value = "/send/{phone}")
   public R code(@PathVariable String phone) {

        boolean flag =msmService.send(phone);
        if (flag){
            return R.ok();
        }else {
            return R.error();
        }
   }
}