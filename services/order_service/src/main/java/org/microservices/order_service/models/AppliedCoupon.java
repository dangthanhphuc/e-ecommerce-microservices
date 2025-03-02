package org.microservices.order_service.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppliedCoupon {
    private String couponId;
    private String couponCode;
    private double discountAmount;
}
