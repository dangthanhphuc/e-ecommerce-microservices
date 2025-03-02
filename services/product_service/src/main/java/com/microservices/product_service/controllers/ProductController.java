package com.microservices.product_service.controllers;

import com.microservices.product_service.documents.Product;
import com.microservices.product_service.dtos.ProductDTO;
import com.microservices.product_service.exceptions.NotFoundException;
import com.microservices.product_service.responses.ResponseObject;
import com.microservices.product_service.services.IProductService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping()
@RequiredArgsConstructor
public class ProductController {

    private final IProductService productService;

    @GetMapping("")
    public ResponseEntity<ResponseObject<List<Product>>> getAll() {
        List<Product> products = productService.products();
        return ResponseEntity.ok().body(
                ResponseObject.success(
                        products,
                        "Products retrieved successfully!"
                )
        );
    }

    @PostMapping("")
    public ResponseEntity<ResponseObject<Product>> add(
            @Valid @RequestBody ProductDTO productDTO
    ) {
        Product product = productService.saveProduct(productDTO);

        return ResponseEntity.ok().body(
                ResponseObject.success(
                        product,
                        "Product added successfully !"
                )
        );
    }

    @PutMapping("/{productId}")
    public ResponseEntity<ResponseObject<Product>> update(
            @NotBlank(message = "Product ID is required")
            @PathVariable String productId,
            @Valid @RequestBody ProductDTO productDTO
    ) throws NotFoundException {
        Product product = productService.updateProduct(productId, productDTO);
        return ResponseEntity.ok().body(
                ResponseObject.success(
                        product,
                        "Product updated successfully!"
                )
        );
    }

    @DeleteMapping()
    public ResponseEntity<ResponseObject<Product>> delete(
            @RequestParam(name = "supplierId", required = true) String supplierId,
            @RequestParam(name = "productId", required = true) String productId
    ) throws NotFoundException {
        productService.deleteProduct(supplierId, productId);
        return ResponseEntity.ok().body(
            ResponseObject.success(
                    null,
                    "Product deleted successfully!"
            )
        );
    }

}
