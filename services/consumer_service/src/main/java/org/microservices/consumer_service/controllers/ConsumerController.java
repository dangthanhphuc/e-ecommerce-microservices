package org.microservices.consumer_service.controllers;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.microservices.consumer_service.documents.Consumer;
import org.microservices.consumer_service.dtos.ConsumerDTO;
import org.microservices.consumer_service.responses.ConsumerResponse;
import org.microservices.consumer_service.responses.ResponseObject;
import org.microservices.consumer_service.services.IConsumerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
@RequiredArgsConstructor
public class ConsumerController {

    private final IConsumerService consumerService;

    @PostMapping("")
    public ResponseEntity<ResponseObject<ConsumerResponse>> create(
            @Valid @RequestBody ConsumerDTO consumerDTO
    ) {
        Consumer consumer = consumerService.create(consumerDTO);

        return ResponseEntity.ok().body(
          ResponseObject.success(ConsumerResponse.fromConsumer(consumer), "Consumer created successfully")
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseObject<ConsumerResponse>> update(
            @Valid @RequestBody ConsumerDTO consumerDTO,
            @PathVariable String id
    ) {
        Consumer consumer = consumerService.update(consumerDTO, id);

        return ResponseEntity.ok().body(
                ResponseObject.success(ConsumerResponse.fromConsumer(consumer), "Consumer created successfully")
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseObject<String>> deleteById(
            @PathVariable String id
    ) {
        consumerService.deleteById(id);

        return ResponseEntity.ok().body(
                ResponseObject.success("Deleted", "Consumer created successfully")
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject<ConsumerResponse>> findById(
            @PathVariable String id
    ) {
        Consumer consumer = consumerService.findById(id);

        return ResponseEntity.ok().body(
                ResponseObject.success(ConsumerResponse.fromConsumer(consumer), "Consumer created successfully")
        );
    }

}
