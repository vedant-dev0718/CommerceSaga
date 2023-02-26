package com.vedant.PaymentService.command.api.events;

import com.vedant.CommonService.events.PaymentProcessedEvent;
import com.vedant.PaymentService.command.api.data.Payment;
import com.vedant.PaymentService.command.api.data.PaymentRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class PaymentEventHandler {

    public PaymentEventHandler(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    private PaymentRepository paymentRepository;


    @EventHandler
    public void on(PaymentProcessedEvent event){
        Payment payment =
                Payment.builder()
                        .paymentId(event.getPaymentId())
                        .orderId(event.getOrderId())
                        .paymentStatus("COMPLETED")
                        .timeStamp(new Date())
                        .build();

        paymentRepository.save(payment);
    }
}
