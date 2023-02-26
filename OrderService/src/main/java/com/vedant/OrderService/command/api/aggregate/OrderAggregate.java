package com.vedant.OrderService.command.api.aggregate;

import com.vedant.CommonService.commands.CompleteOrderCommand;
import com.vedant.CommonService.events.OrderCompleteEvent;
import com.vedant.OrderService.command.api.command.CreateOrderCommand;
import com.vedant.OrderService.command.api.events.OrderCreatedEvent;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
@NoArgsConstructor
@AllArgsConstructor
public class OrderAggregate {

    @AggregateIdentifier
    private String orderId;
    public String productId;
    private String userId;
    private String addressId;
    private Integer quantity;
    private String orderStatus;


    @CommandHandler
    public OrderAggregate(CreateOrderCommand createOrderCommand) {
        //Validate The Command
        OrderCreatedEvent orderCreatedEvent =
                new OrderCreatedEvent();
        BeanUtils.copyProperties(createOrderCommand, orderCreatedEvent);
        AggregateLifecycle.apply(orderCreatedEvent);
    }

    @EventSourcingHandler
    public void on(OrderCreatedEvent event) {
        this.orderStatus = event.getOrderStatus();
        this.userId = event.getUserId();
        this.orderId = event.getOrderId();
        this.quantity = event.getQuantity();
        this.productId = event.getProductId();
        this.addressId = event.getAddressId();
    }

    @CommandHandler
    public void handle(CompleteOrderCommand completeOrderCommand) {
        OrderCompleteEvent orderCompleteEvent =
                OrderCompleteEvent.builder()
                        .orderStatus(completeOrderCommand.getOrderStatus())
                        .orderId(completeOrderCommand.getOrderId())
                        .build();

        AggregateLifecycle.apply(orderCompleteEvent);
    }

    @EventSourcingHandler
    public void on(OrderCompleteEvent event) {
        this.orderStatus = event.getOrderStatus();

    }


}
