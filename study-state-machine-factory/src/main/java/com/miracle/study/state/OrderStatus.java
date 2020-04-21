package com.miracle.study.state;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 订单状态
 * @author Miracle
 * @date 2020/4/17 10:38
 */
@Getter
@AllArgsConstructor
public enum OrderStatus {
    // 待支付
    WAIT_PAYMENT(0),
    // 待发货
    WAIT_DELIVER(1),
    // 待收货
    WAIT_RECEIVE(2),
    // 订单结束
    FINISH(3);

    private Integer stateId;
}
