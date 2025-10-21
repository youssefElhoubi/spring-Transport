package com.transports.transport.repository;

import com.transports.transport.entities.Tour;
import org.springframework.data.jpa.repository.JpaRepository;

public interface tour extends JpaRepository<Tour, Long> {
}
