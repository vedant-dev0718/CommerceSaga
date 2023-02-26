package com.vedant.OrderService.command.api.events;

import com.vedant.CommonService.events.OrderCompleteEvent;
import com.vedant.OrderService.command.api.data.Order;
import com.vedant.OrderService.command.api.data.OrderRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class OrderEventsHandler {

    public OrderEventsHandler(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    private OrderRepository orderRepository;

    @EventHandler
    public void on(OrderCreatedEvent event) {
        Order order = new Order();
        BeanUtils.copyProperties(event, order);
        orderRepository.save(order);
    }

    @EventHandler
    public void on(OrderCompleteEvent event) {
        Order order =
                orderRepository.findById(event.getOrderId()).get();
        order.setOrderStatus(event.getOrderStatus());
        orderRepository.save(order);
    }
}
