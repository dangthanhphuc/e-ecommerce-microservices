package com.microservices.product_service.services;

import com.microservices.product_service.dtos.ProductDTO;
import com.microservices.product_service.documents.Product;
import com.microservices.product_service.exceptions.NotFoundException;

import java.util.List;

public interface IProductService {
    List<Product> products();
    Product getProductById(String id);
    Product saveProduct(ProductDTO productDTO);
    Product updateProduct(String productId, ProductDTO productDTO) throws NotFoundException;
    void deleteProduct(String supplierId, String productId) throws NotFoundException;
}
