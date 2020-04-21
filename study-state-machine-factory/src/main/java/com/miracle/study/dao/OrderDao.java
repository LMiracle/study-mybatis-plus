package com.miracle.study.dao;

import com.miracle.study.domian.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Miracle
 * @date 2020/4/17 11:17
 */
public interface OrderDao extends JpaRepository<OrderMaster, Integer> {
}
