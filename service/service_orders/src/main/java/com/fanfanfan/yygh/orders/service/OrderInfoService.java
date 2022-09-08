package com.fanfanfan.yygh.orders.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fanfanfan.yygh.model.order.OrderInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fanfanfan.yygh.vo.order.OrderQueryVo;

/**
 * <p>
 * 订单表 服务类
 * </p>
 *
 * @author fanfanfan
 * @since 2022-09-08
 */
public interface OrderInfoService extends IService<OrderInfo> {
    //保存订单
    Long saveOrder(String scheduleId, Long patientId);
    /**
     * 分页列表
     */
    IPage<OrderInfo> selectPage(Page<OrderInfo> pageParam, OrderQueryVo orderQueryVo);
    /**
     * 获取订单详情
     */
    OrderInfo getOrderInfo(Long id);
}
