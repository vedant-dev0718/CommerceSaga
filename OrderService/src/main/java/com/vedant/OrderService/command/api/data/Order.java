package com.vedant.OrderService.command.api.data;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "orders")
public class Order {

    @Id
    private String orderId;
    public String productId;
    private String userId;
    private String addressId;
    private Integer quantity;
    private String orderStatus;
}
