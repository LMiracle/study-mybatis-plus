package com.miracle.study;

import com.miracle.study.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Miracle
 * @date 2020/4/17 11:27
 */

@Slf4j
@SpringBootTest
public class OrderMasterServiceImplTest {


    @Autowired
    private OrderService orderService;

    @Test
    public void testMultThread(){
        orderService.creat();
        orderService.creat();

        orderService.pay(1);

        new Thread(()->{
            orderService.deliver(1);
            orderService.receive(1);
        }).start();

        orderService.pay(2);
        orderService.deliver(2);
        orderService.receive(2);

        System.out.println(orderService.getOrders());
    }
}
