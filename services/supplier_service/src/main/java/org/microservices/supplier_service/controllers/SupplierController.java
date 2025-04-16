package org.microservices.supplier_service.controllers;

import lombok.RequiredArgsConstructor;
import org.microservices.supplier_service.services.ISupplierService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
@RequiredArgsConstructor
public class SupplierController {

    private final ISupplierService supplierService;;



}
