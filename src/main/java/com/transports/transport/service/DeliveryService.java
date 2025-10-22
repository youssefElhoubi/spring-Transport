package com.transports.transport.service;

import com.transports.transport.entities.Delivery;
import com.transports.transport.repository.DeliveryRepository;

import java.util.List;

public class DeliveryService {
    private DeliveryRepository deliveryRepository;

    public DeliveryService(DeliveryRepository deliveryService) {
        this.deliveryRepository = deliveryService;
    }

    public List<Delivery> findAll() {
        return deliveryRepository.findAll();
    }
    public Delivery findById(Long id) {
        return deliveryRepository.findById(id).orElseThrow(()->new RuntimeException("no Delivery found with this ID"+ id) );
    }
    public Delivery save (Delivery d){
        return deliveryRepository.save(d);
    }
    public Delivery update (Delivery d){
        Delivery delivery = deliveryRepository.findById(d.getId()).orElseThrow(()-> new RuntimeException("Delivery not found with ID: " + d.getId()));

        delivery.setAddress(d.getAddress());
        delivery.setLatitude(d.getLatitude());
        delivery.setLongitude(d.getLongitude());
        delivery.setWeight(d.getWeight());
        delivery.setVolume(d.getVolume());
        delivery.setPreferredTimeSlot(d.getPreferredTimeSlot());
        delivery.setStatus(d.getStatus());
        delivery.setSequenceOrder(d.getSequenceOrder());
        delivery.setTour(d.getTour()); // if you want to allow updating the tour
        return deliveryRepository.save(delivery);
    }
}
