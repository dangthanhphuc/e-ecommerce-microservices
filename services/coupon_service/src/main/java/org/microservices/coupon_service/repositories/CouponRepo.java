package org.microservices.coupon_service.repositories;

import org.microservices.coupon_service.documents.Coupon;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponRepo extends MongoRepository<Coupon, String>{
}
