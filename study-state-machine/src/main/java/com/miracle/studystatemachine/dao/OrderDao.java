package com.miracle.studystatemachine.dao;

import com.miracle.studystatemachine.domian.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Miracle
 * @date 2020/4/17 11:17
 */
public interface OrderDao extends JpaRepository<Order, Integer> {
}
