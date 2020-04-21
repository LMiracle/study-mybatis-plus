package com.miracle.study.service;

import com.miracle.study.dao.OrderDao;
import com.miracle.study.domian.OrderMaster;
import com.miracle.study.state.OrderStateMachineConfig;
import com.miracle.study.state.OrderStatus;
import com.miracle.study.state.OrderStatusChangeEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineFactory;
import org.springframework.statemachine.persist.StateMachinePersister;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Miracle
 * @date 2020/4/17 11:15
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private StateMachineFactory<OrderStatus, OrderStatusChangeEvent> orderStateMachineFactory;

    @Autowired
    private StateMachinePersister<OrderStatus, OrderStatusChangeEvent, OrderMaster> persister;

    private int id = 1;
    private Map<Integer, OrderMaster> orders = new HashMap<>();

    @Override
    public OrderMaster creat() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setStatus(OrderStatus.WAIT_PAYMENT);
        orderMaster.setId(id++);
        orders.put(orderMaster.getId(), orderMaster);
        return orderMaster;
    }

    @Override
    public OrderMaster pay(int id) {
        OrderMaster orderMaster = orders.get(id);
        System.out.println("threadName=" + Thread.currentThread().getName() + " 尝试支付 id=" + id);
        Message message = MessageBuilder.withPayload(OrderStatusChangeEvent.PAYED).setHeader("order", orderMaster).build();
        if (!sendEvent(message, orderMaster)) {
            System.out.println("threadName=" + Thread.currentThread().getName() + " 支付失败, 状态异常 id=" + id);
        }
        return orders.get(id);
    }

    @Override
    public OrderMaster deliver(int id) {
        OrderMaster orderMaster = orders.get(id);
        System.out.println("threadName=" + Thread.currentThread().getName() + " 尝试发货 id=" + id);
        if (!sendEvent(MessageBuilder.withPayload(OrderStatusChangeEvent.DELIVERY).setHeader("order", orderMaster).build(), orders.get(id))) {
            System.out.println("threadName=" + Thread.currentThread().getName() + " 发货失败，状态异常 id=" + id);
        }
        return orders.get(id);
    }

    @Override
    public OrderMaster receive(int id) {
        OrderMaster orderMaster = orders.get(id);
        System.out.println("threadName=" + Thread.currentThread().getName() + " 尝试收货 id=" + id);
        if (!sendEvent(MessageBuilder.withPayload(OrderStatusChangeEvent.RECEIVED).setHeader("order", orderMaster).build(), orders.get(id))) {
            System.out.println("threadName=" + Thread.currentThread().getName() + " 收货失败，状态异常 id=" + id);
        }
        return orders.get(id);
    }

    @Override
    public Map<Integer, OrderMaster> getOrders() {
        return orders;
    }


    /**
     * 发送订单状态转换事件
     *
     * @param message
     * @param orderMaster
     * @return
     */
    private synchronized boolean sendEvent(Message<OrderStatusChangeEvent> message, OrderMaster orderMaster) {
        synchronized (String.valueOf(orderMaster.getId()).intern()) {
            boolean result = false;
            StateMachine<OrderStatus, OrderStatusChangeEvent> orderStateMachine = orderStateMachineFactory.getStateMachine(OrderStateMachineConfig.orderStateMachineId);
            System.out.println("id=" + orderMaster.getId() + " 状态机 orderStateMachine" + orderStateMachine);
            try {
                orderStateMachine.start();
                //尝试恢复状态机状态
                persister.restore(orderStateMachine, orderMaster);
                System.out.println("id=" + orderMaster.getId() + " 状态机 orderStateMachine id=" + orderStateMachine.getId());
                //添加延迟用于线程安全测试
                Thread.sleep(1000);
                result = orderStateMachine.sendEvent(message);
                //持久化状态机状态
                persister.persist(orderStateMachine, orderMaster);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                orderStateMachine.stop();
            }
            return result;
        }
    }
}
