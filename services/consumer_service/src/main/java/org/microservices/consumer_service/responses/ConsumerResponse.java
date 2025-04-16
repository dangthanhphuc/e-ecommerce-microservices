package org.microservices.consumer_service.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import org.microservices.consumer_service.documents.Consumer;

import java.time.LocalDate;

@Data
@Builder
public class ConsumerResponse {
    private String name;
    private String email;
    private boolean gender;
    @JsonProperty("phone_number")
    private String phoneNumber;
    private LocalDate dob;

    public static ConsumerResponse fromConsumer(Consumer consumer) {
        return ConsumerResponse.builder()
                .name(consumer.getName())
                .email(consumer.getEmail())
                .gender(consumer.isGender())
                .phoneNumber(consumer.getPhoneNumber())
                .dob(consumer.getDob())
                .build();
    }
}
