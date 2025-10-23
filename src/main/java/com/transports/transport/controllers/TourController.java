package com.transports.transport.controllers;

import com.transports.transport.MapperImplementation.TourMapperImpl;
import com.transports.transport.repository.tourRepository;

public class TourController {
    private final tourRepository tourRepository;
    private final TourMapperImpl tourMapper;
    public TourController(tourRepository tourRepository, TourMapperImpl tourMapper) {
        this.tourRepository=tourRepository;
        this.tourMapper =tourMapper;
    }

}
