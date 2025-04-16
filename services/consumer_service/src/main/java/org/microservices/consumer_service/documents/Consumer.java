package org.microservices.consumer_service.documents;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.microservices.consumer_service.models.Address;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "consumers")
public class Consumer {
    @Id
    private String id;
    private String name; // Tên tài khoản
    private String email;
    @Field(name = "phone_number")
    private String phoneNumber;
    private boolean gender;
    private LocalDate dob;
    private List<Address> addresses;
}
