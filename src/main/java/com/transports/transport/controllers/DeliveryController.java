package com.transports.transport.controllers;

import com.transports.transport.Mapers.DeliveryMaper;
import com.transports.transport.entities.Delivery;
import com.transports.transport.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/deliveries")
public class DeliveryController {
    private final DeliveryService deliverySer;
    private final DeliveryMaper deliveryMaper;
    @Autowired
    public DeliveryController(DeliveryService deliveryService, DeliveryMaper deliveryMaper) {
        this.deliverySer = deliveryService;
        this.deliveryMaper = deliveryMaper;
    }
    @GetMapping("/all")
    public List<Delivery> all(){
        List<Delivery> deliveries = deliverySer.findAll();
        return deliveries;
    }
//    public String Create(@Validated )

}
