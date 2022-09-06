package com.fanfanfan.yygh.user.controller;


import com.fanfanfan.yygh.common.result.R;
import com.fanfanfan.yygh.user.service.UserInfoService;
import com.fanfanfan.yygh.vo.user.LoginVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author fanfanfan
 * @since 2022-09-06
 */
@RestController
@RequestMapping("/user/user-info")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @ApiOperation(value = "会员登录")
    @PostMapping("login")
    public R login(@RequestBody LoginVo loginVo) {
        Map<String, Object> info = userInfoService.login(loginVo);
        return R.ok().data(info);
    }
}

