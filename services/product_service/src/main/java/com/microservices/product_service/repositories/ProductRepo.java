package com.microservices.product_service.repositories;

import com.microservices.product_service.documents.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepo extends MongoRepository<Product, String> {

    Optional<Product> findByIdAndSupplierId(String id, String supplierId);
}
