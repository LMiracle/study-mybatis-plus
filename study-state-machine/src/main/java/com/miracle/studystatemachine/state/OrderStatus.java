package com.miracle.studystatemachine.state;

/**
 * 订单状态
 * @author Miracle
 * @date 2020/4/17 10:38
 */
public enum OrderStatus {
    // 待支付
    WAIT_PAYMENT,
    // 待发货
    WAIT_DELIVER,
    // 待收货
    WAIT_RECEIVE,
    // 订单结束
    FINISH;
}
