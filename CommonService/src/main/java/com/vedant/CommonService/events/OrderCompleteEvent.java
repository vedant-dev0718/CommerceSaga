package com.vedant.CommonService.events;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderCompleteEvent {
    private String orderId;
    private String orderStatus;
}
