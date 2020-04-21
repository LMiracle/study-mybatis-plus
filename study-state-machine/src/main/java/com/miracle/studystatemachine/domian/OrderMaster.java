package com.miracle.studystatemachine.domian;

import com.miracle.studystatemachine.state.OrderStatus;
import lombok.Data;

import javax.persistence.*;

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
