package com.transports.transport.controllers;

import com.transports.transport.DTOS.DelivaryDto;
import com.transports.transport.DTOS.TourDto;
import com.transports.transport.MapperImplementation.TourMapperImpl;
import com.transports.transport.entities.Delivery;
import com.transports.transport.entities.Tour;
import com.transports.transport.repository.tourRepository;
import com.transports.transport.service.TourService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tour")
public class TourController {
    private final TourService tourService;
    private final TourMapperImpl tourMapper;
    public TourController(TourService tourService, TourMapperImpl tourMapper) {
        this.tourService=tourService;
        this.tourMapper =tourMapper;
    }
    @GetMapping("/all")
    public List<Tour> all() {
        return tourService.findAll();
    }
    @PostMapping
    public ResponseEntity<?> create(@Validated(TourDto.create.class) @RequestBody TourDto dto) {
        Tour tour = tourMapper.toEntity(dto);
        tour = tourService.save(tour);
        return ResponseEntity.ok(tour);
    }


}
