package org.microservices.supplier_service.documents;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "consumers")
public class Consumer {

    @Id
    private String id;
    private String name;
    private String username;
    @Field("tax_code")
    private String taxCode;

}
