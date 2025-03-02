package org.microservices.order_service.enums;

public enum PaymentMethod {
    COD,                // Thanh toán khi nhận hàng
    CREDIT_CARD,        // Thẻ tín dụng
    BANK_TRANSFER,      // Chuyển khoản ngân hàng
    E_WALLET,           // Ví điện tử
    MOMO,               // MoMo
    ZALOPAY             // ZaloPay
}
