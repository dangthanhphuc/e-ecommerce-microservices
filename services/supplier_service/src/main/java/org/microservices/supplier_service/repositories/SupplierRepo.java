package org.microservices.supplier_service.repositories;

import org.microservices.supplier_service.documents.Consumer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepo extends MongoRepository<Consumer, String>{
}
