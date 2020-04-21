package com.miracle.study.service;

import com.miracle.study.domian.OrderMaster;

import java.util.Map;

/**
 * @author Miracle
 * @date 2020/4/17 11:18
 */
public interface OrderService {
    /**
     * 创建订单
     * @return
     */
    OrderMaster creat();

    /**
     * 支付
     * @param id
     * @return
     */
    OrderMaster pay(int id);

    /**
     * 发货
     * @param id
     * @return
     */
    OrderMaster deliver(int id);

    /**
     * 收货
     * @param id
     * @return
     */
    OrderMaster receive(int id);

    /**
     * 获取订单信息
     * @return
     */
    Map<Integer, OrderMaster> getOrders();
}
