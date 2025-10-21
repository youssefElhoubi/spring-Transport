package com.transports.transport.entities;

import com.transports.transport.enums.DeliveryStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tour")
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date ;
    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicul vehicle ;
    private List<Delivery> deliveries ;
    private Double totalDistance ;
    private DeliveryStatus status ;
    @ManyToOne
    @JoinColumn(name = "warehouse_id")
    private Warehouse warehouse ;
}
