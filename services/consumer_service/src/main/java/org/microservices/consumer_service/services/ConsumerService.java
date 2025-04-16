package org.microservices.consumer_service.services;

import lombok.RequiredArgsConstructor;
import org.microservices.consumer_service.documents.Consumer;
import org.microservices.consumer_service.dtos.ConsumerDTO;
import org.microservices.consumer_service.exceptions.IdNotFoundException;
import org.microservices.consumer_service.repositories.ConsumerRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConsumerService implements IConsumerService {

    private final ConsumerRepository consumerRepository;

    @Override
    public Consumer create(ConsumerDTO consumerDTO) {
        Consumer consumer = Consumer.builder()
                .name(consumerDTO.name())
                .email(consumerDTO.email())
                .phoneNumber(consumerDTO.phoneNumber())
                .gender(consumerDTO.gender())
                .dob(consumerDTO.dob())
                .build();
        return consumerRepository.save(consumer);
    }



    @Override
    public Consumer update(ConsumerDTO consumerDTO, String id) {
        Consumer exitingConsumer = findById(id);

        exitingConsumer.setName(consumerDTO.name());
        exitingConsumer.setEmail(consumerDTO.email());
        exitingConsumer.setPhoneNumber(consumerDTO.phoneNumber());
        exitingConsumer.setGender(consumerDTO.gender());
        exitingConsumer.setDob(consumerDTO.dob());

        return consumerRepository.save(exitingConsumer);
    }

    @Override
    public Consumer findById(String id) {
        return consumerRepository.findById(id)
                .orElseThrow(
                        () -> new IdNotFoundException("Consumer not found with id: " + id)
                );
    }

    @Override
    public void deleteById(String id) {
        Consumer exitingConsumer = consumerRepository.findById(id)
                .orElseThrow(
                        () -> new IdNotFoundException("Consumer not found with id: " + id)
                );
        if (exitingConsumer != null) {
            consumerRepository.delete(exitingConsumer);
        }
    }
}
