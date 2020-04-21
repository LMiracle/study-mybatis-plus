package com.miracle.study.domian;

import com.miracle.study.state.OrderStatus;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author Miracle
 * @date 2020/4/17 11:11
 */
@Data
@Entity
@Table(name = "order_master")
public class OrderMaster {

    @Id
    private Integer id;

    @Transient
    private OrderStatus status;

    private Integer stateId;

}
