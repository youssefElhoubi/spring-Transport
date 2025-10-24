package com.transports.transport.controllers;

import com.transports.transport.DTOS.DelivaryDto;
import com.transports.transport.Mapers.DeliveryMaper;
import com.transports.transport.MapperImplementation.DeliveryMapperImpl;
import com.transports.transport.entities.Delivery;
import com.transports.transport.service.DeliveryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "method allows to get all the Deliveries ", description = "make a request for the end point and get all the existing Deliveries")
//    @ApiResponses( value = {
//            @ApiResponse(responseCode = "200",description = "all the Deliveries "),
//            @ApiResponse(responseCode = "400", description = "Invalid input data")
//    })
    @GetMapping("/all")
    public List<Delivery> all() {
        return deliverySer.findAll();
    }

    @PostMapping
    public ResponseEntity<?> create(@Validated(DelivaryDto.create.class) @RequestBody DelivaryDto dto) {
        Delivery delivary = deliveryMaper.toEntity(dto);
        delivary = deliverySer.save(delivary);
        return ResponseEntity.ok(delivary);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> update(@Validated(DelivaryDto.update.class) @RequestBody DelivaryDto dto, @PathVariable Long id) {
        Delivery delivery = deliverySer.findById(id);
        if (delivery == null) {
            return ResponseEntity.notFound().build();
        }
        delivery = deliveryMaper.toEntity(dto);
        delivery.setId(id);
        delivery = deliverySer.update(delivery);
        return ResponseEntity.ok(delivery);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Delivery delivery = deliverySer.findById(id);
        if (delivery == null) {
            return ResponseEntity.notFound().build();
        }
        deliverySer.Delete(id);
        return ResponseEntity.ok("delivery deleted ");
    }
}
