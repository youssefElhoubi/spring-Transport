package com.transports.transport.service;

import com.transports.transport.entities.Delivery;
import com.transports.transport.repository.DeliveryRepository;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DeliveryServiceTest {
    @Mock
    private DeliveryRepository deliveryRepository;

    @InjectMocks
    private DeliveryService deliveryService;
    @Test
    public void testFindById(){
        Delivery delivery = new Delivery();
        delivery.setId(1L);
//        when(deliveryRepository.findById(1L))
        when(deliveryRepository.findById(1L)).thenReturn(Optional.of(delivery));
        Optional<Delivery> result = deliveryRepository.findById(1L);
        assertNotNull(result);
        assertEquals(1L,result.get().getId());

    }
}