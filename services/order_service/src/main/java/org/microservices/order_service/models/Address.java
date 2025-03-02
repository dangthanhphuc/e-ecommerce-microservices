package org.microservices.order_service.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Field(name = "receiver_name")
    private String receiverName;      // Tên người nhận hàng

    @Field(name = "receiver_email")
    private String receiverPhone;     // Số điện thoại người nhận hàng

    private String province;          // Tỉnh hoặc thành phố trực thuộc trung ương (VD: Hà Nội, TP.HCM)

    private String city;              // Thành phố/quận/huyện (VD: Quận 1, Huyện Thanh Trì)

    private String district;          // Quận/huyện (nếu cần phân biệt với city)

    private String ward;              // Phường/xã (VD: Phường Bến Nghé, Xã Tả Thanh Oai)

    @Field(name = "street_address")
    private String streetAddress;     // Địa chỉ chi tiết: số nhà, tên đường, ngõ, ngách

    @Field(name = "is_default")
    private boolean isDefault;        // Đánh dấu địa chỉ mặc định để giao hàng
}
