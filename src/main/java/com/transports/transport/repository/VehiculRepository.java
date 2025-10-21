package com.transports.transport.repository;

import com.transports.transport.entities.Vehicul;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehiculRepository extends JpaRepository<Vehicul,Long> {
}
