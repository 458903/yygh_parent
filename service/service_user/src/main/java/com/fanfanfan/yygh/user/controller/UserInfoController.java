package com.fanfanfan.yygh.user.controller;


import com.fanfanfan.yygh.common.Utils.AuthContextHolder;
import com.fanfanfan.yygh.common.result.R;
import com.fanfanfan.yygh.model.user.UserInfo;
import com.fanfanfan.yygh.user.service.UserInfoService;
import com.fanfanfan.yygh.vo.user.LoginVo;
import com.fanfanfan.yygh.vo.user.UserAuthVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
@Api(tags = "医院登录接口")
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


    //用户认证接口
    @PostMapping("auth/userAuth")
    public R userAuth(@RequestBody UserAuthVo userAuthVo, HttpServletRequest request) {
        //传递两个参数，第一个参数用户id，第二个参数认证数据vo对象
        userInfoService.userAuth(AuthContextHolder.getUserId(request),userAuthVo);
        return R.ok();
    }

    //获取用户id信息接口
    @GetMapping("auth/getUserInfo")
    public R getUserInfo(HttpServletRequest request) {
        Long userId = AuthContextHolder.getUserId(request);
        UserInfo userInfo = userInfoService.getById(userId);
        return R.ok().data("userInfo",userInfo);
    }
}

