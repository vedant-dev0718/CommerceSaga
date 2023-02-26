package com.vedant.CommonService.events;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderedShippedEvent {
    private String shipmentId;
    private String orderId;
    private String shipmentStatus;
}
