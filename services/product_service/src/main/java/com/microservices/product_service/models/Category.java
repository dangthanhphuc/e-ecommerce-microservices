package com.microservices.product_service.models;

import java.util.List;

public record Category(
        String name,
        List<CategoryDetail> details
) {
}
