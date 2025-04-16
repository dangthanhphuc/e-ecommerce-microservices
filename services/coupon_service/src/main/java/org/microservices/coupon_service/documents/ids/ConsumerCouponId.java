package org.microservices.coupon_service.documents.ids;


import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
public class ConsumerCouponId {
    @Field("consumer_id")
    private String consumerId;
    @Field("coupon_id")
    private String couponId;
}
