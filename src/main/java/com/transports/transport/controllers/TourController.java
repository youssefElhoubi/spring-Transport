package com.transports.transport.controllers;

import com.transports.transport.MapperImplementation.TourMapperImpl;
import com.transports.transport.entities.Delivery;
import com.transports.transport.entities.Tour;
import com.transports.transport.repository.tourRepository;
import com.transports.transport.service.TourService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
