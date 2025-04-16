package org.microservices.coupon_service.controllers;

import lombok.RequiredArgsConstructor;
import org.microservices.coupon_service.services.ICouponService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
@RequiredArgsConstructor
public class CouponController {

    private final ICouponService couponService;;



}
