package org.microservices.consumer_service.services;

import org.microservices.consumer_service.documents.Consumer;
import org.microservices.consumer_service.dtos.ConsumerDTO;

public interface IConsumerService {
    Consumer create(ConsumerDTO consumerDTO);
    Consumer update(ConsumerDTO consumerDTO, String id);
    Consumer findById(String id);
    void deleteById(String id);
}
