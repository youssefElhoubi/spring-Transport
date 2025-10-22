package com.transports.transport.service;

import com.transports.transport.repository.DeliveryRepository;

public class DeliveryService {
    private DeliveryRepository deliveryService;

    public DeliveryService(DeliveryRepository deliveryService) {
        this.deliveryService = deliveryService;
    }
}
