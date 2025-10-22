package com.transports.transport.controllers;

import com.transports.transport.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deliveries")
public class DeliveryController {
    private final DeliveryService deliverySer;
    @Autowired
    public DeliveryController(DeliveryService deliveryService) {
        this.deliverySer = deliveryService;
    }

}
