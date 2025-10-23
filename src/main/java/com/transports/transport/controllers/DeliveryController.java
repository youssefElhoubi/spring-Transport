package com.transports.transport.controllers;

import com.transports.transport.DTOS.DelivaryDto;
import com.transports.transport.Mapers.DeliveryMaper;
import com.transports.transport.MapperImplementation.DeliveryMapperImpl;
import com.transports.transport.entities.Delivery;
import com.transports.transport.service.DeliveryService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deliveries")
public class DeliveryController {
    private final DeliveryService deliverySer;
    private final DeliveryMaper deliveryMaper;

    public DeliveryController(DeliveryService deliveryService, DeliveryMapperImpl deliveryMaper) {
        this.deliverySer = deliveryService;
        this.deliveryMaper = deliveryMaper;
    }
    @GetMapping("/all")
    public List<Delivery> all(){
        List<Delivery> deliveries = deliverySer.findAll();
        return deliveries;
    }
    @PostMapping
    public ResponseEntity<?> Create(@Validated(DelivaryDto.create.class) @RequestBody DelivaryDto dto){
        Delivery delivary = deliveryMaper.toEntity(dto);
        delivary= deliverySer.save(delivary);
        return ResponseEntity.ok(delivary);
    }

}
