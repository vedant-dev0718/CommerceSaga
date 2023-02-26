package com.vedant.OrderService.command.api.command;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
public class CreateOrderCommand {

    @TargetAggregateIdentifier
    private String orderId;
    public String productId;
    private String userId;
    private String addressId;
    private Integer quantity;
    private String orderStatus;
}
