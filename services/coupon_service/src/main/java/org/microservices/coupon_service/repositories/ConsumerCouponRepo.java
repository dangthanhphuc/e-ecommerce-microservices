package org.microservices.coupon_service.repositories;

import org.microservices.coupon_service.documents.ConsumerCoupon;
import org.microservices.coupon_service.documents.ids.ConsumerCouponId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumerCouponRepo extends MongoRepository<ConsumerCoupon, ConsumerCouponId> {

}
