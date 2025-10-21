package com.transports.transport.service;

import com.transports.transport.repository.tourRepository;

public class TourService {
    private tourRepository tourRepository;

    public TourService(tourRepository tourRepository) {
        this.tourRepository = tourRepository;
    }
}
