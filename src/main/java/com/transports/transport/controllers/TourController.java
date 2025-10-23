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
    @PatchMapping("/{id}")
    public ResponseEntity<?> update(@Validated(TourDto.update.class) @RequestBody TourDto dto, @PathVariable Long id) {
        Tour tour = tourService.findById(id);
        if (tour == null) {
            return ResponseEntity.notFound().build();
        }
        tour = tourMapper.toEntity(dto);
        tour = tourService.update(tour);
        return ResponseEntity.ok(tour);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Tour tour = tourService.findById(id);
        if (tour == null) {
            return ResponseEntity.notFound().build();
        }
        tourService.deleteById(id);
        return  ResponseEntity.ok("tour deleted ");
    }


}
