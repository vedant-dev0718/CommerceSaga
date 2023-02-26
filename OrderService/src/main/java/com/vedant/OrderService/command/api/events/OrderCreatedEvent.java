package com.vedant.OrderService.command.api.events;

import lombok.Data;

@Data
public class OrderCreatedEvent {

    private String orderId;
    public String productId;
    private String userId;
    private String addressId;
    private Integer quantity;
    private String orderStatus;
}
