package com.miracle.studystatemachine.service;

import com.miracle.studystatemachine.domian.Order;

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
    Order creat();

    /**
     * 支付
     * @param id
     * @return
     */
    Order pay(int id);

    /**
     * 发货
     * @param id
     * @return
     */
    Order deliver(int id);

    /**
     * 收货
     * @param id
     * @return
     */
    Order receive(int id);

    /**
     * 获取订单信息
     * @return
     */
    Map<Integer, Order> getOrders();
}
