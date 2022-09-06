package com.fanfanfan.yygh.user.service;

import com.fanfanfan.yygh.model.user.UserInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fanfanfan.yygh.vo.user.LoginVo;

import java.util.Map;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author fanfanfan
 * @since 2022-09-06
 */
public interface UserInfoService extends IService<UserInfo> {
    //会员登录
    Map<String, Object> login(LoginVo loginVo);
}
