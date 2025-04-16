package org.microservices.consumer_service.repositories;

import org.microservices.consumer_service.documents.Consumer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumerRepository extends MongoRepository<Consumer, String> {
}
