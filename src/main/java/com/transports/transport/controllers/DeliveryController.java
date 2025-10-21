package com.transports.transport.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deliveries")
public class DeliveryController {
    private final DeliveryController deliveryController;

    public DeliveryController(DeliveryController deliveryController) {
        this.deliveryController = deliveryController;
    }

}
