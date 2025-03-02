package org.microservices.order_service.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.microservices.order_service.enums.OrderStatus;
import org.microservices.order_service.enums.PaymentMethod;
import org.microservices.order_service.models.Address;
import org.microservices.order_service.models.AppliedCoupon;
import org.microservices.order_service.models.OrderItem;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "orders")
public class Order {
    private String id;
    private String orderNumber;
    private Address address;
    private List<OrderItem> orderItems;
    private OrderStatus status;
    private LocalDateTime date;
    private float shippingFee;
    private List<AppliedCoupon> appliedCoupons;
    private double totalAmount;
    private PaymentMethod paymentMethod;
    private String consumerId;

}
