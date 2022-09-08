package com.fanfanfan.cmsservice.service;


import com.fanfanfan.yygh.vo.msm.MsmVo;

public interface MsmService {

    boolean send(String PhoneNumbers);
    //发送短信接口
    void sendCode(MsmVo msmVo);

}
