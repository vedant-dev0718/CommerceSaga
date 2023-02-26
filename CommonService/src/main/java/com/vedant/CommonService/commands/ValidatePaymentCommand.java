package com.vedant.CommonService.commands;

import com.vedant.CommonService.model.CardDetails;
import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Builder
@Data
public class ValidatePaymentCommand {
    @TargetAggregateIdentifier
    private String paymentId;
    private String orderId;
    private CardDetails cardDetails;

}
