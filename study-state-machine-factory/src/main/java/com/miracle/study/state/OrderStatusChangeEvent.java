package com.miracle.study.state;

/**
 * 订单状态改变事件
 * @author Miracle
 * @date 2020/4/17 10:40
 */
public enum OrderStatusChangeEvent {
    // 支付
    PAYED,
    // 发货
    DELIVERY,
    // 确认收货
    RECEIVED;
}
