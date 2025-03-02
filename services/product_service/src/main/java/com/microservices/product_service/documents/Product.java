package com.microservices.product_service.documents;

import com.microservices.product_service.models.Category;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;
@Builder
@Document(collection = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @Field( targetType = FieldType.OBJECT_ID)
    private String id;

    private String name;

    private float price;

    private String desc;

    private List<Category> categories;

    @Field("remaining_quantity")
    private int remainingQuantity;

    @Field("supplier_id")
    private String supplierId;

}
