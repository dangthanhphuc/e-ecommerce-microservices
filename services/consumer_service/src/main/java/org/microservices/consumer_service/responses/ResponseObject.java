package org.microservices.consumer_service.responses;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ResponseObject<T> {
//    private HttpStatus httpStatus;
    private LocalDateTime timestamp;
    private String message;
    private T data;
//    private ErrorDetail errorDetail;

//    @Data
//    @Builder
//    public static class ErrorDetail {
//        private String errorCode;
//        private String errorMessage;
//    }

    public static <T> ResponseObject<T> success(T data, String message){
        return ResponseObject.<T>builder()
//                .httpStatus(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .message(message)
                .data(data)
                .build();
    }

    public static <T> ResponseObject<T> error(String message) {
        return ResponseObject.<T>builder()
                .timestamp(LocalDateTime.now())
//                .httpStatus(httpStatus)
                .message(message)
//                .errorDetail(errorDetail)
                .build();
    }
}
