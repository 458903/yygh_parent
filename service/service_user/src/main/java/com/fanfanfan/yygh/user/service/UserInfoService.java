package com.fanfanfan.yygh.user.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fanfanfan.yygh.model.user.UserInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fanfanfan.yygh.vo.user.LoginVo;
import com.fanfanfan.yygh.vo.user.UserAuthVo;
import com.fanfanfan.yygh.vo.user.UserInfoQueryVo;


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

    //定义方法
    UserInfo selectWxInfoOpenId(String openid);

    //用户认证
    void userAuth(Long userId, UserAuthVo userAuthVo);
    //用户列表（条件查询带分页）
    IPage<UserInfo> selectPage(Page<UserInfo> pageParam, UserInfoQueryVo userInfoQueryVo);
    /**
     * 用户锁定
     * @param userId
     * @param status 0：锁定 1：正常
     */
    void lock(Long userId, Integer status);
    /**
     * 详情
     * @param userId
     * @return
     */
    Map<String, Object> show(Long userId);
    /**
     * 认证审批
     * @param userId
     * @param authStatus 2：通过 -1：不通过
     */
    void approval(Long userId, Integer authStatus);

}
