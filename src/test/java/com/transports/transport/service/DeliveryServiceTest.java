package com.transports.transport.service;

import com.transports.transport.entities.Delivery;
import com.transports.transport.repository.DeliveryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.beans.Expression;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class DeliveryServiceTest {
    @Mock
    private DeliveryRepository deliveryRepository;

    @InjectMocks
    private DeliveryService deliveryService;

    @Test
    void testFindById_found() {
        Delivery delivery = new Delivery();
        delivery.setId(1L);
        when(deliveryRepository.findById(1L)).thenReturn(Optional.of(delivery));
        Delivery result = deliveryService.findById(1L);
        assertNotNull(result);
        assertEquals(1L, result.getId());
    }
    @Test
    void testFindById_notFount(){
        Delivery delivery = new Delivery();
        when(deliveryRepository.findById(1L)).thenReturn(Optional.empty());
        Exception expression = assertThrows( RuntimeException.class,()->{
            deliveryService.findById(1l);
        });
        assertTrue(expression.getMessage().contains("no Delivery found with this ID"));
    }
}