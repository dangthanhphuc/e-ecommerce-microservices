package org.microservices.consumer_service.models;

import org.springframework.data.mongodb.core.mapping.Field;

public record Address(
        @Field(name = "receiver_name")
        String receiverName, 
        @Field(name = "receiver_email")
        String receiverPhone,
        String province,
        String city,
        String district,
        String ward,
        @Field(name = "street_address")
        String streetAddress,
        @Field(name = "is_default")
        boolean isDefault
) {
}
