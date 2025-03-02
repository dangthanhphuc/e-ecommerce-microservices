package com.microservices.product_service.services;

import com.microservices.product_service.documents.Product;
import com.microservices.product_service.dtos.ProductDTO;
import com.microservices.product_service.exceptions.NotFoundException;
import com.microservices.product_service.repositories.ProductRepo;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService{

    private final ProductRepo productRepo;

    ProductService (ProductRepo productRepo) {
       this.productRepo = productRepo;
    }

    @Override
    public List<Product> products() {
        return productRepo.findAll();
    }

    @Override
    public Product getProductById(String id) {
        return null;
    }

    @Override
    public Product saveProduct(ProductDTO productDTO) {
        // Check supplierId
        //


        Product product = Product.builder()
                .name(productDTO.name())
                .price(productDTO.price())
                .desc(productDTO.desc())
                .supplierId(productDTO.supplierId())
                .build();

        if(productDTO.categories() != null) {
            product.setCategories(product.getCategories());
        }

        return productRepo.save(product);
    }

    @Override
    public Product updateProduct(String productId, ProductDTO productDTO) throws NotFoundException {
        // Check supplierId


        // Check productId
        Product product = productRepo.findByIdAndSupplierId(productId, productDTO.supplierId()).orElseThrow(
                () ->  new NotFoundException("Not found product with id - " + productId + " and supplierId - " + productDTO.supplierId()  )
        );

        product.setDesc(productDTO.desc());
        product.setName(productDTO.name());
        product.setPrice(productDTO.price());
        product.setCategories(productDTO.categories());

        return productRepo.save(product);
    }

    @Override
    public void deleteProduct(String supplierId, String productId) throws NotFoundException {
        // Check supplierId


        // Check productId and supplierId
        Product product = productRepo.findByIdAndSupplierId(productId, supplierId).orElseThrow(
                () ->  new NotFoundException("Not found product with id - " + productId + " and supplierId - " + supplierId  )
        );

        productRepo.delete(product);
    }


}
