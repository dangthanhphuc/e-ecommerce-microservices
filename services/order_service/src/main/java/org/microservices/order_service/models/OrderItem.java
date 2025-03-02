package org.microservices.order_service.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {
    @Field("product_id")
    private String productId;         // ID của sản phẩm

    private String name;              // Tên sản phẩm (lưu lại để tránh thay đổi sau này)

    private double price;             // Giá sản phẩm tại thời điểm mua

    private int quantity;             // Số lượng

    @Field("product_image")
    private String productImage;      // URL hình ảnh sản phẩm

    private double subtotal;          // Thành tiền = price * quantity
}
