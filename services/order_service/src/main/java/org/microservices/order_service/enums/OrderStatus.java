package org.microservices.order_service.enums;

public enum OrderStatus {
    PENDING,            // Đơn hàng mới tạo nhưng chưa thanh toán hoặc thanh toán chuyển tiền thất bại sẽ giữ đơn hàng trong 24h  để thanh toán
    CONFIRMED,          // Đã xác nhận đơn hàng (đã thanh toán hoặc ship COD)
    SHIPPING,           // Đang vận chuyển
    COMPLETED,          // Hoàn thành
    CANCELLED,          // Đã hủy
    RETURNED            // Đã trả hàng/hoàn tiền
}
